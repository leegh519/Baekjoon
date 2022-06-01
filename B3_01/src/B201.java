import java.util.Scanner;

public class B201 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		long min = 0;

		if (a < b) {
			min = a;
			System.out.println(b - min - 1);
			for(long i=a+1;i<b;i++) {
				System.out.print(i+" ");
			}
		} else if (b < a) {
			min = b;
			System.out.println(a - min - 1);
			for(long i=b+1;i<a;i++) {
				System.out.print(i+" ");
			}
		} else {
			System.out.println(0);
		}


		sc.close();
	}

}
