package baekjoon.p2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Object[] obj = new Object[3]; 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		obj[0]=br;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}		
		Arrays.sort(arr);		
		for(int i=0;i<arr.length;i++) {
			bw.write(arr[i]+"\n");
		}		
		bw.flush();
	}
}