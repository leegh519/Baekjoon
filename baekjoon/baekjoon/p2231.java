package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2231 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(s);
		int result = 0;
		for (int i = n - 54; i < n; i++) {
			int sum = i;
			int a = i;
			for (int j = 0; j < s.length(); j++) {
				sum += a % 10;
				a /= 10;
			}
			if (sum == n) {
				result = i;
				break;
			}
		}
		System.out.println(result);

	}

}
