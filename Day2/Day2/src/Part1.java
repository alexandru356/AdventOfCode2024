
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Part1 {

    public static void main(String[] args) throws Exception {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

            ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] numbers = line.trim().split("\\s+");

                ArrayList<Integer> row = new ArrayList<>();
                for (String num : numbers) {
                    row.add(Integer.parseInt(num));
                }
                rows.add(row);
            }

            reader.close();

            int safeReports = 0;

            for(ArrayList<Integer> report : rows){
                boolean ok = true;
                boolean isIncreasing = true;
                boolean isDecreasing = true;

                for(int i = 0; i < report.size() - 1; i++){
                    int diff =  report.get(i + 1) - report.get(i);

                    if(!(1 <= Math.abs(diff) && Math.abs(diff) <= 3)){
                        ok = false;
                        break;
                    }
                    if(diff > 0 ){
                        isDecreasing = false;
                    }
                    if(diff < 0 ){
                        isIncreasing = false;
                    }
                }

                if(ok && (isIncreasing || isDecreasing)){
                    safeReports++;
                }
            }

            System.out.println("Answer: " + safeReports);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
