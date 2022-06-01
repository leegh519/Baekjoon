import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1181 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] s = new String[n];
		String tmp;

		for (int i = 0; i < n; i++) {
			s[i] = br.readLine();
		}
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (s[i].length() > s[j].length()) {
					tmp = s[j];
					s[j] = s[i];
					s[i] = tmp;
				}
				else if(s[i].length()==s[j].length()) {
					if(s[j].compareTo(s[i])<0) {
						tmp = s[j];
						s[j] = s[i];
						s[i] = tmp;
					}
				}
				
			}
		}
		System.out.println(s[0]);
		for(int i=1; i<n;i++) {
			if(s[i].compareTo(s[i-1]) == 0) {
				continue;
			}
			System.out.println(s[i]);
		}

	}

}
