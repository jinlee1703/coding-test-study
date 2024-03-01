package day14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q046 {
  static int N, M, K, X;
  static List<Integer>[] list;
  static int[] visited;
  static List<Integer> answer;
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    K = sc.nextInt();
    X = sc.nextInt() - 1;

    list = new ArrayList[N];
    visited = new int[N];
    for (int i = 0; i < N; i++) {
      list[i] = new ArrayList<>();
      visited[i] = -1;
    }

    for (int i = 0; i < M; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      list[a].add(b);
    }
    
    bfs(X);

    answer = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      if (visited[i] == K) {
        answer.add(i);
      }
    }
    if (answer.isEmpty()) {
      System.out.println("-1");
    } else {
      Collections.sort(answer);
      for (int node : answer) {
        System.out.println(node + 1);
      }
    }
  }

  private static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start]++;

    int depth = 0;
    while (!queue.isEmpty()) {
      if (depth == K) {
        break;
      }

      int now = queue.poll();

      for (int node : list[now]) {
        if (visited[node] == -1) {
          visited[node] = visited[now] + 1;
          queue.add(node);
        }
      }
      depth++;
    }
  }
}