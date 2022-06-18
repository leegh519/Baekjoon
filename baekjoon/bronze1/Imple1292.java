package bronze1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Imple1292 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] arr = new int[1000];
		int n = 0;
		int sum = 0;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i && n < 1000; j++) {
				arr[n++] = i;
			}
		}

		for (int i = a-1; i < b; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}

}
