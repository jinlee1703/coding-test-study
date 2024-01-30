package day02;

import java.util.Scanner;

public class Q003 {
  /**
   * 슈도 코드
   * 1. N(수의 개수)와 M(합을 구해야하는 횟수) 입력받기
   * 2. int[] num(원소 배열) 정의, int[] sum(합 배열) 정의
   * 3. N개의 수를 num[]에 저장
   * 4.   M 만큼 반복
   * 4.1. I, J 입력 받기
   * 4.2. I부터 J까지의 합 출력하기 => S[j] - S[i-1]
   */

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] num = new int[n];
    int[] sum = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = sc.nextInt();
      sum[i] = (i == 0 ? 0 : sum[i - 1]) + num[i];
    }
    for (int t = 0; t < m; t++) {
      int i = sc.nextInt() - 1;
      int j = sc.nextInt() - 1;
      System.out.println(sum[j] - (i == 0 ? 0 : sum[i - 1]));
    }
  }
}
