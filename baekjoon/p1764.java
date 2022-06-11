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
 ù° �ٿ� �赵 ���� ����� �� N, ���� ���� ����� �� M�� �־�����.
 �̾ ��° �ٺ��� N���� �ٿ� ���� �赵 ���� ����� �̸���, N+2° �ٺ��� ���� ���� ����� �̸��� ������� �־�����.
 �̸��� ���� ���� ���ĺ� �ҹ��ڷθ� �̷������, �� ���̴� 20 �����̴�. N, M�� 500,000 ������ �ڿ����̴�.
 �赵 ���� ����� ��ܿ��� �ߺ��Ǵ� �̸��� ������, ���� ���� ����� ��ܵ� ���������̴�.
 �躸���� ���� �� ����� ���������� ����Ѵ�. 
*/

public class p1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();

		// set�� �ϳ��� �Է�
		// �ߺ��Ǵ� �������� �躸�� list�� �Է�
		// list ���� �� size�� node �ϳ��� ���

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
