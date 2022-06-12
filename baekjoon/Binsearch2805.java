import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Binsearch2805 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int max = 0;
		int[] h = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
			if (h[i] >= max) {
				max = h[i];
			}
		}

		int start = 0, cut = 0, end = 0;
		int ans = 0;
		long sum;
		end = max;

		while (start <= end) {
			cut = (start + end) / 2;
			sum = 0;

			/*
			 * if ((end - start) <= 1) { for (int i = 0; i < n; i++) { if (h[i] - end > 0) {
			 * sum += (h[i] - end); } } //System.out.println(start + " " + cut + " " + end +
			 * " " + sum);
			 * 
			 * if (sum >= m) { cut = end; break; } else { break; } }
			 */

			for (int i = 0; i < n; i++) {
				if (h[i] - cut > 0) {
					sum += (h[i] - cut);
				}
			}
			if (sum < m) {
				end = cut - 1;
			} else {
				if (ans < cut) { // sum==m이 최솟값일 경우를 위해 ans에 cut을 저장해둠
					ans = cut; // 따로 반복문 종료조건을 만들어줄 필요 없어서 더 나은듯
				}
				start = cut + 1;
			}

		}

		System.out.println(ans);

	}

}