package day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q005 {
  /**
   * 슈도 코드
   * 1. N(수의 개수)과 M(구간 합을 나눌 수)
   * 2. 구간합을 저장할 int[] sum[n + 1] 선언
   * 3. for 반복문을 통해 구간합 저장
   * 4. for(i = 0~n-1): for(j = i~n-1)을 통해 구간합을 체크하고 m으로 나누어 떨어질 때 마다 ++answer
   */

   public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] sum = new int[n];
    int[] c = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n; i++) {
      sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
    }

    // int answer = 0;
    // for (int i = 1; i <= n; i++) {
    //   int result = 0;
    //   for (int j = i; j <= n; j++) {
    //     result += sum[j] - sum[i];
    //     if (result % m == 0) {
    //       // System.out.println(i + " ~ " + j);
    //       ++answer;
    //     }
    //   }
    // }
    // System.out.println(answer);

    int answer = 0;
    for (int i = 0; i < n; i++) {
      int remainder = (int) (sum[i] % m);
      if (remainder == 0) ++answer;

      ++c[remainder];
    }

    for (int i = 0; i < m; i++) {
      if (c[i] > 1) {
        answer += (c[i] * (c[i] - 1) / 2);
      }
    }

    System.out.println(answer);
   }
}
