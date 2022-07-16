package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//	https://www.acmicpc.net/problem/1699

public class DP_1699 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = (int) Math.sqrt(i); j > 0; j--) {
				if (i == (j * j)) {
					dp[i] = 1;
					break;
				}
				dp[i] = Math.min(dp[i - (j * j)] + 1, dp[i]);
			}
		}
		System.out.println(dp[n]);
	}
}