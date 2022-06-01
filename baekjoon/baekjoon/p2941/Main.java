package baekjoon.p2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int l = s.length();
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == 'c') {
				if (s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-') {
					l--;
				}
			} else if (s.charAt(i) == 'd') {
				if ((i + 2 < s.length()) && (s.charAt(i + 1) == 'z' && s.charAt(i + 2) == '=')) {
					l -= 2;
				} else if (s.charAt(i + 1) == '-') {
					l--;
				}
			} else if (s.charAt(i) == 'l') {
				if (s.charAt(i + 1) == 'j') {
					l--;
				}
			} else if (s.charAt(i) == 'n') {
				if (s.charAt(i + 1) == 'j') {
					l--;
				}
			} else if (s.charAt(i) == 's') {
				if (s.charAt(i + 1) == '=') {
					l--;
				}
			} else if (s.charAt(i) == 'z') {
				if (s.charAt(i + 1) == '=') {
					if ((i - 1 < 0)) {
						l--;
					} else if (s.charAt(i - 1) != 'd') {
						l--;
					}
				}
			}

		}
		System.out.println(l);

	}

}
