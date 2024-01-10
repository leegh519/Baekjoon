import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy_13305 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] distance = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < distance.length; i++) {
            if (price[i] < min) {
                min = price[i];
            }
            sum += ((long) min * distance[i]);
        }

        System.out.println(sum);
    }

}
