package b23968;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[a];
		int tmp, count = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
					count++;
				}
				if (count == k) {
					System.out.print(arr[j] + " " + arr[j + 1]);
					i = arr.length;
					break;
				}

			}
		}
		if (count < k) {
			System.out.println(-1);
		}

	}

}
