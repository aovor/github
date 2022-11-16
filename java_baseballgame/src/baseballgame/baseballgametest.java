package baseballgame;

/*
 * 스윙을 사용하지 않고 짠 숫자 야구 게임
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class baseballgametest {

	int number[] = new int[4];						//랜덤 4자리 숫자 담을 배열
	int answer, chance = 0;							//answer: 정답을 맞힐 수 있는 기회(5번), chance: 정답과 질문을 다 합친 모든 기회(20번)
	int num;										//입력한 숫자 4자리
	int inputnum;
	int input[] = new int[4];						//입력한 숫자 4자리를 한 자리씩 저장하는 배열
	boolean end = true;
	int ball, strike = 0;
	String result;									//숫자를 입력하고 나서 결과(nBnS)를 저장하는 변수
	String chancelist[] = new String[20];		//정답 혹은 질문을 하고 얻은 결과 저장하는 배열

	Scanner scanner = new Scanner(System.in);
	
	public baseballgametest() {
		//랜덤 4자리 숫자(중복x)
		number[0]=(int)(Math.random()*10);
		while(number[0] == 0) {
			number[0]=(int)(Math.random()*10);
		}
		number[1]=(int)(Math.random()*10);
		while(number[0] == number[1]) {
			number[1]=(int)(Math.random()*10);
		}
		number[2]=(int)(Math.random()*10);
		while(number[0] == number[2] || number[1] == number[2]) {
			number[2]=(int)(Math.random()*10);
		}
		number[3]=(int)(Math.random()*10);
		while(number[0] == number[3] || number[1] == number[3] || number[2] == number[3]) {
			number[3]=(int)(Math.random()*10);
		}
	}
	
	public void start() {
		while(end) {
			ball = 0;
			strike = 0;
			System.out.print("질문은 '1'을, 정답은 '2', 질문 목록은 '3'을 입력해 주세요. >> ");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.print("숫자 네 자리를 입력해 주세요 >> ");
				while(true) {
					num = scanner.nextInt();
					if(num>999 && num<10000)
						break;
					System.out.println("숫자를 다시 입력해 주세요.");
				}
				inputnum = num;
				input[0] = num / 1000;
				num = num % 1000;
				input[1] = num / 100;
				num = num % 100;
				input[2] = num / 10;
				num = num % 10;
				input[3] = num;
				
				if(input[0] == number[0])
					strike++;
				else if(input[0] == number[1] || input[0] == number[2] || input[0] == number[3])
					ball++;
				if(input[1] == number[1])
					strike++;
				else if(input[1] == number[0] || input[1] == number[2] || input[1] == number[3])
					ball++;
				if(input[2] == number[2])
					strike++;
				else if(input[2] == number[0] || input[2] == number[1] || input[2] == number[3])
					ball++;
				if(input[3] == number[3])
					strike++;
				else if(input[3] == number[0] || input[3] == number[1] || input[3] == number[2])
					ball++;

				result = inputnum+", "+ball+"B"+strike+"S";
				chancelist[chance] = result;
				System.out.println(ball+"B"+strike+"S 입니다.");
				chance++;
				
				
				
				if(chance == 20 || answer == 5) {
					System.out.println("기회를 모두 소진하셨습니다.");
					System.out.print("정답은 ");
					for(int j=0; j<4; j++) {
						System.out.print(number[j]);
					}
					System.out.println(" 입니다.");
					end = false;
				}
				break;
			case 2:
				System.out.print("숫자 네 자리를 입력해 주세요 >> ");
				while(true) {
					num = scanner.nextInt();
					if(num>999 && num<10000)
						break;
					System.out.println("숫자를 다시 입력해 주세요.");
				}
				inputnum = num;
				input[0] = num / 1000;
				num = num % 1000;
				input[1] = num / 100;
				num = num % 100;
				input[2] = num / 10;
				num = num % 10;
				input[3] = num;
				
				if(number[0] == input[0] && number[1] == input[1] && number[2] == input[2] && number[3] == input[3]) {
					System.out.println("정답입니다.");
					result = inputnum+", "+"정답";
					chancelist[chance] = result;
					end = false;
				}
				else {
					System.out.println("오답입니다.");
					result = inputnum+", "+"오답";
					chancelist[chance] = result;
					chance++;
					answer++;
				}
				
				if(chance == 20 || answer == 5) {
					System.out.println("기회를 모두 소진하셨습니다.");
					System.out.print("정답은 ");
					for(int j=0; j<4; j++) {
						System.out.print(number[j]);
					}
					System.out.println(" 입니다.");
					end = false;
				}
				break;
			case 3:
				if(chance==0) {
					System.out.println("저장된 값이 없습니다.");
				}
				else {
					for(int i=0; i<chance; i++) {
						System.out.println(chancelist[i]);
					}
				}
				break;
			default:
				System.out.println("다시 입력해 주세요.");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("야구 게임을 시작하겠습니다.");
		System.out.println("게임이 시작되면 네 자리의 숫자가 랜덤으로 정해집니다.");
		System.out.println("네 자리 중 첫 번째 자리의 수는 0이 아니며, 각 자리의 숫자들은 중복되지 않습니다.");
		System.out.println("기회는 질문과 정답을 다 합쳐 스무 번 주어지고, 정답은 다섯 번만 입력할 수 있습니다.");
		while(true) {
			baseballgametest game = new baseballgametest();
			game.start();
			System.out.print("다시 하시겠습니까? (yes/no) ");
			String again = scanner.next();
			if(again.equals("no") || again.equals("NO") || again.equals("n") || again.equals("N"))
					break;
		}
		System.out.println("게임을 종료합니다!");
	}

}
