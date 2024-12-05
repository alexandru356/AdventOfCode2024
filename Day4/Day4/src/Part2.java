
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("Day4/input.txt"));

        List<String> rows = new ArrayList<>();
        List<List<Character>> columns = new ArrayList<>();
        String line;
        int p2 = 0;

        while ((line = br.readLine()) != null) {

            rows.add(line);
            List<Character> columnList = new ArrayList<>();
            for (char ch : line.toCharArray()) {
                columnList.add(ch);
            }
            columns.add(columnList);

        }
        br.close();

        

        for (int i = 1; i < rows.size() - 1; i++) {
            for (int j = 1; j < columns.get(i).size() - 1; j++) {
                if (isXMAS(rows, i, j)) {
                    p2++;
                }
            }
        }  

        System.out.println("Part 2: " + p2);
    }


    
    private static boolean isXMAS(List<String> rows, int i, int j) {
        // Check all possible combinations of MAS and SAM patterns
        char tl = rows.get(i - 1).charAt(j - 1); // top-left
        char tr = rows.get(i - 1).charAt(j + 1); // top-right
        char c = rows.get(i).charAt(j);          // center
        char bl = rows.get(i + 1).charAt(j - 1); // bottom-left
        char br = rows.get(i + 1).charAt(j + 1); // bottom-right
    

        if (c != 'A') return false;

        boolean topLeftToBottomRight = (
            (tl == 'M' && br == 'S') || // MAS
            (tl == 'S' && br == 'M')    // SAM
        );
    
        boolean topRightToBottomLeft = (
            (tr == 'M' && bl == 'S') || // MAS
            (tr == 'S' && bl == 'M')    // SAM
        );
    
        return topLeftToBottomRight && topRightToBottomLeft;
    }
}
