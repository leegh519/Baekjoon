package gold5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//70세 박종수 할아버지는 매일 매일 약 반알을 먹는다. 손녀 선영이는 종수 할아버지에게 약이 N개 담긴 병을 선물로 주었다.
//
//첫째 날에 종수는 병에서 약 하나를 꺼낸다. 그 다음, 그 약을 반으로 쪼개서 한 조각은 먹고, 다른 조각은 다시 병에 넣는다.
//
//다음 날부터 종수는 병에서 약을 하나 꺼낸다. 
//
//(약은 한 조각 전체 일 수도 있고, 쪼갠 반 조각 일 수도 있다) 반 조각이라면 그 약을 먹고, 
//
//아니라면 반을 쪼개서 한 조각을 먹고, 다른 조각은 다시 병에 넣는다.
//
//종수는 손녀에게 한 조각을 꺼낸 날에는 W를, 반 조각을 꺼낸 날에는 H 보낸다. 
//
//손녀는 할아버지에게 받은 문자를 종이에 기록해 놓는다. 총 2N일이 지나면 길이가 2N인 문자열이 만들어지게 된다. 
//
//이때, 가능한 서로 다른 문자열의 개수는 총 몇 개일까?

public class Dp_4811 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// dp[w][h] 테이블 작성
		// 한알짜리가 없고 반알짜리만 있으면 경우의 수는 1개
		// 반알짜리가 없고 한알짜리만 있으면 한알짜리-1, 반알짜리 1개생성
		// 둘다 있을 때는
		// 한알짜리 먹는 경우 w-1, h+1
		// 반알짜리 먹는 경우 w, h-1
		long[][] dp = new long[32][32];

		for (int i = 0; i <= 30; i++) {
			for (int j = 0; j <= 30; j++) {
				if (i == 0) {
					dp[i][j] = 1;
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][1];
				} else {
					dp[i][j] = dp[i - 1][j + 1] + dp[i][j - 1];
				}
			}
		}

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}

			System.out.println(dp[n][0]);
		}

	}

}
