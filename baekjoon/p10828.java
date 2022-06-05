import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10828 {

	static int[] stack = new int[10000];
	static int index = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int x = 0;

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (st.hasMoreTokens()) {
				x = Integer.parseInt(st.nextToken());
			}

			if (command.equals("push")) {
				push(x);
			} else if (command.equals("pop")) {
				System.out.println(pop());
			} else if (command.equals("size")) {
				System.out.println(size());
			} else if (command.equals("empty")) {
				System.out.println(empty());
			} else if (command.equals("top")) {
				System.out.println(top());
			}

		}
	}

	private static void push(int n) {
		stack[++index] = n;
	}

	private static int pop() {
		if (empty() == 1) {
			return -1;
		} else {
			int n = stack[index];
			index--;
			return n;
		}
	}

	private static int size() {
		return index + 1;
	}

	private static int empty() {
		if (index <= -1) {
			return 1;
		} else {
			return 0;
		}
	}

	private static int top() {
		if (empty() == 1) {
			return -1;
		} else {
			return stack[index];
		}
	}
}
