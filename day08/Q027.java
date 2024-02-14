package day08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q027 {
  static int n, m;
  static int[][] graph;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    graph = new int[n][m];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        graph[i][j] = Integer.parseInt(line.substring(j, j + 1));
      }
    }
    bfs(0, 0);
    System.out.println(graph[n - 1][m - 1]);
  }

  static void bfs(int x, int y) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(x, y));

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = node.x + dx[i];
        int ny = node.y + dy[i];

        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
          continue;
        }

        if (graph[nx][ny] == 0) {
          continue;
        } 

        if (graph[nx][ny] == 1) {
          graph[nx][ny] = graph[node.x][node.y] + 1;
          queue.add(new Node(nx, ny));
        }
      }
    }
  }

  static class Node {
    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
