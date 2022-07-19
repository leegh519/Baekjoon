package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p2231 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(s);

		List<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= 1000000; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 1; i < 1000000; i++) {
			int sum = i;
			int a = i;
			while (a != 0) {
				sum += a % 10;
				a /= 10;
			}

			if (sum <= 1000000) {
				list.get(sum).add(i);
			}

		}
		if (list.get(n).size() == 0) {
			System.out.println(0);
		} else {
			System.out.println(list.get(n));
		}

//		for (int i = n - 54; i < n; i++) {
//			int sum = i;
//			int a = i;
//			for (int j = 0; j < s.length(); j++) {
//				sum += a % 10;
//				a /= 10;
//			}
//			if (sum == n) {
//				result = i;
//				break;
//			}
//		}
//		System.out.println(result);

	}

}
