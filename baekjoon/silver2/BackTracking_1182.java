package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackTracking_1182 {

	static int[] arr, tmp;
	static boolean[] visit;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		arr = new int[n];

		visit = new boolean[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			tmp = new int[i];
			back(i, s, 0, 0);
		}
		System.out.println(result);

	}

	private static void back(int length, int s, int cnt, int start) {
		if (cnt == length) {
			int sum = 0;
			for (int i = 0; i < length; i++) {
				sum += tmp[i];
			}
			if (sum == s) {
				result++;
			}
			return;
		}

		for (int i = start; i < arr.length; i++) {
			tmp[cnt] = arr[i];
			back(length, s, cnt + 1, i + 1);
		}
	}
}