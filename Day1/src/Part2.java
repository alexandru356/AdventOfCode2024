
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


public class Part2 {
    public static void main(String[] args) {
        try {
            
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();

            String line ;

            while((line = reader.readLine()) != null){
                String[] numbers = line.trim().split("\\s+");
                if(numbers.length == 2){
                    left.add(Integer.parseInt(numbers[0]));
                    right.add(Integer.parseInt(numbers[1]));
                }
            }
            reader.close();

            HashMap<Integer, Integer> rightCount = new HashMap<>();

            for (int num : right) {
                rightCount.put(num, rightCount.getOrDefault(num, 0) + 1);
            }

            int totalSimili = 0;

            for(int num : left){
                if(rightCount.containsKey(num)){
                    totalSimili += num * rightCount.get(num);
                }
            }
            System.out.println("Total Similarity Score: " + totalSimili);

        } catch (Exception e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
