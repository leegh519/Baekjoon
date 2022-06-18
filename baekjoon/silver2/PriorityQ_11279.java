package silver2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

//	최대힙, 우선순위 큐
//	https://www.acmicpc.net/problem/11279

public class PriorityQ_11279 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		// 최대 힙
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());

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
