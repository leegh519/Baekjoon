package baekjoon.p1463;

import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int x = Integer.parseInt(br.readLine());
		int[] dp = new int[x + 3];
		
		// 최소 기본단위
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i <= x; i++) {
			
			// 3의배수
			if (i % 3 == 0) {
				if (i % 2 == 1) {
					// 3으로 나누는것과 -1중 작은 쪽 선택
					dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
				} else {
					// 3으로 나누는 것과 2로 나누는 것 중 작은 쪽 선택
					dp[i] = Math.min(dp[i / 3], dp[i / 2]) + 1;
				}
			} 
			// 홀수는 -1
			else if (i % 2 == 1) {
				dp[i] = dp[i - 1] + 1;
			} else {
				dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
			}
		}
		bw.write(dp[x] + "\n");
		br.close();
		bw.close();

	}

}
