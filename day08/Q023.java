package day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q023 {
  static List<Integer>[] graph;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    graph = new ArrayList[n];
    
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int v = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      graph[v - 1].add(e - 1);
      graph[e - 1].add(v - 1);
    }

    System.out.println(solution(n, m, graph));
  }

  static int solution(int n, int m, List<Integer>[] graph) {
    int answer = 0;
    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(i);
        answer++;
      }
    }

    return answer;
  }

  static void dfs(int v) {
    visited[v] = true;
    for (int node : graph[v]) {
      if (!visited[node]) {
        dfs(node);
      }
    }
  }
}
