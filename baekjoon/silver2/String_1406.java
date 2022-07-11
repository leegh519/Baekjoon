package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//	String 시간초과남
//	linkedlist 써보자

public class String_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int cursor = sb.length();
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.equals("L")) {
				if (cursor > 0) {
					cursor--;
				}
			} else if (s.equals("D")) {
				if (cursor < sb.length()) {
					cursor++;
				}
			} else if (s.equals("B")) {
				if (cursor > 0) {
					String s1 = sb.substring(0, cursor-1);
					String s2 = sb.substring(cursor, sb.length());
					sb.setLength(0);
					sb.append(s1).append(s2);
					cursor--;
				}
			}else if(s.equals("P")) {
				String s1 = sb.substring(0, cursor);
				String s2 = sb.substring(cursor, sb.length());
				sb.setLength(0);
				sb.append(s1).append(st.nextToken()).append(s2);
				cursor++;
			}
		}
		System.out.println(sb);

	}

}
