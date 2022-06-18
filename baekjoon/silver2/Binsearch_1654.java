package silver2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/* 백준 1654번 문제 랜선자르기
 * 길이가 다양한 k개의 랜선을 잘라 n개의 랜선을 만들때 
 * 만들수 있는 랜선의 최대 길이 구하기
 * 1부터 k개의 랜선중 젤 긴 랜선길이를 범위로 이진탐색으로 찾기
 * 
 */

public class Binsearch_1654 {

   public static void main(String[] args) throws NumberFormatException, IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int k = Integer.parseInt(st.nextToken());
      long n = Long.parseLong(st.nextToken());
      long[] c = new long[k];
      long max = 0;
      long left = 1, right, key = 0;

      for (int i = 0; i < c.length; i++) { 
         c[i] = Integer.parseInt(br.readLine());
         if (c[i] >= max) {
            max = c[i];
         }
      }
      right = max;

      while (left <= right) {         // left, right, key값이 같은 경우 확인해야함.
         key = (left + right) / 2;
         long sum = 0;               // 길이가 1짜리 랜선의 경우 sum이 int로 부족함.
         
         for (int i = 0; i < c.length; i++) {      // 랜선의 길이가 key값일때 만들수 있는 랜선의 갯수
            sum += (c[i] / key);
         }
         
         
         if ((right-left) <= 1) {                     // 아래 조건에서 left = key로 설정했기때문에 종료조건을 설정해줘야함.
            int sumr = 0;
            for (int i = 0; i < c.length; i++) {      // left와 right값이 같거나 1차이 일때 
               sumr += (c[i] / right);
            }
            if (n <= sumr) {                        // right를 키값으로 했을때 조건을 만족하면 
               key = right;                        // 키값에 right를 넣고 탐색종료
               break;   
            }
            break;                                 // right가 조건을 만족하지 않으면 key값 그대로 탐색종료
         }
         
         if (sum < n) {            // 만들수 있는 랜선의 갯수가 필요한 갯수보다 적을경우
            right = key - 1;      // 왼쪽 범위에 대해 다시 탐색, 랜선의 길이를 줄여 갯수 늘리기
         } else if (sum >= n) {      // 만들수 있는 랜선의 갯수가 필요한 갯수보다 같거나 많은 경우
            left = key;               // 현재 키값이 랜선의 최대 길이인 경우도 있으니 키값을 살려서 오른쪽범위 탐색
         }
      }
      
      System.out.println(key);
   }
}