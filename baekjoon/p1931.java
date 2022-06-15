import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/1931

public class p1931 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 2차원 배열 정렬
		Arrays.sort(arr, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			} else {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		int end = arr[0][1];
		for (int i = 1; i < n; i++) {

			// 기존회의 끝나는 시간보다 다음회의 시작시간, 끝나는시간 모두 작으면
			// 이 회의 끝나는 시간을 end시간으로 설정
			if (arr[i][0] < end && arr[i][1] < end) {
				end = arr[i][1];
			}
			// 다음회의 시작시간이 기존회의 끝시간보다
			// 크거나 같으면 다음회의 끝시간을
			// end로 설정하고 회의 카운트 1증가
			else if (arr[i][0] >= end) {
				end = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}
