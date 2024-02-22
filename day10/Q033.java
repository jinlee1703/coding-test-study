package day10;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q033 {
  public static void main(String[] args) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      queue.add(sc.nextInt());
    }
    int answer = 0;
    while (queue.size() > 1) {
      int elem1 = queue.poll();
      int elem2 = queue.poll();
      answer += elem1 + elem2;
      queue.add(elem1 + elem2);
    }
    System.out.println(answer);
  }  
}