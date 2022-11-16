package baseballgame;

/*
 * ������ ������� �ʰ� § ���� �߱� ����
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class baseballgametest {

	int number[] = new int[4];						//���� 4�ڸ� ���� ���� �迭
	int answer, chance = 0;							//answer: ������ ���� �� �ִ� ��ȸ(5��), chance: ����� ������ �� ��ģ ��� ��ȸ(20��)
	int num;										//�Է��� ���� 4�ڸ�
	int inputnum;
	int input[] = new int[4];						//�Է��� ���� 4�ڸ��� �� �ڸ��� �����ϴ� �迭
	boolean end = true;
	int ball, strike = 0;
	String result;									//���ڸ� �Է��ϰ� ���� ���(nBnS)�� �����ϴ� ����
	String chancelist[] = new String[20];		//���� Ȥ�� ������ �ϰ� ���� ��� �����ϴ� �迭

	Scanner scanner = new Scanner(System.in);
	
	public baseballgametest() {
		//���� 4�ڸ� ����(�ߺ�x)
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
			System.out.print("������ '1'��, ������ '2', ���� ����� '3'�� �Է��� �ּ���. >> ");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.print("���� �� �ڸ��� �Է��� �ּ��� >> ");
				while(true) {
					num = scanner.nextInt();
					if(num>999 && num<10000)
						break;
					System.out.println("���ڸ� �ٽ� �Է��� �ּ���.");
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
				System.out.println(ball+"B"+strike+"S �Դϴ�.");
				chance++;
				
				
				
				if(chance == 20 || answer == 5) {
					System.out.println("��ȸ�� ��� �����ϼ̽��ϴ�.");
					System.out.print("������ ");
					for(int j=0; j<4; j++) {
						System.out.print(number[j]);
					}
					System.out.println(" �Դϴ�.");
					end = false;
				}
				break;
			case 2:
				System.out.print("���� �� �ڸ��� �Է��� �ּ��� >> ");
				while(true) {
					num = scanner.nextInt();
					if(num>999 && num<10000)
						break;
					System.out.println("���ڸ� �ٽ� �Է��� �ּ���.");
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
					System.out.println("�����Դϴ�.");
					result = inputnum+", "+"����";
					chancelist[chance] = result;
					end = false;
				}
				else {
					System.out.println("�����Դϴ�.");
					result = inputnum+", "+"����";
					chancelist[chance] = result;
					chance++;
					answer++;
				}
				
				if(chance == 20 || answer == 5) {
					System.out.println("��ȸ�� ��� �����ϼ̽��ϴ�.");
					System.out.print("������ ");
					for(int j=0; j<4; j++) {
						System.out.print(number[j]);
					}
					System.out.println(" �Դϴ�.");
					end = false;
				}
				break;
			case 3:
				if(chance==0) {
					System.out.println("����� ���� �����ϴ�.");
				}
				else {
					for(int i=0; i<chance; i++) {
						System.out.println(chancelist[i]);
					}
				}
				break;
			default:
				System.out.println("�ٽ� �Է��� �ּ���.");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�߱� ������ �����ϰڽ��ϴ�.");
		System.out.println("������ ���۵Ǹ� �� �ڸ��� ���ڰ� �������� �������ϴ�.");
		System.out.println("�� �ڸ� �� ù ��° �ڸ��� ���� 0�� �ƴϸ�, �� �ڸ��� ���ڵ��� �ߺ����� �ʽ��ϴ�.");
		System.out.println("��ȸ�� ������ ������ �� ���� ���� �� �־�����, ������ �ټ� ���� �Է��� �� �ֽ��ϴ�.");
		while(true) {
			baseballgametest game = new baseballgametest();
			game.start();
			System.out.print("�ٽ� �Ͻðڽ��ϱ�? (yes/no) ");
			String again = scanner.next();
			if(again.equals("no") || again.equals("NO") || again.equals("n") || again.equals("N"))
					break;
		}
		System.out.println("������ �����մϴ�!");
	}

}
