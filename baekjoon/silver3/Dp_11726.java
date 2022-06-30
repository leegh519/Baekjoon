package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//	https://www.acmicpc.net/problem/11726
//	DP

public class Dp_11726 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[1001];
		int n = Integer.parseInt(br.readLine());
		// 1x2타일을 하나의 덩어리(1)로 보고
		// 2x1타일 2개를 하나의 덩어리(2)로 보고 풀면
		// n을 1과 2의 합으로 나타내는 문제와 같다
		// 1은 1
		// 2는 1+1, 2
		// n은 n-1의 경우의 수 뒤에 +1과
		// n-2의 경우의 수 뒤에 +2를 하면
		// 모든 경우의 수를 중복없이 구할수 있다
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < n + 1; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
		System.out.println(dp[n]);

	}

}
