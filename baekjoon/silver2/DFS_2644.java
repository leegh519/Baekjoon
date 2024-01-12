import java.io.*;
import java.util.*;

public class DFS_2644 {
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] vistied;
    static int relation = -1;
    static int to = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());
        vistied = new boolean[total + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < total + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(from, 0);
        System.out.println(relation);
    }

    public static void dfs(int node, int count) {
        if (relation != -1) {
            return;
        }
        if (node == to) {
            relation = count;
            return;
        }
        vistied[node] = true;
        for (int i = 0; i < graph.get(node).size(); i++) {
            if (!vistied[graph.get(node).get(i)]) {
                dfs(graph.get(node).get(i), count + 1);
            }
        }
    }
}
