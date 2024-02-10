package day06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q019 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    
    int[] num = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }
    quickSort(num, 0, n - 1, k - 1);
    System.out.println(num[k - 1]);
  }

  static void quickSort(int[] num, int start, int end, int k) {
    if (start < end) {
      int pivot = partition(num, start, end);
      if (pivot == k)
        return;
      else if (k < pivot)
        quickSort(num, start, end - 1, k);
      else
        quickSort(num, start + 1, end, k);
    }
  }

  static int partition(int[] num, int start, int end) {
    if (start + 1 == end) {
      if (num[start] > num[end]) swap(num, start, end);
      return end;
    }
    int middle = (start + end) / 2;
    swap(num, start, middle);
    int pivot = num[start];
    int i = start + 1, j = end;
    while (i <= j) {
      while (pivot < num[j] && j > 0) {
        j--;
      }
      while (pivot > num[i] && i < num.length - 1) {
        i++;
      }
      if (i <= j) {
        swap(num, i++, j--);
      }
    }

    num[start] = num[j];
    num[j] = pivot;
    return j;
  }

  static void swap(int[] num, int i, int j) {
    int temp = num[i];
    num[i] = num[j];
    num[j] = temp;
  }
}
