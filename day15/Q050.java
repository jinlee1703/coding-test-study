package day15;

import java.util.Scanner;

public class Q050 {
  static int N, M;
  static int[] arr;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    arr = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      arr[i] = i;
    }

    for (int i = 0; i < M; i++) {
      int cmd = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      
      if (cmd == 0) { // union
        union(a, b);
      } else if (cmd == 1) {  //find
        boolean result = find(a) == find(b);
        System.out.println(result ? "YES" : "NO");
      }
    }
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a != b) {
      arr[b] = a;
    }
  }

  private static int find(int a) {
    if (a == arr[a]) {
      return a;
    }

    return arr[a] = find(arr[a]);
  }
}