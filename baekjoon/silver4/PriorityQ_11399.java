package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/11399
//	우선순위 큐

public class PriorityQ_11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		int sum = 0;
		int result = 0;
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			q.offer(a);
		}

		while (!q.isEmpty()) {
			sum += q.poll();
			result += sum;
		}
		System.out.println(result);
	}

}
