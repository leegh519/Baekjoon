import java.util.Scanner;

public class B303 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str;

		while(sc.hasNextLine()) {
			str = sc.nextLine();
			if (str.length() == 0)
				break;
			System.out.println(str);
		}

		sc.close();
	}

}
