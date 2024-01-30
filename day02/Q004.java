package day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q004 {
  /**
   * 슈도 코드
   * 1. N(가로, 세로), M(질의 수) 입력 받기
   * 2. num[n+1][n+1], sum[n+1][n+1] 정의
   * 3. N*N 배열 입력받기
   * 4.   M만큼 반복
   * 4.1. 시작점(X1, Y1)과 끝점(X2, Y2) 입력 받기
   * 4.2. sum[X2, Y2] - sum[X1-1, Y2] - sum[X2, Y1-1] + sum[X1-1][Y1-1]
   */

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int num[][] = new int[n+1][n+1];
    int sum[][] = new int[n+1][n+1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        num[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + num[i][j];
      }
    }

    for (int t = 0; t < m; t++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int answer = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
      System.out.println(answer);
    }
  }
}
