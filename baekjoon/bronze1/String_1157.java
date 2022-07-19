package bronze1;

import java.io.*;
import java.util.*;

public class String_1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().toUpperCase();
		int max = 0;

		// 배열활용
		int maxI = -1;
		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'A';
			arr[index]++;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				maxI = i;
			} else if (arr[i] == max) {
				maxI = -1;
			}
		}
		char c = (char) (maxI + 'A');
		if (maxI == -1) {
			c = '?';
		}
		System.out.println(c);

		// map 활용
//		char result = ' ';
//		Map<Character, Integer> map = new HashMap<>();
//		for(int i=0; i<s.length();i++) {
//			if(!map.containsKey(s.charAt(i))) {
//				map.put(s.charAt(i), 1);	
//			}else {
//				map.put(s.charAt(i), map.get(s.charAt(i))+1);
//			}			
//		}
//		Iterator<Character> i = map.keySet().iterator();
//		while(i.hasNext()) {
//			char c = i.next();
//			int a = map.get(c);
//			if(a>max) {
//				max=a;
//				result=c;
//			}else if(a==max) {
//				result='?';
//			}
//		}
//		System.out.println(result);

	}

}
