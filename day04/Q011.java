package day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q011 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solution(n, arr));
  }

  static String solution(int n, int[] arr) {
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    int i = 1;
    for (int x = 0; x < n; x++) {
      int num = arr[x];

      while (num >= i) {
        stack.push(i++);
        sb.append("+\n");
      }
      if (stack.pop() != num) {
        return "NO";
      }
      sb.append("-\n");
    }

    return sb.toString().substring(0, sb.toString().length() - 1);
  }
}
