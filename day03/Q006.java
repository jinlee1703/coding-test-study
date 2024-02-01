package day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Q006
 */
public class Q006 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    System.out.println(solution(n));
  }

  static int solution(int n) {
    int answer = 1;
    int startIndex = 1;
    int endIndex = 1;
    int sum = 1;

    while (endIndex < n) {
      if (sum == n) {
        ++answer;
        ++endIndex;
        sum += endIndex;
      } else if (sum > n) {
        sum -= startIndex;
        ++startIndex;
      } else {
        ++endIndex;
        sum += endIndex;
      }
    }
    return answer;
  }
}