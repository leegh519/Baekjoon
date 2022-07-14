package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1780 {

	static int cnt;
	static int[] arr = new int[3];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] paper = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		

		func(n, paper, 0, 0);

		System.out.println(arr[0] + "\n" + arr[1] + "\n" + arr[2]);
	}

	private static void func(int n, int[][] paper, int x, int y) {
		if (n == 1) {
			System.out.println(x+" "+y);
			if (paper[x][y] == -1) {
				arr[0]++;
			} else if (paper[x][y] == 0) {
				arr[1]++;
			} else {
				arr[2]++;
			}
			return;
		}
		if (!check(paper, n, x, y)) {
			for (int i = 0; i < n; i += (n / 3)) {
				for (int j = 0; j < n; j += (n / 3)) {
					func(n / 3, paper, i, j);
				}
			}

		}

	}

	private static boolean check(int[][] paper, int n, int x, int y) {

		int first = paper[x][y];

		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (paper[i][j] != first) {
					return false;
				}
			}
		}
		if (first == -1) {
			arr[0]++;
		} else if (first == 0) {
			arr[1]++;
		} else {
			arr[2]++;
		}

		return true;
	}

}
