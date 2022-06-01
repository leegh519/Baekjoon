package baekjoon.p4344;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int c = Integer.parseInt(br.readLine());

		for (int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			int sum=0;
			int cnt=0;
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum+=arr[j];
			}
			for (int j = 0; j < n; j++) {
				if(arr[j]>(sum/n)) {
					cnt++;
				}
			}
			System.out.printf("%.3f%%\n",((double)cnt/n)*100);
		}

	}

}
