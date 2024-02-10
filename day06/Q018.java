package day06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q018 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] p = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      p[i] = Integer.parseInt(st.nextToken());
    }
    System.out.println(solution(n, p));
  }

  static int solution(int n, int[] p) {
    int answer = 0;
    int[] arr = new int[n];

    for (int i = 1; i < n; i++) {
      int insertPoint = i;
      int insertValue = p[i];

      for (int j = i - 1; j >= 0; j--) {
        if (p[j] < p[i]) {
          insertPoint = j + 1;
          break;
        }
        if (j == 0) {
          insertPoint = 0;
        }
      }
      for (int j = i; j > insertPoint; j--) {
        p[j] = p[j - 1];
      }
      p[insertPoint] = insertValue;
    }
    
    arr[0] = p[0];
    for (int i = 1; i < n; i++) {
      arr[i] = arr[i-1] + p[i];
    }
    for (int i = 0; i < n; i++) {
      answer += arr[i];
    }

    return answer;
  }
}