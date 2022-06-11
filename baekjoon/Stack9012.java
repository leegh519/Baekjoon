import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Stack9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack st = new Stack();
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n;i++) {
			st.clear();
			String str = br.readLine();
			try{
				for(int j = 0; j<str.length();j++) {
					if(str.charAt(j) == '(') {
						st.push('(');
					}else if(str.charAt(j) == ')') {
						st.pop();
					}
				}
				
				if(st.isEmpty()) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
				
			}catch(EmptyStackException e) {
				System.out.println("NO");
			}
		}
		
		
		
	}

}
