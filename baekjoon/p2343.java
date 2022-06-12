import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
       https://www.acmicpc.net/problem/2343
 */

public class p2343 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int start = 0;
		int end = 0;
		int result = -1;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			end += arr[i];
			start = Math.max(start, arr[i]);
		}
		end = end / m * 2;

		// 시작범위는 배열 요소중 최댓값
		// 끝은 전체평균의 *2
		// 배열 첫번째부터 합구해서 mid보다 큰경우가
		// m보다 크면 mid값이 더 커져야하므로
		// start = mid+1
		// 조건에 걸리지 않으면 end = mid-1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			int cnt = 1;
			for (int i = 0; i < n; i++) {
				sum += arr[i];
				if (sum > mid) {
					if (++cnt > m) {
						start = mid + 1;
						break;
					} else {
						sum = arr[i];
					}
				}

			}
			if (start <= mid) {
				result = mid;
				end = mid - 1;
			}

		}
		System.out.println(result);
	}

}
