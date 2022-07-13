package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/11725
//	bfs로 트리의 루트부터 탐색하면서 부모노드 저장

public class BFS_11725 {

	static List<ArrayList<Integer>> list;
	static boolean[] visit;
	static StringBuilder sb;
	static int[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		visit = new boolean[n + 1];
		result = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		bfs(1);
		for (int i = 2; i < result.length; i++) {
			sb.append(result[i]).append("\n");
		}

		System.out.println(sb);

	}

	private static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		visit[n] = true;
		while (!q.isEmpty()) {
			int a = q.poll();
			for (int i = 0; i < list.get(a).size(); i++) {
				int x = list.get(a).get(i);
				if (!visit[x]) {
					result[x] = a;
					q.offer(x);
					visit[x] = true;
				}

			}
		}
	}

}
