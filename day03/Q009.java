package day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q009 {
  static int check[];
  static int my[];
  static int secret;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int answer = 0;

    int s = Integer.parseInt(st.nextToken());
    int p = Integer.parseInt(st.nextToken());

    char[] a = new char[s];
    a = br.readLine().toCharArray();

    check = new int[4];
    my = new int[4];
    secret = 0;
    
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      check[i] = Integer.parseInt(st.nextToken());
      if (check[i] == 0) {
        ++secret;
      }
    }
    for (int i = 0; i < p; i++) {
      add(a[i]);
    }

    if (secret == 4)
      ++answer;

    for (int i= p; i < s; i++) {
      int j = i - p;
      add(a[i]);
      remove(a[j]);
      if (secret == 4)
        ++answer;
    }
    System.out.println(answer);
  }

  static void add(char c) {
    switch (c) {
      case 'A':
        ++my[0];
        if (my[0] == check[0])
          ++secret;
        break;
      case 'C':
        ++my[1];
        if (my[1] == check[1])
          ++secret;
        break;
      case 'G':
        ++my[2];
        if (my[2] == check[2])
          ++secret;
        break;
      case 'T':
        ++my[3];
        if (my[3] == check[3])
          ++secret;
        break;
    }
  }

  static void remove(char c) {
    switch (c) {
      case 'A':
        if (my[0] == check[0])
          --secret;
        --my[0];
        break;
      case 'C':
        if (my[1] == check[1])
          --secret;
        --my[1];
        break;
      case 'G':
        if (my[2] == check[2])
          --secret;
        --my[2];
        break;
      case 'T':
        if (my[3] == check[3])
          --secret;
        --my[3];
        break;
    }
  }
}
