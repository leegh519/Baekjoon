import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		if (n == 1) {
			while (st.hasMoreTokens()) {
				if (Integer.parseInt(st.nextToken()) != ++n) {
					System.out.println("mixed");
					return;
				} else {
					continue;
				}
			}
			System.out.println("ascending");
		} else if (n == 8) {
			while (st.hasMoreTokens()) {
				if (Integer.parseInt(st.nextToken()) != --n) {
					System.out.println("mixed");
					return;
				} else {
					continue;
				}
			}
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}

	}

}
