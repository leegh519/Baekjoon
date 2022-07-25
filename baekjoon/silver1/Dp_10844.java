package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/10844
//	https://cotak.tistory.com/12

public class Dp_10844 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n + 1][11];

		for (int i = 1; i < 11; i++) {
			dp[1][i] = 1;
		}
		// i는 자릿수, j는 i번째 자리 숫자
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = (dp[i - 1][j + 1]) % 1000000000;
				} else if (j == 9) {
					dp[i][j] = dp[i - 1][j - 1] % 1000000000;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
				}
			}
		}
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[n][i] % 1000000000;
		}
		System.out.println(sum % 1000000000);
	}

}
