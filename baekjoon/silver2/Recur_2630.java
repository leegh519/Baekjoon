package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Recur_2630 {

	static int white = 0, blue = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		func(map, n, 0, 0);

		System.out.println(white + "\n" + blue);

	}

	private static void func(int[][] map, int n, int x, int y) {
		if (n == 1) {
			if (map[x][y] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}

		if (!check(map, n, x, y)) {
			for (int i = x; i < n + x; i += (n / 2)) {
				for (int j = y; j < n + y; j += (n / 2)) {
					func(map, n / 2, i, j);
				}
			}
		}

	}

	private static boolean check(int[][] map, int n, int x, int y) {
		int first = map[x][y];
		for (int i = x; i < n + x; i++) {
			for (int j = y; j < n + y; j++) {
				if (first != map[i][j]) {
					return false;
				}
			}
		}
		if (first == 0) {
			white++;
		} else {
			blue++;
		}

		return true;
	}

}
