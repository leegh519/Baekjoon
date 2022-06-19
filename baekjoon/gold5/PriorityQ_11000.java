package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/11000
//	우선순위 큐, 그리디
public class PriorityQ_11000 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			} else {
				return Integer.compare(o1[0], o2[0]);
			}
		});

//		우선순위 큐를 사용하여 강의끝나는 시각을 큐에 삽입한다 
//		우선순위 최소큐라서 끝나는 시각이 젤 빠른강의가 젤 위로 온다
//		그러면 큐의 젤 위의 값과 다음 강의 시작 시각을 비교해서
//		시작시각이 젤 빨리 끝나는 강의 끝나는 시각보다 크거나 같으면
//		큐의 최상위 값을 없앤다
//		이 과정을 반복하면 큐 사이즈가 총 강의실 수가 된다.		

		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(arr[0][1]);
		for (int i = 1; i < n; i++) {
			if (arr[i][0] >= q.peek()) {
				q.poll();
			}
			q.add(arr[i][1]);
		}

//  	List사용시 시간초과 남
// 
//		List<Integer> list = new LinkedList<>();
//		list.add(arr[0][1]);
//		for (int i = 1; i < n; i++) {
//			int j = 0;
//			for (; j < list.size(); j++) {
//				if (arr[i][0] >= list.get(j)) {
//					list.add(j, arr[i][1]);
//					list.remove(j + 1);
//					break;
//				}
//			}
//			if (j == list.size()) {
//				list.add(arr[i][1]);
//			}
//		}

		System.out.println(q.size());

	}

}
