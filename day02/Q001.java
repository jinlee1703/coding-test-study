package day02;

import java.util.Scanner;

/**
 * Q001
 */
public class Q001 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String str = sc.next();
    char[] num = str.toCharArray();
    System.out.println(solution(n, num));
  }

  static int solution(int n, char[] num) {
    int answer = 0;

    for (int i = 0; i <n; i++) {
      answer +=  num[i] - '0';
    }

    return answer;
  }
}