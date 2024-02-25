package day12;

import java.util.Scanner;

public class Q039 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] prime = new int[100000001];
    for (int i = 0; i < prime.length; i++) {
      prime[i] = i;
    }
    for (int i = 2; i < Math.sqrt(prime.length); i++) {
      if (prime[i] == 0) {
        continue;
      }
      for (int j = i + i; j < prime.length; j += i) {
        prime[j] = 0;
      }
    }
    int i = n;
    while (true) {
      if (prime[i] != 0) {
        int result = prime[i];
        if (isPalindrome(result)) {
          System.out.println(result);
          break;
        }
      }
      i++;
    }
  }

  private static boolean isPalindrome(int num) {
    char[] numToCharArray = String.valueOf(num).toCharArray();
    int left = 0;
    int right = numToCharArray.length - 1;
    while (left < right) {
      if (numToCharArray[left] != numToCharArray[right]) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
