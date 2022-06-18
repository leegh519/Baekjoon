package silver4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Binsearch_1920 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		
		int start, end, middle, result = 0;
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b.length; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a);
		
		
		
		for (int i = 0; i < b.length; i++) {
			start = 0;
			end = n-1;
			result=0;
			while (start <= end) {
				middle = (start+end)/2;
				if(b[i]<a[middle]) {
					end=middle-1;
				}
				else if(b[i]>a[middle]) {
					start=middle+1;
				}
				else if(b[i]==a[middle]) {
					result=1;
					break;
				}
			}
			System.out.println(result);
		}

	}

}
