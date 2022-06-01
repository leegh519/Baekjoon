import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2675 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int t = Integer.parseInt(br.readLine());

		for (int j = 0; j < t; j++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			String s = st.nextToken();

			for (int k = 0; k < s.length(); k++) {
				for (int i = 0; i < r; i++) {
					System.out.print(s.charAt(k));
				}
			}
			System.out.println();

		}

	}

}
