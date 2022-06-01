package baekjoon.p2579;

import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수
		 * 있다. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다. 마지막 도착 계단은 반드시 밟아야 한다.
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] stair = new int[n + 3];
		int[] dp = new int[301];
		for (int i = 1; i <= n; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		// 첫번째 계단, 두번째 계단
		dp[1] = stair[1];
		dp[2] = stair[1] + stair[2];

		// 세번째계단은 xoo로 밟는 경우도 가능
		for (int i = 3; i <= n; i++) {

			// 점화식
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
		}
		bw.write(dp[n] + "\n");
		bw.flush();

	}

}
