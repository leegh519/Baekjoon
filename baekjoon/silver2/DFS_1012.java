package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/1012
//	DFS를 이용하여 그래프의 덩어리 갯수 탐색

public class DFS_1012 {

	static boolean[][] visit;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			int result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] xy = new int[n][m];
			visit = new boolean[n][m];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// 배열 인덱스는 가로 세로 바껴서 들어가야함
				xy[b][a] = 1;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					// dfs가 한번실행하면 인접한 부분은
					// 모두 방문하고 true를 한번만 반환함
					// 인접한 곳이 모두 방문처리가 되기때문에
					// i, j를 증가하여 인접한 곳을 dfs를 실행해도
					// false가 반환되므로 result 값에 변화가 없음
					if (dfs(xy, i, j)) {
						result++;
					}
				}
			}
			bw.write(result + "\n");
			t--;
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean dfs(int[][] xy, int n, int m) {
		// 가로 세로 범위 벗어나면 종료
		if (n < 0 || m < 0 || n > xy.length - 1 || m > xy[0].length - 1) {
			return false;
		}
		// 그래프값이 1이고 방문하지 않은 경우
		// 방문처리 후
		// 상하좌우 방문하고 1인경우 방문처리
		if (xy[n][m] == 1 && !visit[n][m]) {
			visit[n][m] = true;
			dfs(xy, n + 1, m);
			dfs(xy, n, m + 1);
			dfs(xy, n - 1, m);
			dfs(xy, n, m - 1);
			return true;
		} else {
			return false;
		}

	}

}
