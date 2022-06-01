package baekjoon.p1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			long result = 1;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if (n > (m / 2)) {
				n = m - n;
			}
			for (int j = m; j > m - n; j--) {
				result *= j;
			}
			for (int j = 1; j <= n; j++) {
				result /= j;
			}
			System.out.println(result);
		}
	}
}