package day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q015 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(br.readLine());
    }
    System.out.println(solution(n, num));
  }

  static String solution(int n, int[] num) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        if (num[j] > num[j + 1]) {
          int tmp = num[j];
          num[j] = num[j + 1];
          num[j + 1] = tmp;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      sb.append(num[i]);
      sb.append("\n");
    }
    
    return sb.toString().substring(0, sb.toString().length() - 1);
  }
}
