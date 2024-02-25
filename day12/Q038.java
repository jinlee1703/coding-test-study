package day12;

import java.util.Scanner;

public class Q038 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    long m = sc.nextLong();
    long[] prime = new long[10000001];
    for (int i =  2; i < prime.length; i++) {
      prime[i] = i;
    }
    for (int i = 2; i <= Math.sqrt(prime.length); i++) {
      if (prime[i] == 0) {
        continue;
      }
      for (int j = i + i; j < prime.length; j += i) {
        prime[j] = 0;
      }
    }
    int answer = 0;
    for (int i = 2; i < 10000001; i++) {
      if (prime[i] != 0) {
        long temp = prime[i];
        while ((double)prime[i] <= (double)m/(double)temp) {
          if ((double)prime[i] >= (double)n/(double)temp) {
            answer++;
          }
          temp *= prime[i];
        }
      }
    }
    System.out.println(answer);
    sc.close();
  }
}
