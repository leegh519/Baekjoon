package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/11724
//	BFS나 DFS

public class BFS_11724 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visit = new boolean[n + 1];
		int cnt = 0;

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<Integer>());
		}

		// 그래프의 노드와 간선이 주어짐
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		// bfs
		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				q.offer(i);
				visit[i] = true;
				cnt++;
				while (!q.isEmpty()) {
					int k = q.poll();
					for (int j = 0; j < list.get(k).size(); j++) {
						if (!visit[list.get(k).get(j)]) {
							q.offer(list.get(k).get(j));
							visit[list.get(k).get(j)] = true;
						}
					}
				}
			}
		}
		System.out.println(cnt);

	}

}
