package baekjoon.p1620;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			map.put(s, i);
			arr[i] = s;
		}
		for (int i = 0; i < m; i++) {
			String q;
			q = br.readLine();
			if (q.charAt(0) >= 65) {
				bw.write(map.get(q) + 1 + "\n");
			} else {
				int index = Integer.parseInt(q);
				bw.write(arr[index-1] + "\n");
			}
		}
		bw.close();

	}

}
