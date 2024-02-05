package day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q017 {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String numberString = reader.readLine();
    int[] num = new int[numberString.length()];
    int i = 0;
    for (char c : numberString.toCharArray()) {
      num[i++] = c - '0';
    }
    System.out.println(solution(num));
  }

  static String solution(int[] num) {
    // int idx = 0;
    for (int i = 0; i < num.length; i++) {
      int idx = i;
      for (int j = i; j < num.length; j++) {
        if (num[idx] < num[j]) {
          idx = j;
        }
      }
      int tmp = num[i];
      num[i] = num[idx];
      num[idx] = tmp;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < num.length; i++) {
      sb.append(num[i]);
    }

    return sb.toString();
  }
}
