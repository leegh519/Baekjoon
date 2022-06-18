package silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

//	https://www.acmicpc.net/problem/11286
//	절댓값 힙

public class PriorityQ_11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		// 절댓값 힙
		// 람다식으로 comparator구현
		// 절댓값이 더 작은순서로
		// 절댓값이 같으면 실제 값이 더 작은수
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> {
			if (Math.abs(a) == Math.abs(b)) {
				return a - b;
			}
			return Math.abs(a) - Math.abs(b);
		});

		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a != 0) {
				queue.add(a);
			} else {
				if (!queue.isEmpty()) {
					bw.write(queue.poll() + "\n");
				} else {
					bw.write(0 + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
