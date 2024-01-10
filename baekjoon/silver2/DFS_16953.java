import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_16953 {
    // 나중에 dfs로 다시 풀어볼 것
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int result = 0;

        while (b > a) {
            if (b % 2 == 0) {
                b = b / 2;
                result++;
            } else if (b % 10 == 1) {
                b = b / 10;
                result++;
            } else if (b % 10 != 1) {
                result = -1;
                break;
            }
        }
        if (b == a) {
            result++;

        } else {
            result = -1;
        }
        System.out.println(result);
    }

}
