package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//	https://www.acmicpc.net/problem/1715
//	우선순위 큐
//	항상 카드 수가 가장 적은 덱끼리 합쳐야 함
//	작은덱 2개 합치고 다시 큐에 넣어서
//	합친덱이랑 남은덱중에서 다시 적은 덱 2개를 합침
//	n=1이면 합치지 않으므로 0

public class PriorityQ_1715 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			q.add(a);
		}
				
		/*
		if (n == 1) {
			System.out.println(0);
			return;
		}
		while (!q.isEmpty()) {
			int a = q.poll();
			if (q.isEmpty()) {
				sum += a;
			} else {
				int b = q.poll();
				sum = sum + a + b;
				if (q.isEmpty()) {
					break;
				}
				q.add(a + b);
			}
		}
		*/
		
		while(q.size() > 1) {
			int a = q.poll();
			int b = q.poll();
			sum += (a + b);
			q.offer(a + b);
		}
		
		System.out.println(sum);
	}

}
