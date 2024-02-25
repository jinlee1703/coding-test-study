package day12;

import java.util.Scanner;

public class Q040 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    long m = sc.nextLong();
    boolean[] check = new boolean[(int)(m - n + 1)];
    for (long i = 2; i * i <= m; i++) {
      long pow = i * i;
      long start = n / pow;
      if (n % pow != 0) {
        start++;
      }
      for (long j = start; pow * j <= m; j++) {
        check[(int)((j * pow) - n)] = true;
      }
    }
    int answer = 0;
    for (int i = 0; i <= m - n; i++) {
      if (!check[i]) {
        answer++;
      }
    }
    System.out.println(answer);
  }
}
