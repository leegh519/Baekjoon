package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp_11055 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n ; i++) {
			dp[i] = a[i];
			for (int j = 0; j < i; j++) {
				if(a[i]>a[j]) {
					dp[i]=Math.max(dp[j]+a[i], dp[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}