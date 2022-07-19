package baekjoon;
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
			StringTokenizer st = new StringTokenizer(ox,"X");
			
			// x 기준으로 문자열 잘라서
			// ooooo..이렇게 나오면 
			// 잘린 문자열 각각 길이구해서 그거 더해서 점수구했음
			// OOXXOXXOOO->입력
			// OO, O, OOO 이렇게 잘라서
			// 1+2, 1, 1+2+3 이거 전부 더한듯?
			while (st.hasMoreTokens()) {
				try {
					String s = st.nextToken().trim();
					System.out.println(s);
					for (int j = 0; j < s.length(); j+=2) {
						sum += (j + 1);
					}
				} catch (NoSuchElementException e) {

				}
			}
			System.out.println(sum);
		}

	}

}
