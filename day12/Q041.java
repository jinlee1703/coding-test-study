package day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q041 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    long answer = n;
    for (long p = 2; p <= Math.sqrt(n); p++) {
      if (n % p == 0) {
        answer = answer - answer / p;
        while (n % p == 0) {
          n /= p;
        }
      }
    }
    if (n > 1) {
      answer = answer - answer / n;
    }
    System.out.println(answer);
  }
}
