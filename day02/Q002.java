package day02;

import java.util.Scanner;

public class Q002 {
  /**
   * 1. n 입력 받기
   * 2. 크기가 n인 배열 생성
   * 3. 최대값 초기화(max = 0)
   * 3. n만큼 과목(subject[]) 입력 받기 => 최대값 찾기
   * 4. solution(n, subject, max)으로 넘기기 => 후에 이를 출력하도록 함
   * 5. for 반복문으로 n-1번째 원소까지 합 구하기
   * 6. 합 / n으로 결과 반환하기
   */

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] subject = new int[n];
    for (int i = 0; i < n; i++) {
      subject[i] = sc.nextInt();
    }
    System.out.println(solution(n, subject));
  }

  static double solution(int n, int[] subject) {
    double sum = 0.0;
    double max = 0.0;

    for (int i = 0; i < n; i++) {
      sum += subject[i];
      if (max < subject[i]) {
        max = subject[i];
      }
    }
    
    return sum / max * 100 / n;
  }

  
}
