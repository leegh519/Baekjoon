package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//	

public class BFS_1697 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[100001];
		boolean[] visit = new boolean[100001];
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int result = bfs(n, k, arr, visit);
		System.out.println(result);

	}

	private static int bfs(int n, int k, int[] arr, boolean[] visit) {
		if (n == k) {
			return 0;
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		arr[n] = 1;
		visit[n] = true;
		while (true) {
			n = q.poll();
			if (n * 2 == k || n + 1 == k || n - 1 == k) {
				break;
			}
			if (n * 2 < 100001 && !visit[n * 2]) {
				visit[n * 2] = true;
				arr[n * 2] = arr[n] + 1;
				q.offer(n * 2);
			}
			if (n + 1 < 100001 && !visit[n + 1]) {
				visit[n + 1] = true;
				arr[n + 1] = arr[n] + 1;
				q.offer(n + 1);
			}
			if (n - 1 > -1 && !visit[n - 1]) {
				visit[n - 1] = true;
				arr[n - 1] = arr[n] + 1;
				q.offer(n - 1);
			}
		}
		return arr[n];
	}

}
