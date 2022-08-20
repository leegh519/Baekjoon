package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackTracking_14888 {

	static boolean[] visit;
	static String[] aaa;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];

		int[] p = new int[4];
		String[] s = new String[n - 1];
		aaa = new String[n - 1];
		visit = new boolean[n - 1];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < p[i]; j++) {
				if (i == 0) {
					s[idx++] = "+";
				} else if (i == 1) {
					s[idx++] = "-";
				} else if (i == 2) {
					s[idx++] = "*";
				} else if (i == 3) {
					s[idx++] = "/";
				}
			}
		}

		back(arr, 0, 0, s);
		System.out.println(max);
		System.out.println(min);

	}

	private static void back(int[] arr, int index, int sum, String[] s) {
		if (index == aaa.length) {
			int idx = 0;
			sum = arr[0];
			for (int i = 1; i < arr.length; i++) {
				switch (aaa[idx++]) {
				case "+":
					sum += arr[i];
					break;
				case "-":
					sum -= arr[i];
					break;
				case "*":
					sum *= arr[i];
					break;
				case "/":
					sum /= arr[i];
				}
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < s.length; i++) {
			if (!visit[i]) {
				aaa[index] = s[i];
				visit[i] = true;
				back(arr, index + 1, sum, s);
				visit[i] = false;
			}
		}

	}

}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] numbers;
	static int[] operation = new int[4];
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		numbers = new int[n];
		
		StringTokenizer st =new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<4;i++) {
			operation[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(numbers[0],1);
		System.out.println(MAX);
		System.out.println(MIN);
	}
	
	public static void dfs(int cnt, int idx) {
		if(idx==n) {
			if(MAX<cnt) MAX=cnt;
			if(MIN>cnt) MIN=cnt;
			return;
		}
		for(int i=0;i<4;i++) {
			if(operation[i]>0) {
				operation[i]--;
				
				switch(i) {
				case 0:
					dfs(cnt+numbers[idx],idx+1);
					break;
				case 1:
					dfs(cnt-numbers[idx],idx+1);
					break;
				case 2:
					dfs(cnt*numbers[idx],idx+1);
					break;
				case 3:
					dfs(cnt/numbers[idx],idx+1);
					break;
				}
				operation[i]++;
			}
		}
	}
}
*/