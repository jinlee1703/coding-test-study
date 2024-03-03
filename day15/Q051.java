package day15;

import java.util.Scanner;

public class Q051 {
  static int N, M;
  static int[] parent;
  static int[][] graph;
  static int[] route;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    N = sc.nextInt();
    M = sc.nextInt();
    
    parent = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    graph = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        graph[i][j] = sc.nextInt();
      }
    }
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (graph[i][j] == 1) {
          union(i, j);
        }
      }
    }
    
    route = new int[M + 1];
    for (int i = 1; i <= M; i++) {
      route[i] = sc.nextInt();
    }

    int index = find(route[1]);
    for (int i = 2; i < route.length; i++) {
      if (index != find(route[i])) {
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      parent[b] = a;
    }
  }

  private static int find(int a) {
    if (a == parent[a]) {
      return a;
    } else {
      return parent[a] = find(parent[a]);
    }
  }
}
