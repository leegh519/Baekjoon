package baekjoon.p1065;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		if(n<100) {
			System.out.println(n);
		}else if(n<1000){
			for (int i = 100; i <= n; i++) {
				int k =i;
				if(((k/10)%10-(k/100)%10) == (k%10-(k/10)%10)){
					count++;
				}
				
			}
			System.out.println(99+count);
		}else {
			System.out.println(144);
		}
	}

}
