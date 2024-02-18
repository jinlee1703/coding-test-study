package day09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q029 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 데이터 입력
    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    
    // 정렬
    Arrays.sort(A);
    
    // 찾아야할 숫자 입력
    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int target = Integer.parseInt(st.nextToken());
      System.out.println(binarySearch(A, target, 0, N - 1) != -1 ? 1 : 0);
    }
  }

  private static int binarySearch(int[] arr, int target, int start, int end) {
    if (start > end) {
      return -1;
    }

    int mid = start + (end - start) / 2;

    if (arr[mid] > target) {
      return binarySearch(arr, target, start, mid - 1);
    } else if (arr[mid] < target) {
      return binarySearch(arr, target, mid + 1, end);
    } else {
      return mid;
    }
  }
}
