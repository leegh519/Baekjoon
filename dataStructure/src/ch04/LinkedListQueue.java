package ch04;

import java.io.*;
import java.util.*;

public class LinkedListQueue {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int count = 0;
		int index = k - 1;
		List<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		System.out.print("<");
		while (true) {
			System.out.print(q.get(index));
			
			q.remove(index);
			index += k-1;
			count++;
			if(count == n) {
				break;
			}
			while (index >= q.size()) {
				index -= q.size();
			}
			System.out.print(", ");
		}
		System.out.print(">");
	}

}
