package day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q007 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    
    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());

    int[] num = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      num[i] = (Integer.parseInt(st.nextToken()));
    }

    System.out.println(solution(n, m, num));
  }

  static int solution(int n, int m, int[] num) {
    int answer = 0;

    Arrays.sort(num);

    int start = 0;
    int end = n - 1;

    while (start < end) {
      if (num[start] + num[end] == m) {
        ++answer;
        ++start;
        --end;
      } else if (num[start] + num[end] > m) {
        --end;
      } else {
        ++start;
      }
    }

    return answer;
  }
}
