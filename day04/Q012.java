package day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q012 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    int num[] = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solution(n, num));
  }

  static String solution(int n, int num[]) {
    StringBuilder sb = new StringBuilder();
    int[] answer = new int[n];
    Stack<Integer> stack = new Stack<>();
    stack.push(0);

    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && num[i] > num[stack.peek()]) {
        answer[stack.pop()] = num[i];
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      answer[stack.pop()] = -1;
    }

    for (int i = 0; i < n; i++) {
      sb.append(answer[i] + " ");
    }

    return sb.toString();
  }
}
