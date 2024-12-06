
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("Day5/input.txt"));

        String line; 

        List<String> rules = new ArrayList<>();
        List<List<Integer>> updates = new ArrayList<>();
        boolean isRules = true;


        while((line = br.readLine()) != null) {
            if(line.trim().isEmpty()){
                isRules = false;
                continue;
            }

            if(isRules){
                rules.add(line);
            } else{
                List<Integer> update = new ArrayList<>();
                for(String s : line.split(",")){
                    update.add(Integer.parseInt(s));
                }
                updates.add(update);
            }
        }   

        br.close();

        List<int[]> parsedRules = new ArrayList<>();
        int count = 0;

        for(String rule : rules){
            String[] parts = rule.split("\\|");
            int before = Integer.parseInt(parts[0]);
            int after = Integer.parseInt(parts[1]);
            parsedRules.add(new int[]{before,after});
        }
        for(List<Integer> update : updates){
            if(isUpdateValid(update, parsedRules)){
                int middlePages = update.get(update.size() / 2);

                count += middlePages;
            }
        }
        
        System.out.print(count);
    }



    public static boolean isUpdateValid(List<Integer> update, List<int[]> rules){

        for(int[] rule : rules){
            int before = rule[0];
            int after = rule[1];

            if(update.contains(before) && update.contains(after)){
                
                int indexBefore = update.indexOf(before);
                int indexAfter= update.indexOf(after);

                if(indexBefore > indexAfter){
                    return false;
                }
            }
            
        }
        return true;
    }
    
}
