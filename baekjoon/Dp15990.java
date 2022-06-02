import java.io.*;

/* 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다. 
 * 합을 나타낼 때는 수를 1개 이상 사용해야 한다. 
 * 단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.
 * 1+2+1
 * 1+3
 * 3+1
 * 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
 */

public class Dp15990 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		long[][] dp = new long[100001][3];

		// 배열에 1로 시작하는 경우, 2로 시작하는 경우, 3으로 시작하는 경우 나누어 저장
		dp[1][0] = 1;
		dp[2][1] = 1;
		dp[3][0] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;

		// 1로 시작하는 경우는 k-1의 2, 3으로 시작하는 경우의 합
		// 2로 시작하는 경우는 k-2의 1, 3으로 시작하는 경우의 합
		// 3으로 시작하는 경우는 k-3의 1, 2으로 시작하는 경우의 합
		// 전체 경우의 수에 dp 배열을 미리 다 작성해놓고
		// 입력 케이스에 대한 답은 배열에서 찾기만 하면 훨씬 빠름
		for (int j = 4; j <= 100000; j++) {
			dp[j][0] = (dp[j - 1][1] + dp[j - 1][2]) % 1000000009;
			dp[j][1] = (dp[j - 2][0] + dp[j - 2][2]) % 1000000009;
			dp[j][2] = (dp[j - 3][0] + dp[j - 3][1]) % 1000000009;
		}

		for (int i = 0; i < t; i++) {
			long sum = 0;
			int k = Integer.parseInt(br.readLine());

			for (int j = 0; j < 3; j++) {
				sum += dp[k][j];
			}
			sum = sum % 1000000009;
			bw.write(sum + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
