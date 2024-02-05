package day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q016 {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    int[] num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(reader.readLine());
    }
    System.out.println(solution(n, num));
  }

  static int solution(int n, int[] num) {
    int answer = 0;

    Data[] data = new Data[n];
    for (int i = 0; i < n; i++) {
      data[i] = new Data(i, num[i]);
    }
    Arrays.sort(data);
    for (int i = 0; i < n; i++) {
      if (answer < data[i].idx - i) { // 정렬 전 인덱스 - 정렬 후 인덱스 => swap이 일어난 횟수
        answer = data[i].idx - i;
      }
    }
    
    return answer + 1;  // swap의 횟수가 가장 적다 = 마지막으로 swap된 원소이다.
  }

  static class Data implements Comparable<Data> {
    int idx;  // 정렬 전 인덱스
    int val;  // 값

    public Data(int idx, int val) {
      this.idx = idx;
      this.val = val;
    }

    // 값 기준으로 정렬
    public int compareTo(Data o) {
      return this.val - o.val;
    }
  }
}
