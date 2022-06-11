import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
�رԴ� ���� ī�� N���� ������ �ִ�. ���� ī�忡�� ������ �ϳ� �����ִµ�,
�����ִ� ���� -2^62���� ũ�ų� ����, 2^62���� �۰ų� ����.
�ر԰� ������ �ִ� ī�尡 �־����� ��, ���� ���� ������ �ִ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 
����, ���� ���� ������ �ִ� ������ ���� �������, ���� ���� ����Ѵ�.
*/

public class p11652 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Long> set = new HashSet<>();
		Map<Long, Long> map = new HashMap<>();

		int n = Integer.parseInt(br.readLine());
		long max = Long.MIN_VALUE;
		long min = Long.MAX_VALUE;

		// set�� �ϳ��� �Է�
		// map<����, ����>�� ���� �Է�
		// �ߺ��ϰ�� map�� value�� 1����
		// set�� ���� �ϳ��� �����ͼ�
		// map�� value���� ���Ͽ�
		// value �ִ񰪰� �׶� Ű�� ����

		for (int i = 0; i < n; i++) {
			long num = Long.parseLong(br.readLine());
			if (set.contains(num)) {
				if (map.containsKey(num)) {
					long val = map.get(num) + 1;
					map.put(num, val);
				} else {
					map.put(num, (long) 1);
				}
			} else {
				set.add(num);
				map.put(num, (long) 1);
			}
		}

		Iterator<Long> it = set.iterator();
		while (it.hasNext()) {
			long num = it.next();
			if (map.get(num) > max) {
				max = map.get(num);
				min = num;
			} else if (map.get(num) == max) {
				if (num < min) {
					min = num;
				}

			}
		}

		System.out.println(min);

	}

}
