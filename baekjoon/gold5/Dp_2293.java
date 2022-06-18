package gold5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 
이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 
그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.
사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.

첫째 줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 
다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 동전의 가치는 100,000보다 작거나 같은 자연수이다.

*/
public class Dp_2293 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[10001];
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list, Collections.reverseOrder());
		
		// 동전의 가치가 큰 것부터 시작해서
		// dp[j] = dp[j] + dp[j - i]로 테이블의 값을 초기화하면
		// 경우의 수가 중복없이 계산되어 채워진다
		
		dp[0]=1;
		for (int i : list) {
			for (int j = i; j <= k; j++) {
				dp[j] = dp[j] + dp[j - i];
			}
		}

		System.out.println(dp[k]);

	}

}
