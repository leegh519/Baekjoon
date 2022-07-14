package silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/11053
//	가장 긴 증가하는 부분 수열

public class Dp_11053_re {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[n];
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = 0;
		int max = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				//	i번째요소일때
				//	0~i-1번째 순회하면서 i번째가 더 크면
				//	dp[j]+1
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max + 1);

	}

}
