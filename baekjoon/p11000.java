import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class p11000 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			} else {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		List<Integer> list = new LinkedList<>();
		list.add(arr[0][1]);
		for (int i = 1; i < n; i++) {
			int j = 0;
			for (; j < list.size(); j++) {
				if (arr[i][0] >= list.get(j)) {
					list.add(j, arr[i][1]);
					list.remove(j + 1);
					break;
				}
			}
			if (j == list.size()) {
				list.add(arr[i][1]);
			}
		}
		System.out.println(list.size());

	}

}
