package day08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q025 {
  static int n;
  static int m;
  static List<Integer>[] graph;
  static boolean[] visited;
  static int answer = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    graph = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int v = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      graph[v].add(e);
      graph[e].add(v);
    }

    visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      dfs(i, 1);
    }
    
    System.out.println(answer);
  }

  static void dfs(int v, int depth) {
    visited[v] = true;
    
    if (depth == 5 || answer == 1) {
      answer = 1;
      return;
    }

    for (int elem : graph[v]) {
      if (!visited[elem]) {
        dfs(elem, depth + 1);
      }
    }
    visited[v] = false;
  }
}
