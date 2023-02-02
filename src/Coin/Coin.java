//두개의 정수를 입력. 첫번째 정수 : 면의 개수 , 두번째 정수 : 동전의 개수 => 모든 경우의 수 결과로 출력

package Coin;

import java.util.Scanner;

public class Coin {
   static int ar[];
   static int n, m;

   public static void dice(int p) {
      if (p == m) {
         for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + 1);
         }
         System.out.println();
         return;
      }
      for (int i = 0; i < n; i++) {
         ar[p] = i;
         dice(p + 1);
      }
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      m = sc.nextInt();
      sc.close();

      ar = new int[m];

      dice(0);
   }
}