package baekjoon.p4673;

public class Main {

	public static void main(String[] args) {

		int[] c = new int[10001];
		for (int i = 0; i < c.length; i++) {
			c[i] = i;
		}
		for (int i = 1; i <= 10000; i++) {
			int j = i;
			int sum = j;
			while (j > 0) {
				sum = sum + (j % 10);
				j /= 10;
			}
			if (sum < 10001) {
				c[sum] = 0;
			}
		}

		for (int i = 0; i < 10000; i++) {
			if (c[i] != 0) {
				System.out.println(c[i]);

			}
		}

	}

}
