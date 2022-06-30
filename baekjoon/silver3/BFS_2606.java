package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/2606
//	BFS

public class BFS_2606 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<ArrayList<Integer>> graph = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		boolean[] visit = new boolean[n + 1];

		// 그래프 초기화
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		int m = Integer.parseInt(br.readLine());

		for (int i = 1; i < m + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		for (int i = 1; i < n + 1; i++) {
			Collections.sort(graph.get(i));
		}

		// bfs 1부터 시작
		visit[1] = true;
		q.offer(1);
		int cnt = 0;
		while (!q.isEmpty()) {
			int a = q.poll();
			cnt++;
			for (int i = 0; i < graph.get(a).size(); i++) {
				if (!visit[graph.get(a).get(i)]) {
					q.offer(graph.get(a).get(i));
					visit[graph.get(a).get(i)] = true;
				}
			}
		}
		System.out.println(cnt - 1);

	}

}
