package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//	https://www.acmicpc.net/problem/2156

public class DP_2156 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = arr[1];
		if (n > 1) {
			dp[2] = arr[1] + arr[2];
			for (int i = 3; i <= n; i++) {
				// i번째 마시고 i-1번째 마시는 경우
				dp[i] = arr[i] + arr[i - 1] + dp[i - 3];
				// i번째 마시고 i-1번째 안 마시는 경우
				dp[i] = Math.max(dp[i], arr[i] + dp[i - 2]);
				// i번째 안 마시는 경우
				dp[i] = Math.max(dp[i], dp[i - 1]);
			}
		}
		System.out.println(dp[n]);
	}
}
