package silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//	String 시간초과남
//	linkedlist 써보자

public class String_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Character> list = new LinkedList<>();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		int m = Integer.parseInt(br.readLine());
		int cursor = list.size() - 1;

		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			if (s.charAt(0) == 'L') {
				if (cursor > 0) {
					cursor--;
				}
			} else if (s.charAt(0) == 'D') {
				if (cursor < list.size() - 1) {
					cursor++;
				}
			} else if (s.charAt(0) == 'B') {
				if (cursor >= 0) {
					list.remove(cursor);
					if (cursor == list.size())
						cursor--;
				}
			} else if (s.charAt(0) == 'P') {
				list.add(cursor+1, s.charAt(2));
				cursor++;
			}
			for (int j = 0; j < list.size(); j++) {
				bw.write(list.get(j));
			}
			System.out.println(cursor);
			bw.write("\n");
			bw.flush();
		}
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i));
		}
		bw.flush();
		bw.close();

	}

}
