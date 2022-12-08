
/*
   1. 0~9 숫자 3개 랜덤 생성.
   2. 사용자의 3개의 숫자 입력.
   3. 같은 위치에 있으면 Strike, 다른위치에 같은 숫자 존재 Ball.
   4. 같은 숫자가 나오지 않으면 Out.
   5. 3 Strike 나올 시, 축하합니다 게임 종료.
*/

package BaseballGame;
//import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
	public static void main(String[] args) {

		int[] com = new int[3];
		for (int i = 0; i < com.length; i++) {
			com[i] = (int) (Math.random() * 10);
			for (int j = 0; j < i; j++) {
				if (com[i] == com[j]) {
					--i;
					continue;
				}
			}
		}
//		System.out.print(Arrays.toString(com));

		int strike = 0;
		int ball = 0;

		Scanner sc = new Scanner(System.in);

		int[] inp = new int[3];

		while (true) {
			for (int i = 0; i < inp.length; i++) {
				inp[i] = sc.nextInt();
			}

			for (int i = 0; i < inp.length; i++) {
				if (com[i] == inp[i]) {
					strike++;
				}
			}
			for (int i = 0; i < inp.length; i++) {
				for (int j = 0; j < inp.length; j++) {
					if (com[i] == inp[j] && i != j) {
						ball++;
					}
				}
			}

			if (strike == 3) {
				System.out.println("축하합니다!");
				break;
			} else if (strike == 0 && ball == 0) {
				System.out.println("OUT!");
			} else {
				System.out.printf("%d Strike, %d Ball\n", strike, ball);
			}
			
			strike = 0;
			ball = 0;
		}
		sc.close();
	}
}
