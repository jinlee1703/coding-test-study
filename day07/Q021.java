package day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q021 {
  static int[] num, tmp;
  static int answer = 0;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    num = new int[n + 1];
    tmp = new int[n + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }
    mergeSort(1, n);
    System.out.println(answer);
  }
  
  static void mergeSort(int start, int end) {
    if (end - start < 1) {
      return;
    }

    int mid = start + (end - start) / 2;

    mergeSort(start, mid);
    mergeSort(mid + 1, end);

    for (int i = start; i <= end; i++) {
      tmp[i] = num[i];
    }

    int k = start;
    int index1 = start;
    int index2 = mid + 1;
    while (index1 <= mid && index2 <= end) {
      if (tmp[index1] > tmp[index2]) {
        num[k] = tmp[index2];
        answer = answer + index2 - k;
        k++;
        index2++;
      } else {
        num[k] = tmp[index1];
        k++;
        index1++;
      }
    }
    while (index1 <= mid) {
      num[k] = tmp[index1];
      k++;
      index1++;
    }
    while (index2 <= end) {
      num[k] = tmp[index2];
      k++;
      index2++;
    }
  }
}
