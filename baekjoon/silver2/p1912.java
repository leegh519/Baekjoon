package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1912 {

	//	그리디인주 알았는데 dp인듯
	//	max(dp[n],dp[n-1])?
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.parseInt(st.nextToken());
		int sum = max;

		for (int i = 1; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if (x > 0) {
				sum += x;
			} else {
				max = Math.max(max, sum);
				max = Math.max(max, x);
				sum = 0;
			}
		}
		System.out.println(max);
	}

}
