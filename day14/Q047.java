package day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q047 {
  static int N;
  static int M;
  static ArrayList<Integer>[] graph;
  static int[] answer;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    graph = new ArrayList[N];
    answer = new int[N];
    for (int i = 0; i < N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      graph[a].add(b);
    }

    int max = 0;
    for (int i = 0; i < N; i++) {
      boolean[] visited = new boolean[N];
      bfs(visited, i);
    }
    for (int i = 0; i < N; i++) {
      if (answer[i] > max) {
        max = answer[i];
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      if (answer[i] == max) {
        sb.append(i + 1);
        sb.append(" ");
      }
    }
    System.out.println(sb.substring(0, sb.toString().length() - 1));
  }

  private static void bfs(boolean[] visited, int v) {
    Queue<Integer> q = new LinkedList<>();
    q.add(v);
    visited[v] = true;

    while (!q.isEmpty()) {
      int now = q.poll();
      for (int node : graph[now]) {
        if (!visited[node]) {
          q.add(node);
          visited[node] = true;
          answer[node]++;
        }
      }
    }
  }
}
