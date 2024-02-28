package day13;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q044 {
  static List<Node>[] A;
  static boolean visited[];
  static long D[];
  static long lcm;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    A = new ArrayList[N];
    visited = new boolean[N];
    D = new long[N];
    lcm = 1;
    for (int i = 0; i < N; i++) {
      A[i] = new ArrayList<>();
    }
    for (int i = 0; i < N - 1; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int p = sc.nextInt();
      int q = sc.nextInt();
      A[a].add(new Node(b, p, q));
      A[b].add(new Node(a, q, p));
      lcm *= (p * q / gcd(p, q));
    }
    D[0] = lcm;
    DFS(0);
    long mgcd = D[0];
    for (int i = 1; i < N; i++) {
      mgcd = gcd(mgcd, D[i]);
    }
    for (int i = 0; i < N; i++) {
      System.out.print(D[i] / mgcd + " ");
    }
  }

  private static long gcd(long a, long b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }

  public static void DFS(int node) {
    visited[node] = true;
    for (Node i : A[node]) {
      int next = i.b;
      if (!visited[next]) {
        D[next] = D[node] * i.q / i.p;
        DFS(next);
      }
    }
  }
}

class Node {
  int b;
  int p;
  int q;

  public Node(int b, int p, int q) {
    this.b = b;
    this.p = p;
    this.q = q;
  }
}
