package silver4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데,
적혀있는 수는 -2^62보다 크거나 같고, 2^62보다 작거나 같다.
준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 
만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.
*/

public class Map_11652 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Long> set = new HashSet<>();
		Map<Long, Long> map = new HashMap<>();

		int n = Integer.parseInt(br.readLine());
		long max = Long.MIN_VALUE;
		long min = Long.MAX_VALUE;

		// set에 하나씩 입력
		// map<숫자, 갯수>에 같이 입력
		// 중복일경우 map의 value값 1증가
		// set에 값들 하나씩 꺼내와서
		// map의 value값들 비교하여
		// value 최댓값과 그때 키값 저장

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