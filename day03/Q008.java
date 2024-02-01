package day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q008 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int num[] = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }
    System.out.println(solution(n, num));
  }

  static int solution(int n, int[] num) {
    int answer = 0;

    Arrays.sort(num);

    for (int i = 0; i < n; i++) {
      int find = num[i];
      int start = 0;
      int end = n - 1;

      while (start < end) {
        if (num[start] + num[end] == find) {
          if (start != i && end != i) {
            ++answer;
            break;
          } else if (start == i) {
            ++start;
          } else if (end == i) {
            --end;
          }
        } else if (num[start] + num[end] < find) {
          ++start;
        } else {
          --end;
        }
      }
    }
    return answer;
  }
}
