import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class p8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum = 0;
			String ox = br.readLine();
			StringTokenizer st = new StringTokenizer(ox);

			while (st.hasMoreTokens()) {
				try {
					String s = st.nextToken("X");
					for (int j = 0; j < s.length(); j++) {
						sum += (j + 1);
					}
				} catch (NoSuchElementException e) {

				}
			}
			System.out.println(sum);
		}

	}

}
