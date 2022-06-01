package baekjoon.p1;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		//String s="";
//		
//		while(true){
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			if(a==0&&b==0) {
//				break;
//			}
//			System.out.println(a+b);
//		}
		int[] arr = new int[9];
		int max=0;
		int index=0;
		for(int i =0;i<9;i++) {
			
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]>max) {
				max=arr[i];
				index = i+1;
			}
		}
		System.out.println(max+"\n"+index);
	}

}
