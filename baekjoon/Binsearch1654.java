import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/* ���� 1654�� ���� �����ڸ���
 * ���̰� �پ��� k���� ������ �߶� n���� ������ ���鶧 
 * ����� �ִ� ������ �ִ� ���� ���ϱ�
 * 1���� k���� ������ �� �� �������̸� ������ ����Ž������ ã��
 * 
 */

public class Binsearch1654 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		long n = Long.parseLong(st.nextToken());
		long[] c = new long[k];
		long max = 0;
		long left = 1, right, key = 0;

		for (int i = 0; i < c.length; i++) { // c.length�� k�̶� �ð����̳����� Ȯ���غ���
			c[i] = Integer.parseInt(br.readLine());
			if (c[i] >= max) {
				max = c[i];
			}
		}
		right = max;

		while (left <= right) {			// left, right, key���� ���� ��� Ȯ���ؾ���.
			key = (left + right) / 2;
			long sum = 0;					// ���̰� 1¥�� ������ ��� sum�� int�� ������.
			
			for (int i = 0; i < c.length; i++) {		// ������ ���̰� key���϶� ����� �ִ� ������ ����
				sum += (c[i] / key);
			}
			
			
			if ((right-left) <= 1) {							// �Ʒ� ���ǿ��� left = key�� �����߱⶧���� ���������� �����������.
				int sumr = 0;
				for (int i = 0; i < c.length; i++) {		// left�� right���� ���ų� 1���� �϶� 
					sumr += (c[i] / right);
				}
				if (n <= sumr) {								// right�� Ű������ ������ ������ �����ϸ� 
					key = right;								// Ű���� right�� �ְ� Ž������
					break;	
				}
				break;											// right�� ������ �������� ������ key�� �״�� Ž������
			}
			
			if (sum < n) {				// ����� �ִ� ������ ������ �ʿ��� �������� �������
				right = key - 1;		// ���� ������ ���� �ٽ� Ž��, ������ ���̸� �ٿ� ���� �ø���
			} else if (sum >= n) {		// ����� �ִ� ������ ������ �ʿ��� �������� ���ų� ���� ���
				left = key;					// ���� Ű���� ������ �ִ� ������ ��쵵 ������ Ű���� ����� �����ʹ��� Ž��
			}
		}
		
		System.out.println(key);
	}
}