package day13;

import java.util.Scanner;

public class Q043 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long a = sc.nextLong();
    long b = sc.nextLong();
    long answer = gcd(a, b);
    StringBuilder sb = new StringBuilder();
    while (answer > 0) {
      sb.append("1");
      answer--;
    }
    System.out.println(sb);
  }

  private static long gcd(long a, long b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
}
