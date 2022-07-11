package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/15649
//	백트래킹

public class BackTracking_15650 {

	static int n, m;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		func(0, 1, "");
		System.out.println(sb);

	}

	public static void func(int k, int start, String s) {
		if (k == m) {
			sb.append(s.trim()).append("\n");
			return;
		}

		// 방문처리 할거없이 dfs원리로 풀면되는듯?
		for (int i = start; i <= n; i++) {
			func(k + 1, i + 1, s + " " + i);
		}

	}

}
