package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/14889

public class BackTracking_14889_re {

	static int[] a;
	static boolean[] visit;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		a = new int[n + 1];
		visit = new boolean[n + 1];
		// 1로 시작하는 팀원들만 구하면
		// 나머지 인원들이 한팀이 됨
		a[0] = 1;
		visit[1] = true;
		backt(arr, n, 1);
		System.out.println(result);
	}

	public static void backt(int[][] arr, int n, int k) {
		if (k == n / 2) {
			int sum1 = 0;
			int sum2 = 0;
			// 1부터 n까지 1,2  1,3  ...  1,n 탐색
			// i j 모두 방문한 경우 팀1
			// i j 모두 방문안한 경우 팀2
			for (int i = 1; i < n; i++) {
				for (int j = i + 1; j < n + 1; j++) {
					if (visit[i] && visit[j]) {
						sum1 += (arr[i][j] + arr[j][i]);
					} else if (!visit[i] && !visit[j]) {
						sum2 += (arr[i][j] + arr[j][i]);
					}
				}
			}
			if (result > Math.abs(sum1 - sum2)) {
				result = Math.abs(sum1 - sum2);
			}
			return;
		}
		for (int i = 2; i <= n; i++) {
			if (!visit[i]) {
				if (a[k - 1] < i) {
					a[k] = i;
					visit[i] = true;
					backt(arr, n, k + 1);
					visit[i] = false;
				}
			}
		}

	}

}
