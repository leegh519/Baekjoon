import java.io.*;
import java.util.*;

public class BFS_1389 {

    static List<ArrayList<Integer>> graph;
    static int n = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new ArrayList<ArrayList<Integer>>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] b = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            b[i] = bfs(i);
        }

        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 1; i < b.length; i++) {
            if (b[i] < min) {
                min = b[i];
                result = i;
            }
        }

        System.out.println(result);
    }

    static int bfs(int source) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[n + 1];
        int[] level = new int[n + 1];

        queue.offer(source);
        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (Integer integer : graph.get(n)) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    level[integer] = level[n] + 1;
                    queue.offer(integer);
                }
            }
        }

        int sum = 0;
        for (int i : level) {
            sum += i;
        }
        return sum;

    }
}
