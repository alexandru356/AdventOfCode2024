
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void main(String[] args) throws Exception {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

            String line;

            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            String data = content.toString();

            System.out.println(processMuls(data));
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int processMuls(String data) {
        Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)|do\\(\\)|don't\\(\\)");
        Matcher matcher = pattern.matcher(data);

        boolean isEnabled = true;  
        int totalSum = 0;


        while (matcher.find()) {
            String match = matcher.group();
            
            if (match.equals("do()")) {
                isEnabled = true; 
            } else if (match.equals("don't()")) {
                isEnabled = false;  
            } else if (match.startsWith("mul(") && isEnabled) {
                String[] parts = match.substring(4, match.length() - 1).split(",");
                int x = Integer.parseInt(parts[0].trim());
                int y = Integer.parseInt(parts[1].trim());
                totalSum += x * y;  
            }
        }

        return totalSum;
    }
}
