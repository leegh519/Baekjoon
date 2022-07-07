package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//	https://www.acmicpc.net/problem/1874
//	Stack

public class Stack_1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int a = 1;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 첫번째 수만큼 스택에 push
		for (int i = 0; i < arr[0]; i++) {
			s.push(a++);
			sb.append("+\n");
		}
		
		for (int i = 0; i < arr.length; i++) {
			
			// 스택이 비면 바로 1개채움
			if (s.isEmpty()) {
				s.push(a++);
				sb.append("+\n");
			}
			
			// 스택의 최상위 숫자가 입력보다 작으면 
			// 같아질때까지 스택에 push
			while (s.peek() < arr[i]) {
				s.push(a++);
				sb.append("+\n");
			}
			
			// 스택의 peek랑 입력이 같으면 pop
			if (s.peek() == arr[i]) {
				s.pop();
				sb.append("-\n");
			}
			// else=>스택의 peek보다 입력이 작으면 불가능
			else {
				sb.delete(0, sb.length());
				sb.append("NO");
				break;
			}
		}
		System.out.println(sb);

	}

}
