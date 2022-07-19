package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2560 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int cnt=1;
		int sum=0;
		for (int i = 0; i < str.length(); i++) {		
			if (str.charAt(i) == '0') {
				cnt=1;
			}
			if (str.charAt(i) == '1') {
				sum+=cnt++;
			}
		}
		System.out.println(sum);
		int timer=0;
		method1(timer);

	}
	private static void method1(int t) {
		//int b=5;
		method2(t);
	}
	
	
	
	
	private static void method2(int a) {
		a=3;
	}

}
