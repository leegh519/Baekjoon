package silver4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Stack_4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<Integer>();
		String str = new String();

		while (true) {
			str = br.readLine();
			if(str.equals(".")) {
				break;
			}
			st.clear();

			try {
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '(') {
						st.push(1);
					} else if (str.charAt(i) == '[') {
						st.push(2);
					} else if (str.charAt(i) == ')') {
						if(st.pop() != 1) {
							st.push(0);
							break;
						}
					} else if (str.charAt(i) == ']') {
						if(st.pop() != 2) {
							st.push(0);
							break;
						}
					}

				}

				if (st.isEmpty()) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			} catch (EmptyStackException e) {
				System.out.println("no");
			}

		}

	}

}
