package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11729
// 하노이탑 재귀문제

public class Recur_11729 {

	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		hanoi(1, 3, n);

		System.out.println(cnt);
		System.out.println(sb);
	}

	private static void hanoi(int i, int j, int n) {
		if (n == 1) {
			sb.append(i).append(" ").append(j).append("\n");
			cnt++;
			return;
		}
		hanoi(i, 6 - i - j, n - 1);
		hanoi(i, j, 1);
		hanoi(6 - i - j, j, n - 1);

	}

}
