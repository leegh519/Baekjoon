package silver4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//	https://www.acmicpc.net/problem/10845
//	큐 구현문제

public class Queue_10845 {

	static int[] queue = new int[10000];
	static int front = 0;
	static int back = -1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int num = 0;
			if (st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
			}
			switch (s) {
			case "push":
				push(num);
				break;
			case "pop":
				pop();
				break;
			case "size":
				size();
				break;
			case "empty":
				empty();
				break;
			case "front":
				front();
				break;
			case "back":
				back();
				break;
			}
		}

	}

	public static void push(int n) {
		queue[++back] = n;
	}

	public static void pop() {
		if (front > back) {
			System.out.println(-1);
		} else {
			System.out.println(queue[front]);
			front++;
		}
	}

	public static void size() {
		int n = back - front + 1;
		if (n < 0) {
			System.out.println(0);
		} else {
			System.out.println(back - front + 1);
		}
	}

	public static void empty() {
		int n = back - front + 1;
		if (n < 1) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	public static void front() {
		int n = back - front + 1;
		if (n < 1) {
			System.out.println(-1);
		} else {
			System.out.println(queue[front]);
		}
	}

	public static void back() {
		int n = back - front + 1;
		if (n < 1) {
			System.out.println(-1);
		} else {
			System.out.println(queue[back]);
		}
	}

}