package baekjoon.p1002;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int t = Integer.parseInt(br.readLine());
		int[] xyr = new int[6];
		double dis;

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < xyr.length; j++) {
				xyr[j] = Integer.parseInt(st.nextToken());
			}

			int x = xyr[0] - xyr[3];
			int y = xyr[1] - xyr[4];
			dis = Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));

			if (dis == 0) {
				if (xyr[2] == xyr[5]) {
					bw.write(-1 + "\n");
				} else {
					bw.write(0 + "\n");
				}
			} else if (xyr[2] + xyr[5] == dis || Math.abs(xyr[2] - xyr[5]) == dis) {
				bw.write("1\n");
			} else if (xyr[2] + xyr[5] > dis && Math.abs(xyr[2] - xyr[5]) < dis) {
				bw.write("2\n");
			} else if (xyr[2] + xyr[5] < dis || Math.abs(xyr[2] - xyr[5]) > dis) {
				bw.write("0\n");
			}

		}

		br.close();
		bw.close();
	}

}