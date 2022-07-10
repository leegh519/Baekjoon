package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//	https://www.acmicpc.net/problem/9020

public class Math_9020 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[10001];
		List<Integer> prime = new ArrayList<>();
		prime.add(2);
		prime.add(3);
		isPrime[2] = true;
		isPrime[3] = true;

		// 소수구하기
		for (int i = 5; i <= 10000; i += 2) {
			boolean flag = false;
			for (int j = 0; prime.get(j) * prime.get(j) <= i; j++) {
				if (i % prime.get(j) == 0) {
					flag = true;
					break;
				}

			}
			if (!flag) {
				prime.add(i);
				isPrime[i] = true;
			}

		}

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int a = 0, b = 0;
			for (int j = 0; prime.get(j) <= n / 2; j++) {
				int k = n - prime.get(j);
				if (isPrime[k]) {
					a = prime.get(j);
					b = k;
				}

			}
			sb.append(a).append(" ").append(b).append("\n");
		}
		System.out.println(sb);

	}

}
