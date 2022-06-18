package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11720 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			// char를 int로 값을 그대로 변환하려면
			// Character.getNumericValue(char c)
			sum += Character.getNumericValue(s.charAt(i));
		}
		System.out.println(sum);
	}

}
