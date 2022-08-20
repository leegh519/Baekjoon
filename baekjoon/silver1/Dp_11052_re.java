package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11052

/*
카드 i개를 구매하는 방법은?
카드 1개가 들어있는 카드팩을 구매하고, 카드 i-1개를 구입한다.
카드 2개가 들어있는 카드팩을 구매하고, 카드 i-2개를 구입한다.
카드 3개가 들어있는 카드팩을 구매하고, 카드 i-3개를 구입한다.
...
일반화 시키면 D[i] = P[n] + D[i-n] 이다. 
*/

public class Dp_11052_re {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] p = new int[n + 1];
		int[] dp = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		dp[1] = p[1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(p[j] + dp[i - j], dp[i]);
			}
		}
		System.out.println(dp[n]);
	}

}
