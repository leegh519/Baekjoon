package baekjoon.p2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다.
 * 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.
 * 합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.
 */

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] card = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < card.length; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		int sum = 0;

		// 브루트포스 알고리즘
		// 3장 더해서 m에 가장 가까운 수를 max에 저장
		for (int i = 0; i < card.length - 2; i++) {
			for (int j = i + 1; j < card.length - 1; j++) {
				for (int k = j + 1; k < card.length; k++) {
					if (card[i] + card[j] >= m) {
						continue;
					}
					sum = card[i] + card[j];
					if ((sum + card[k]) <= m && sum + card[k] > max) {
						max = sum + card[k];
					}
					if (max == m) {
						System.out.println(max);
						return;
					}
				}
			}
		}
		System.out.println(max);

	}

}
