package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/2178
//	최단거리 길찾기 = bfs

public class BFS_2178_re {

	static int n, m, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
		bfs(arr, 0, 0);
		System.out.println(arr[n - 1][m - 1]);

	}

	private static void bfs(int[][] arr, int x, int y) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		Queue<Integer[]> q = new LinkedList<Integer[]>();
		// x, y 좌표 기록
		Integer[] xy = { x, y };
		q.offer(xy);
		
		while (!q.isEmpty()) {
			int x1 = q.peek()[0];
			int y1 = q.peek()[1];
			q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = x1 + dx[i];
				int ny = y1 + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
					continue;
				}
				if (arr[nx][ny] == 0) {
					continue;
				}
				if (arr[nx][ny] == 1) {
					arr[nx][ny] = arr[x1][y1] + 1;
					Integer[] nxy = { nx, ny };
					q.offer(nxy);
				}

			}
		}

	}

}
