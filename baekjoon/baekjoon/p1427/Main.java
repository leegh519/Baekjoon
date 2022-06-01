package baekjoon.p1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(s);
		int[] a = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			a[i] = n % 10;
			n = n / 10;
		}
		Arrays.sort(a);
		for (int i = a.length-1; i >= 0; i--) {
			System.out.print(a[i]);
		}
	}

}
