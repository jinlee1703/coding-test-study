package day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q010 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    
    int[] num = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solution(n, l, num));
  }

  static String solution(int n, int l, int[] num) {
    StringBuilder sb = new StringBuilder();

    Deque<Node> deque = new LinkedList<Node>();
    for (int i = 0; i < n; i++) {
      int now = num[i];

      while (!deque.isEmpty() && deque.getLast().value > now) {
        deque.removeLast();
      }
      deque.addLast(new Node(now, i));

      if (deque.getFirst().index <= i - l) {
        deque.removeFirst();
      }
      sb.append(deque.getFirst().value + " ");
    }

    return sb.toString();
  }

  static class Node {
    public int value;
    public int index;

    Node(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }
}
