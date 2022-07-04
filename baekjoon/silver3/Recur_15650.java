package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/15649
//	백트래킹
//	재귀함수를 이용

public class Recur_15650 {

	static int n, m;
	static boolean[] visit;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n + 1];
		arr = new int[n + 1];
		func(0);
		System.out.println(sb);

	}

	public static void func(int k) {
		// m개만큼 채우면 출력
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visit[i] && k == 0) {
				arr[k] = i;
				visit[i] = true;
				func(k + 1);
				visit[i] = false;
			} else if (!visit[i] && k != 0) {
				if (arr[k - 1] < i) {
					arr[k] = i;
					visit[i] = true;
					func(k + 1);
					visit[i] = false;
				}
			}
		}

	}

}
