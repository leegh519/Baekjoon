package silver5;

import java.io.*;

public class Dp_9655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		if (n % 2 == 0) {
			bw.write("CY");
		} else {
			bw.write("SK");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
