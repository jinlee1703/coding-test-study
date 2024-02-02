package day04;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q014 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] num = new int[n];

    for (int i = 0; i < n; i++) {
      num[i] = sc.nextInt();
    }
    solution(n, num);
  }

  static void solution(int n, int[] num) {
    Queue<Integer> queue = new PriorityQueue<>((e1, e2) -> {
      if (Math.abs(e1) == Math.abs((e2)))
        return e1 > e2 ? 1 : -1;
      else
        return Math.abs(e1) >  Math.abs(e2) ? 1 : -1;
    });
    for (int i = 0; i < n; i++){
      if (num[i] == 0) {
        if (queue.isEmpty()) {
          System.out.println(0);
        } else {
          System.out.println(queue.poll());
        }
      } else {
        queue.add(num[i]);
      }
    }
  }
}
