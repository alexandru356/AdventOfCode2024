import java.io.*;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws Exception {
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            String line;

            while((line = reader.readLine()) != null){
                String[] numbers = line.trim().split("\\s+");
                if(numbers.length == 2){
                    left.add(Integer.parseInt(numbers[0]));
                    right.add(Integer.parseInt(numbers[1]));
                }
            }
            reader.close();

            Collections.sort(left);
            Collections.sort(right);

            int totalDistance = 0;

            for(int i = 0; i < left.size(); i++){
                totalDistance += Math.abs(left.get(i) - right.get(i));
            }
            System.err.println(totalDistance);

        } catch (Exception e) {
           System.out.println(e);
        }
    }
}
