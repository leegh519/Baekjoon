package silver4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

//	https://www.acmicpc.net/problem/2217

public class Greedy_2217 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] rope = new Integer[n];

		for (int i = 0; i < n; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}

		// 내림차순 정렬
		Arrays.sort(rope, Collections.reverseOrder());

		// 버틸 수 있는 무게가 작은 로프 무게*로프의 수
		// => 최대중량
		int result = rope[0];
		for (int i = 1; i < n; i++) {
			if (result < rope[i] * (i + 1)) {
				result = rope[i] * (i + 1);
			}
		}
		System.out.println(result);

	}

}
