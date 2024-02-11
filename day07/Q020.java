package day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Q020
 */
public class Q020 {
  static int[] num, tmp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(br.readLine());
    }
    solution(n, num);
  }

  static void solution(int n, int[] num) {
    
  }

  static void mergeSort(int start, int end, int[] num) {
    if (end - start < 1) {
      return;
    }
    int mid = start + (end - start) / 2;

    mergeSort(start, mid, num);
    mergeSort(mid + 1, end, num);

    for (int i = start; i <= end; i++) {
      tmp[]
    }
  }
}