package day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q036 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int answer = Integer.MIN_VALUE;
    for (String min : br.readLine().split("-")) {
      int sum = 0;
      for (String num : min.split("\\+")) {
        sum += Integer.parseInt(num);
      }
      if (answer == Integer.MIN_VALUE) {
        answer = sum;
      } else {
        answer -= sum;
      }
    }
    System.out.println(answer);
  }
}
