package silver1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp_11660 {

	/*
	 * N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오. (x, y)는
	 * x행 y열을 의미한다. 예를 들어, N = 4이고, 표가 아래와 같이 채워져 있는 경우를 살펴보자.
	 * 
	 * 1 2 3 4 2 3 4 5 3 4 5 6 4 5 6 7 여기서 (2, 2)부터 (3, 4)까지 합을 구하면 3+4+5+4+5+6 =
	 * 27이고, (4, 4)부터 (4, 4)까지 합을 구하면 7이다. 표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때, 이를 처리하는
	 * 프로그램을 작성하시오.
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[][] dp = new long[1025][1025];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			// (1,1)부터 (n,n)까지 합을 dp테이블에 저장
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + Integer.parseInt(st.nextToken());

			}
		}

		// (x1, y1), (x2, y2)가 주어질때 dp테이블 이용해서 계산
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			System.out.println(dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]);
		}

	}

}
