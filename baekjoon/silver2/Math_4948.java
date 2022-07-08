package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Math_4948 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// n이하 소수 갯수 저장
		int[] arr = new int[246913];
		arr[1] = 1;
		arr[2] = 2;

		int a = 0;

		// 소수 저장
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		for (int i = 3; i < arr.length; i++) {
			arr[i] = arr[i - 1];
			for (int j = 1; j < list.size(); j++) {
				if (i % list.get(j) == 0) {
					a = 0;
					break;
				} else {
					a++;
				}
			}
			// 0이 아니면 소수
			if (a != 0) {
				arr[i]++;
				list.add(i);
			}
		}
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			sb.append(arr[2 * n] - arr[n]).append("\n");
		}
		System.out.println(sb);

	}

}
