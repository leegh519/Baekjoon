import java.util.Scanner;

public class B3_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int a , b;
		int[] r = new int[t];

		for (int i = 0; i < t; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			r[i] = a%10;
			for (int n = 0; n < b - 1; n++) {
				r[i] = (r[i] * a) % 10;
			}
		}
		for (int i = 0; i < t; i++) {
			if(r[i]==0) {
				System.out.println(10);
			}
			else
				System.out.println(r[i]);
		}

		sc.close();
	}

}
/*
 * import java.util.Scanner;
 * 
 * public class Main {
 * 
 * public static void main(String[] args) {
 * 
 * Scanner sc = new Scanner(System.in); int t = sc.nextInt();
 * 
 * int[] a = new int[t]; int[] b = new int[t]; int[] r = new int[t]; for (int i
 * = 0; i < t; i++) { a[i] = sc.nextInt(); b[i] = sc.nextInt(); r[i] = a[i]; for
 * (int n = 0; n < b[i]-1; n++) { r[i] = r[i] % 10 * a[i]; } } for (int i = 0; i
 * < t; i++) { System.out.println(r[i] % 10); }
 * 
 * sc.close(); }
 * 
 * }
 */
