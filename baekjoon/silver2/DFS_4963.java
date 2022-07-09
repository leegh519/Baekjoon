package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/4963

public class DFS_4963 {

	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 1, 0, -1, 1, -1, 1, -1 };
	static int w, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			int cnt = 0;
			if (w == 0 && h == 0) {
				break;
			}
			int[][] graph = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					cnt += dfs(graph, i, j);
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static int dfs(int[][] graph, int x, int y) {
		if (x < 0 || y < 0 || x >= h || y >= w) {
			return 0;
		}
		if (graph[x][y] == 0) {
			return 0;
		} else {
			graph[x][y] = 0;
			for (int i = 0; i < 8; i++) {
				dfs(graph, x + dx[i], y + dy[i]);
			}
			return 1;
		}
	}

}
