package baekjoon.p10994;

import java.io.*;

public class Main {
	static int n;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		arr = new char[4 * n - 3][4 * n - 3];

		for (int i = 0; i < 4 * n - 3; i++) {
			for (int j = 0; j < 4 * n - 3; j++) {
				arr[i][j]=' ';
			}
		}
		
		star(n, 0, 0);

		for (int i = 0; i < 4 * n - 3; i++) {
			for (int j = 0; j < 4 * n - 3; j++) {
				bw.write(arr[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
	}
	static void star(int n, int x, int y) {
		// base
		if (n == 1) {
			arr[x][y] = '*';
			return;
		}

		// recur: 가장 겉테두리에 별 표시
		for (int i = 0; i < 4 * n - 3; i++) {
			for (int j = 0; j < 4 * n - 3; j++) {
				// 처음 행, 마지막 행, 처음 열, 마지막 열이면 채움
				if (i == 0 || i == 4 * n - 4 || j == 0 || j == 4 * n - 4) {
					arr[x + i][y + j] = '*';
				}
			}
		}
		star(n - 1, x + 2, y + 2);

	}
}