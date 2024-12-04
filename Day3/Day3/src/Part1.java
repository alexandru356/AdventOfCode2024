
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) throws Exception {
        
        try {
            
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

            String line;
            
            StringBuilder content = new StringBuilder();

            while((line = reader.readLine())!= null){
                content.append(line);
            }

            String data = content.toString();

            System.out.println(processMuls(data));

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static int processMuls(String data){
        Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)");
        Matcher matcher = pattern.matcher(data);

        int totalSum = 0;

        while(matcher.find()){
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            totalSum += x * y;
        }

        return totalSum;
    }
}
