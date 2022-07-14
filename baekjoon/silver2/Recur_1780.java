package silver2;

import java.io.*;
import java.util.*;

//	https://www.acmicpc.net/problem/1780
//	분할정복, 재귀

public class Recur_1780 {

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

	// n: 분할단위
	// x, y: 검색시작위치
	private static void func(int n, int[][] paper, int x, int y) {

		// 최소단위로 분할한 경우
		if (n == 1) {
			if (paper[x][y] == -1) {
				arr[0]++;
			} else if (paper[x][y] == 0) {
				arr[1]++;
			} else {
				arr[2]++;
			}
			return;
		}
		// 모든 수가 같은 수 인지 check
		if (!check(paper, n, x, y)) {

			// 분할해서 재귀적으로 탐색
			for (int i = x; i < x + n; i += (n / 3)) {
				for (int j = y; j < y + n; j += (n / 3)) {
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