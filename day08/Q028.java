package day08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q028 {
  static int n, m;
  static int[] distance;
  static boolean[] visited;
  static List<Edge>[] graph;
  static int max;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new ArrayList[n];
    distance = new int[n];
    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      while (true) {
        int e = Integer.parseInt(st.nextToken());
        if (e == -1) {
          break;
        }
        int weight = Integer.parseInt(st.nextToken());
        graph[s - 1].add(new Edge(e - 1, weight));
      }
    }
    bfs(0);
    max = 0;
    for (int i = 1; i < n; i++) {
      if (distance[max] < distance[i]) {
        max = i;
      }
    }
    distance = new int[n];
    visited = new boolean[n];
    bfs(max);
    Arrays.sort(distance);
    System.out.println(distance[n - 1]);
  }

  static int bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(v);
    visited[v] = true;

    while (!queue.isEmpty()) {
      int vertex = queue.poll();

      for (Edge edge : graph[vertex]) {
        int e = edge.e;
        int weight = edge.weight;

        if (!visited[e]) {
          visited[e] = true;
          queue.add(e);
          distance[e] = distance[vertex] + weight;
        }
      }
    }

    return 0;
  }

  static class Edge {
    int e;
    int weight;

    Edge(int e, int weight) {
      this.e = e;
      this.weight = weight;
    }
  }
}
