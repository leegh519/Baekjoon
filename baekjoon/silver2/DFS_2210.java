import java.io.*;
import java.util.*;

public class DFS_2210 {
    static int[][] graph = new int[5][5];
    static Set<Integer> set = new HashSet<Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, 1);
            }
        }
        System.out.println(set.size());
    }

    public static void dfs(int i, int j, int n, int cnt) {
        if (i < 0 || i > 4 || j < 0 || j > 4) {
            return;
        }
        n = n * 10 + graph[i][j];
        if (cnt == 6) {
            set.add(n);
            return;
        }
        dfs(i, j - 1, n, cnt + 1);
        dfs(i, j + 1, n, cnt + 1);
        dfs(i + 1, j, n, cnt + 1);
        dfs(i - 1, j, n, cnt + 1);
    }
}
