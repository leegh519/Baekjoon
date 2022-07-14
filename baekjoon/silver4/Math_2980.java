package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_2980 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int time = 0;
		int predis = 0;
		int dis = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			// 신호등사이 거리
			dis = d - predis;
			// 누적시간
			time = time + dis;
			// 직전신호등 위치
			predis = d;
			// 신호대기시간
			int wait = time % (r + g) - r;
			// 0보다 작으면 wait절대값만큼 신호대기
			if (wait < 0) {
				// 누적시간에 더함
				time += Math.abs(wait);
				// 걸리는 시간 = 도로길이+기다린시간
				l += Math.abs(wait);
			}
		}
		System.out.println(l);
	}
}