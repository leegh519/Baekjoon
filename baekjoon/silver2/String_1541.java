package silver2;
import java.io.*;
import java.util.*;

//	https://www.acmicpc.net/problem/1541

public class String_1541 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int index = -1;
		int result = 0;
		int sum = 0;

		// 첫번째 -의 인덱스 값을 저장함
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '-') {
				index = i;
				break;
			}
		}

		// -가 없으면 그냥 다 더하고
		// -있으면 -전으로 숫자 다 더하고
		// -이후 숫자 다 더해서
		// 앞 숫자에서 뒷 숫자뺌
		if (index == -1) {
			StringTokenizer st = new StringTokenizer(s, "+-");
			while (st.hasMoreTokens()) {
				sum += Integer.parseInt(st.nextToken());
			}
		} else {
			StringTokenizer st = new StringTokenizer(s.substring(0, index), "+-");
			while (st.hasMoreTokens()) {
				sum += Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(s.substring(index, s.length()), "+-");
			while (st.hasMoreTokens()) {
				result += Integer.parseInt(st.nextToken());
			}
			sum -= result;
		}

		System.out.println(sum);

	}

}
