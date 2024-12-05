
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("Day5/input.txt"));

        String line;
        boolean isRules = true;

        List<String> rules = new ArrayList<>();
        List<List<Integer>> updates = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) {
                isRules = false;
                continue;
            }

            if (isRules) {
                rules.add(line);
            } else {
                List<Integer> update = new ArrayList<>();
                for (String s : line.split(",")) {
                    update.add(Integer.parseInt(s));
                }
                updates.add(update);
            }
        }

        List<int[]> parsedRules = new ArrayList<>();
        for (String rule : rules) {
            String[] parts = rule.split("\\|");
            int before = Integer.parseInt(parts[0]);
            int after = Integer.parseInt(parts[1]);
            parsedRules.add(new int[]{before, after});
        }

        br.close();

        int sum = 0;
        for (List<Integer> update : updates) {
            if (!isUpdateValid(update, parsedRules)) {  
                List<Integer> sortedUpdate = new ArrayList<>(update);
                sort(sortedUpdate, parsedRules);
                int middlePage = sortedUpdate.get(sortedUpdate.size() / 2);
                sum += middlePage;
            }
        }
        System.out.println("Sum of middle pages: " + sum);

    }

    public static boolean isUpdateValid(List<Integer> update, List<int[]> rules) {
        for (int[] rule : rules) {
            int before = rule[0];
            int after = rule[1];

            if (update.contains(before) && update.contains(after)) {
                int indexBefore = update.indexOf(before);
                int indexAfter = update.indexOf(after);

                if (indexBefore > indexAfter) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void sort(List<Integer> update, List<int[]> rules) {
    Collections.sort(update, (a, b) -> {

        for (int[] rule : rules) {
            if (rule[0] == a && rule[1] == b) return -1;
            if (rule[0] == b && rule[1] == a) return 1;
        }
        return Integer.compare(b, a); 
    });
}
}
