import java.io.*;
import java.util.*;

public class BFSDFS_2468 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int result = 1;

        for (int height = 1; height < maxHeight; height++) {
            boolean[][] visitied = new boolean[n][n];
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dfs(j, k, height, map, n, visitied)) {
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }

        System.out.println(result);
    }

    public static boolean dfs(int x, int y, int height, int[][] map, int n, boolean[][] visitied) {
        if (x < 0 || y < 0 || x >= n || y >= n) {
            return false;
        }
        if (visitied[x][y]) {
            return false;
        }
        if (map[x][y] <= height) {
            return false;
        }
        visitied[x][y] = true;
        dfs(x - 1, y, height, map, n, visitied);
        dfs(x, y - 1, height, map, n, visitied);
        dfs(x + 1, y, height, map, n, visitied);
        dfs(x, y + 1, height, map, n, visitied);

        return true;
    }

}
