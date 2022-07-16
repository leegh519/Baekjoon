package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BFS_2667 {

	static int cnt = 0;
	static int[] result;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		result = new int[n*n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(i, j, map, n)) {
					cnt++;
				}
			}
		}
		sb.append(cnt).append("\n");
		Arrays.sort(result);
		for (int i = result.length-cnt; i < result.length; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean dfs(int x, int y, int[][] map, int n) {
		if (x < 0 || x == n || y < 0 || y == n) {
			return false;
		}
		if (map[x][y] == 0) {
			return false;
		}
		result[cnt]++;
		map[x][y] = 0;

		for (int i = 0; i < 4; i++) {
			dfs(x + dx[i], y + dy[i], map, n);
		}
		return true;

	}

}
