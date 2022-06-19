package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/1260
//	DFS	BFS

public class DFSBFS_1260 {

	static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Stack<Integer> s = new Stack<>();
	static boolean[] visitdfs = new boolean[1001];
	static boolean[] visitbfs = new boolean[1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		// 그래프 초기화
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		// 연결된 노드 입력받아서 그래프에 삽입
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		// 각 노드에 연결된 노드목록 작은순서대로 정렬
		for (int i = 0; i < n + 1; i++) {
			Collections.sort(graph.get(i));
		}

		dfs(v);
		bw.flush();
		System.out.println();
		bfs(v);

	}

	// bfs-시작노드부터 큐에 넣고
	// 출력한 뒤 연결된 노드중
	// 아직 방문하지 않은 가장 작은 노드부터
	// 순서대로 방문
	public static void bfs(int v) throws IOException {
		Queue<Integer> q = new LinkedList<Integer>();
		visitbfs[v] = true;
		q.offer(v);
		while (!q.isEmpty()) {
			int a = q.poll();
			bw.write(a + " ");
			for (int i = 0; i < graph.get(a).size(); i++) {
				if (!visitbfs[graph.get(a).get(i)]) {
					visitbfs[graph.get(a).get(i)] = true;
					q.offer(graph.get(a).get(i));
				}
			}
		}
		bw.flush();
	}

	// dfs-재귀함수로 구현
	// 시작노드 방문처리->출력 후
	// 연결된 노드중 방문하지않은
	// 가장 작은노드 방문
	// 방문한 노드에서 연결된 가장 작은노드 다시 방문
	// 반복
	public static void dfs(int v) throws IOException {
		visitdfs[v] = true;
		bw.write(v + " ");
		for (int i = 0; i < graph.get(v).size(); i++) {
			int a = graph.get(v).get(i);
			if (!visitdfs[a]) {
				dfs(a);
			}
		}

	}

}
