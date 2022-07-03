package silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//	https://www.acmicpc.net/problem/9461
//	DP

public class DP_9461 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		for (int i = 6; i < 101; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(dp[n] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
