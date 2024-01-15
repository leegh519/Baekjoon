import java.io.*;
import java.util.*;

public class DFS_2583 {

    static int height;
    static int width;
    static int[][] graph;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new LinkedList<Integer>();

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        graph = new int[height][width];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                for (int j2 = y1; j2 < y2; j2++) {
                    graph[j2][j] = 1;
                }
            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (dfs(x, y)) {
                    list.add(count);
                    count = 0;
                }
            }
        }
        Collections.sort(list);
        sb.append(list.size());
        sb.append("\n");
        for (Integer integer : list) {
            sb.append(integer);
            sb.append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    static boolean dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return false;
        }
        if (graph[y][x] == 1) {
            return false;
        }
        graph[y][x] = 1;
        count++;
        dfs(x, y + 1);
        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y - 1);

        return true;
    }
}
