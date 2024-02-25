package day12;

import java.util.Scanner;

public class Q037 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    boolean[] num = new boolean[m + 1];
    num[0] = true;
    num[1] = true;
    for (int i = 2; i <= Math.sqrt(m); i++) {
      if (!num[i]) {
        for (int j = i + i; j <= m; j += i) {
          num[j] = true;
        }
      }
    }

    for (int i = n; i <= m; i++) {
      if (!num[i]) {
        System.out.println(i);
      }
    }
  }
}
