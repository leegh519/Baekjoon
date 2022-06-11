import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/*
 첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다.
 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.
 듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.
 듣보잡의 수와 그 명단을 사전순으로 출력한다. 
*/

public class p1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();

		// set에 하나씩 입력
		// 중복되는 값있으면 듣보잡 list에 입력
		// list 정렬 후 size와 node 하나씩 출력

		for (int i = 0; i < n + m; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				list.add(str);
			} else {
				set.add(str);
			}
		}

		Collections.sort(list);

		System.out.println(list.size());
		for (String a : list) {
			System.out.println(a);
		}

		/*
		 * Map<String, Integer> nolisten = new HashMap<>(); List<String> list = new
		 * LinkedList<>();
		 * 
		 * for(int i=0;i<n;i++) { nolisten.put(br.readLine(), i); }
		 * 
		 * for(int i =0; i<m; i++) { String str = br.readLine();
		 * if(nolisten.get(str)!=null) { list.add(str); } }
		 * 
		 * list.sort(Comparator.naturalOrder()); System.out.println(list.size());
		 * for(int i=0;i<list.size();i++) { System.out.println(list.get(i)); }
		 * 
		 */
	}

}
