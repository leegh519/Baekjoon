package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/1912
//	DP

public class DP_1912_re {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 처음부터 연속합을 계속 구하면서 감
		// 합이 음수가 아니면 뒤에 가면서 더하다보면
		// 현재 연속합보다 커질 경우도 있을 수 있음
		// ex) 10 -4 4 5 ...
		// 연속합이 음수가 나오면 리셋하고 다음수부터 다시 더함
		// dp[i]는 dp[i-1]과 연속합중 큰값으로 설정
		
		dp[1] = arr[1];
		int sum = dp[1];
		for (int i = 2; i <= n; i++) {
			if (sum < 0) {
				sum = 0;
			}
			sum += arr[i];
			dp[i] = Math.max(dp[i - 1], sum);
		}

		System.out.println(dp[n]);

	}

}
