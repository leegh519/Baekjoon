import java.util.Scanner;

public class B304 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			if (n % h == 0) {
				System.out.print(h);
				System.out.printf("%02d\n", (n / h));
			} else {
				System.out.print(n % h);
				System.out.printf("%02d\n", (n / h + 1));
			}
		}

		sc.close();
	}

}
