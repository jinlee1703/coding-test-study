package day08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q024 {
  static final int MAX_SIZE = 100000000;
  static boolean isPrime[] = new boolean[MAX_SIZE + 1];
  static StringBuilder sb = new StringBuilder();
  static int n;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    System.out.println(solution());
  }

  static String solution() {
    isPrime[0] = isPrime[1] = true;
    setPrimeNumber();

    for (int i = (int)Math.pow(10, n - 1); i < (int)Math.pow(10, n); i++) {
      dfs(i, 0);
    }
    
    return sb.toString().substring(0, sb.toString().length() - 1);
  }

  static void setPrimeNumber() {
    for (int i = 2; i * i <= MAX_SIZE; i++) {
      if (!isPrime[i]) {
        for (int j = i * i; j <= MAX_SIZE; j += i) {
          isPrime[j] = true;
        }
      }
    }
  }

  static void dfs(int v, int depth) {
    if (depth == n) {
      sb.append(v);
      sb.append("\n");
      return;
    }

    int num = Integer.parseInt(Integer.toString(v).substring(0, depth + 1));

    if (!isPrime[num]) {
      dfs(v, depth + 1);
    }
  }
}
