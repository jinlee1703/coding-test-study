package day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q022 {
  static int[] num;
  static long answer;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = Integer.parseInt(br.readLine());
    }
    br.close();
    radixSort(num, 5);
  }

  static void radixSort(int[] num, int maxSize) {
    int[] output = new int[num.length];
    int digit = 1;
    int cnt = 0;

    while (cnt != maxSize) {
      int[] bucket = new int[10];
      for (int i = 0; i < num.length; i++) {
        bucket[(num[i] / digit) % 10]++;
      }
      for (int i = 1; i < 10; i++) {
        bucket[i] += bucket[i - 1];
      }
      for (int i = num.length - 1; i>= 0; i--) {
        output[bucket[(num[i] / digit % 10)] - 1] = num[i];
        bucket[(num[i] / digit) % 10]--;
      }
      for (int i = 0; i < num.length; i++) {
        num[i] = output[i];
      }
      digit *= 10;
      cnt++;
    }

    for (int i = 0; i < output.length; i++) {
      System.out.println(output[i]);
    }
  }
}
