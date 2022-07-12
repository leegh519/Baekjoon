package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//	https://www.acmicpc.net/problem/1406
//	stack 2개를 이용해서 품
//	linkedlist에 iterator를 사용하는 방법도 있음

public class Stack_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			s1.push(str.charAt(i));
		}
		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			if (s.charAt(0) == 'L') {
				if (!s1.isEmpty()) {
					s2.push(s1.pop());
				}
			} else if (s.charAt(0) == 'D') {
				if (!s2.isEmpty()) {
					s1.push(s2.pop());
				}
			} else if (s.charAt(0) == 'B') {
				if (!s1.isEmpty()) {
					s1.pop();
				}
			} else if (s.charAt(0) == 'P') {
				s1.push(s.charAt(2));
			}
		}
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		while(!s2.isEmpty()){
			bw.write(s2.pop());
		}
		bw.flush();
		bw.close();

	}

}
