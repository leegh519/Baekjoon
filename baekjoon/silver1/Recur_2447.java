package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recur_2447 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				star(n, i, j);
			}
			System.out.println();
		}

	}

	public static void star(int n, int i, int j) {
		if (i / n % 3 == 1 && j / n % 3 == 1) {
			System.out.print(" ");
		} else if (n / 3 == 0) {
			System.out.print("*");
		} else {
			star(n / 3, i, j);
		}
	}

}

//if(i%3==1) {
//	if(j%3==1) {
//		System.out.print(" ");
//	}else {
//		System.out.print("*");
//	}
//}else{
//	System.out.print("*");
//}