package silver1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*	1번 집의 색은 2번 집의 색과 같지 않아야 한다.
	N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
	i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
*/

public class Dp_1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[1001][3];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 3; i++) {
			dp[1][i] = Integer.parseInt(st.nextToken());
		}

		// 2번째 집부터 dp테이블 만듬
		// R G B일때 각각 비용의 최솟값을 계산해서 배열에 저장
		for (int i = 2; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + dp[i][j];
			}
		}

		int result = Math.min(dp[n][0], dp[n][1]);
		result = Math.min(dp[n][2], result);
		System.out.println(result);

	}

}
