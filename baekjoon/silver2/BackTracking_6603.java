package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackTracking_6603 {

	static StringBuilder sb = new StringBuilder();
	static int[] lotto, tmp;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if (k == 0) {
				break;
			}
			lotto = new int[k];
			tmp = new int[k];
			visit = new boolean[k];
			for (int i = 0; i < k; i++) {
				lotto[i] = Integer.parseInt(st.nextToken());
			}
			back(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static void back(int cnt, int start) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(tmp[i]).append(" ");
			}
			sb.append("\n");
		}
		for (int i = start; i < lotto.length; i++) {
			if (!visit[i]) {
				if (cnt != 0 && !visit[i]) {
					if (tmp[cnt-1] < lotto[i]) {
						visit[i] = true;
						tmp[cnt] = lotto[i];
						back(cnt + 1, start + 1);
						visit[i] = false;
					}
				} else if (cnt == 0 && !visit[i]) {
					visit[i] = true;
					tmp[cnt] = lotto[i];
					back(cnt + 1, start + 1);
					visit[i] = false;
				}
			}
		}
	}
}