package day14;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q049 {
  static int[] sender = { 0, 0, 1, 1, 2, 2};
  static int[] recevier = {1, 2, 0, 2, 0, 1};
  static boolean[][] visited;
  static boolean answer[];
  static int now[];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    now = new int[3];
    now[0] = sc.nextInt();
    now[1] = sc.nextInt();
    now[2] = sc.nextInt();
    visited = new boolean[201][201];
    answer = new boolean[201];
    bfs();
    for (int i = 0; i < answer.length; i++) {
      if (answer[i]) System.out.println(i + " ");
    }
  }

  private static void bfs() {
    Queue<AB> queue = new LinkedList<>();
    queue.add(new AB(0, 0));
    visited[0][0] = true;
    answer[now[2]] = true;
    
    while (!queue.isEmpty()) {
      AB p = queue.poll();
      int A = p.A;
      int B = p.B;
      int C = now[2] - A - B;
      for (int k = 0; k < 6; k++) {
        int[] next = {A, B, C};
        next[recevier[k]] += next[sender[k]];
        next[sender[k]] = 0;
        if (next[recevier[k]] > now[recevier[k]]) {
          next[sender[k]] = next[recevier[k]] - now[recevier[k]];
          next[recevier[k]] = now[recevier[k]];
        }
        if (!visited[next[0]][next[1]]) {
          visited[next[0]][next[1]] = true;
          queue.add(new AB(next[0], next[1]));
          if (next[0] == 0) {
            answer[next[2]] = true;
          }
        }
      }
    }
  }
}

class AB {
  int A;
  int B;

  public AB(int A, int B) {
    this.A = A;
    this.B = B;
  }
}
