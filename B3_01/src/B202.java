import java.util.Scanner;

public class B202 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int j=0;j<t;j++) {
			int r =sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			System.out.println(s);
			
			 for(int k=0;k<s.length();k++) {
				 for (int i = 0; i < r; i++) {
						System.out.print(s.charAt(k));
					}
			 }
			
		}
		sc.close();

	}

}
