import java.io.*;
import java.util.*;

public class p1541 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Integer> stack = new Stack<>();
		int st = 0;
		int ed;
		int result = 0;
		int sum = -1;
		for (int i = 0; i < s.length(); i++) {
			result = 0;
			if (s.charAt(i) == '+') {
				ed = i;
				stack.push(Integer.parseInt(s.substring(st, ed)));
				st = i + 1;
			} else if (s.charAt(i) == '-') {
				ed = i;
				stack.push(Integer.parseInt(s.substring(st, ed)));
				st = i + 1;
				while (!stack.isEmpty()) {
					result += stack.pop();
				}
				sum = result;
				result = 0;
				String str = s.substring(i + 1, s.length());
				System.out.println(str);
				StringTokenizer strto = new StringTokenizer(str, "+-");
				while (strto.hasMoreTokens()) {
					stack.push(Integer.parseInt(strto.nextToken()));
				}
				break;
			

			} else if (i == s.length() - 1) {
				stack.push(Integer.parseInt(s.substring(st, s.length())));
				while (!stack.isEmpty()) {
					result += stack.pop();
				}
				if (sum == -1) {
					sum = result;
				} else {
					sum -= result;
				}
			}
		}

		System.out.println(sum);
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		System.out.println(result);
		sum -= result;

		System.out.println(sum);

	}

}
