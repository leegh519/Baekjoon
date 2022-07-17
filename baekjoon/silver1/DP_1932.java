package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/1932
//	dp더라

public class DP_1932 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int size = (n * n + n + 1) / 2;
		int[] tri = new int[size];
		int[] dp = new int[size];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				tri[cnt++] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0] = 0;
		cnt = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[cnt] = dp[cnt - i] + tri[cnt];
				} else if (j == i) {
					dp[cnt] = dp[cnt - i - 1] + tri[cnt];
				} else {
					dp[cnt] = Math.max(dp[cnt - i] + tri[cnt], dp[cnt - i - 1] + tri[cnt]);
				}
				max = Math.max(max, dp[cnt]);
				cnt++;
			}
		}
		System.out.println(max);

	}
}