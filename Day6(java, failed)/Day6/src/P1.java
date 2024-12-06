import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class P1 {
    public static void main(String[] args) {
        char[][] grid = null;
        try (BufferedReader br = new BufferedReader(new FileReader("Day6(java,failed)/input.txt"))) {
            String line;
            int rows = 0;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line.strip()).append("\n");
                rows++;
            }
            String[] lines = sb.toString().split("\n");
            int cols = lines[0].length();
            grid = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                grid[i] = lines[i].toCharArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int r = 0, c = 0;
        for (r = 0; r < rows; r++) {
            for (c = 0; c < cols; c++) {
                if (grid[r][c] == '^') {
                    break;
                }
            }
            if (c < cols) {
                break;
            }
        }

        int dr = -1;
        int dc = 0;

        Set<String> seen = new HashSet<>();

        while (true) {
            seen.add(r + "," + c);
            if (r + dr < 0 || r + dr >= rows || c + dc < 0 || c + dc >= cols) {
                break;
            }
            if (grid[r + dr][c + dc] == '#') {
                int temp = dc;
                dc = -dr;
                dr = temp;
            } else {
                r += dr;
                c += dc;
            }
        }

        System.out.println(seen.size());
    }
}

