#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

struct price
{
	int cola;
	int saida;
	int coffee;
	int orange;
	int lemon;
	int grape;
	int apple;
	int water;
};

struct stock
{
	int cola;
	int saida;
	int coffee;
	int orange;
	int lemon;
	int grape;
	int apple;
	int water;
};

struct menu
{
	struct price price;
	struct stock stock;
};

void showmenu();
int mainmenu();

int main(void)
{
	puts("19121021 IT���к� ������\n");
	while (1)
	{
		showmenu();
		mainmenu();
	}

	return 0;
}

void showmenu()
{
	printf("����������������������������������������������������������������������������\n");
	printf("��               ���Ǳ�               ��\n");
	printf("����������������������������������������������������������������������������\n");
	printf("����������������������������������������������������������������������������\n");
	printf("��         �޴� Ű<key> �ȳ�          ��\n");
	printf("��                                    ��\n");
	printf("��  �� 1 : ��ī�ݶ�          [700��]  ��\n");
	printf("��  �� 2 : ���̴�            [700��]  ��\n");
	printf("��  �� 3 : Ŀ��              [800��]  ��\n");
	printf("��  �� 4 : ������ �꽺       [800��]  ��\n");
	printf("��  �� 5 : ���� �꽺         [800��]  ��\n");
	printf("��  �� 6 : ���� �꽺         [800��]  ��\n");
	printf("��  �� 7 : ��� �꽺         [800��]  ��\n");
	printf("��  �� 8 : ��                [800��]  ��\n");
	printf("��                                    ��\n");
	printf("��  �� 9 : ���Ǳ� �� ����             ��\n");
	printf("��  �� 10 : ���� ���Ե� �� �ݾ� ����  ��\n");
	printf("��  �� 11 : ���� ��ȯ                 ��\n");
	printf("��  �� 12 : ���Ǳ� �Ǹ� ���� ����     ��\n");
	printf("��  �� 13 : ���Ǳ� ���� Ȯ��          ��\n");
	printf("��  �� 0 : ���Ǳ� �ʱ�ȭ              ��\n");
	printf("��                                    ��\n");
	printf("����������������������������������������������������������������������������\n");
}

int mainmenu()
{
	struct menu menu = { {700, 700, 800, 800, 800, 800, 800, 500},
	{10, 10, 10, 10, 10, 10, 10, 10} };
	int money = 0;
	int tmp = 0;
	int total = 0;
	int key = 0;
	while (1)
	{
		printf(" *Key �� �Է��ϼ��� : ");
		scanf(" %d", &key);
		printf("\n");

		switch (key) {
		case 1:
			if (menu.stock.cola > 0)
			{
				if (money >= menu.price.cola)
				{
					printf(" ��ī�ݶ� ��ȯ�մϴ�.\n");
					menu.stock.cola--;
					money = money - menu.price.cola;
					total += menu.price.cola;
					printf(" ��ī�ݶ� ���� ����: %d��\n\n", menu.stock.cola);
					continue;
				}
				else
				{
					printf(" Error! ���� �����մϴ�.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! ��� �����մϴ�.\n\n");
				continue;
			}
		case 2:
			if (menu.stock.saida > 0)
			{
				if (money >= menu.price.saida)
				{
					printf(" ���̴ٸ� ��ȯ�մϴ�.\n");
					menu.stock.saida--;
					money = money - menu.price.saida;
					total += menu.price.saida;
					printf(" ���̴� ���� ����: %d��\n\n", menu.stock.saida);
					continue;
				}
				else
				{
					printf(" Error! ���� �����մϴ�.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! ��� �����մϴ�.\n\n");
				continue;
			}
		case 3:
			if (menu.stock.coffee > 0)
			{
				if (money >= menu.price.coffee)
				{
					printf(" Ŀ�Ǹ� ��ȯ�մϴ�.\n");
					menu.stock.coffee--;
					money = money - menu.price.coffee;
					total += menu.price.coffee;
					printf(" Ŀ�� ���� ����: %d��\n\n", menu.stock.coffee);
					continue;
				}
				else
				{
					printf(" Error! ���� �����մϴ�.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! ��� �����մϴ�.\n\n");
				continue;
			}
		case 4:
			if (menu.stock.orange > 0)
			{
				if (money >= menu.price.orange)
				{
					printf(" ������ �꽺�� ��ȯ�մϴ�.\n");
					menu.stock.orange--;
					money = money - menu.price.orange;
					total += menu.price.orange;
					printf(" ������ �꽺 ���� ����: %d��\n\n", menu.stock.orange);
					continue;
				}
				else
				{
					printf(" Error! ���� �����մϴ�.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! ��� �����մϴ�.\n\n");
				continue;
			}
		case 5:
			if (menu.stock.lemon > 0)
			{
				if (money >= menu.price.lemon)
				{
					printf(" ���� �꽺�� ��ȯ�մϴ�.\n");
					menu.stock.lemon--;
					money = money - menu.price.lemon;
					total += menu.price.lemon;
					printf(" ���� �꽺 ���� ����: %d��\n\n", menu.stock.lemon);
					continue;
				}
				else
				{
					printf(" Error! ���� �����մϴ�.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! ��� �����մϴ�.\n\n");
				continue;
			}
		case 6:
			if (menu.stock.grape > 0)
			{
				if (money >= menu.price.grape)
				{
					printf(" ���� �꽺�� ��ȯ�մϴ�.\n\n");
					menu.stock.grape--;
					money = money - menu.price.grape;
					total += menu.price.grape;
					printf(" ���� �꽺 ���� ����: %d��\n\n", menu.stock.grape);
					continue;
				}
				else
				{
					printf(" Error! ���� �����մϴ�.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! ��� �����մϴ�.\n\n");
				continue;
			}
		case 7:
			if (menu.stock.apple > 0)
			{
				if (money >= menu.price.apple)
				{
					printf(" ��� �꽺�� ��ȯ�մϴ�.\n\n");
					menu.stock.apple--;
					money = money - menu.price.apple;
					total += menu.price.apple;
					printf(" ��� �꽺 ���� ����: %d��\n\n", menu.stock.apple);
					continue;
				}
				else
				{
					printf(" Error! ���� �����մϴ�.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! ��� �����մϴ�.\n\n");
				continue;
			}
		case 8:
			if (menu.stock.water > 0)
			{
				if (money >= menu.price.water)
				{
					printf(" ���� ��ȯ�մϴ�.\n");
					menu.stock.water--;
					money = money - menu.price.water;
					total += menu.price.water;
					printf(" �� ���� ����: %d��\n\n", menu.stock.water);
					continue;
				}
				else
				{
					printf(" Error! ���� �����մϴ�.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! ��� �����մϴ�.\n\n");
				continue;
			}
		case 9:
			printf(" �� 100 : 100�� ����\n");
			printf(" �� 500 : 500�� ����\n");
			printf(" �� 1000 : 1000�� ����\n");
			printf(" �󸶸� �����Ͻðڽ��ϱ�? : ");
			scanf("%d", &tmp);
			if (tmp == 100 || tmp == 500 || tmp == 1000)
				money += tmp;
			else
				printf(" Error! 100��, 500��, 1000���� ���� �����մϴ�.\n");
			printf("\n");			
			continue;
		case 10:
			printf(" ���� ���Ե� �� �ݾ��� %d���Դϴ�.\n\n", money);
			continue;
		case 11:
			printf(" �Ž����� %d���� ��ȯ�մϴ�.\n\n", money);
			money -= money;
			continue;
		case 12:
			printf("���� ���Ǳ��� �� ������ %d���Դϴ�.\n\n", total);
			continue;
		case 13:
			printf(" ��ī�ݶ� ���� ���� : %d��\n", menu.stock.cola);
			printf(" ���̴� ���� ���� : %d��\n", menu.stock.saida);
			printf(" Ŀ�� ���� ���� : %d��\n", menu.stock.coffee);
			printf(" ������ �꽺 ���� ���� : %d��\n", menu.stock.orange);
			printf(" ���� �꽺 ���� ���� : %d��\n", menu.stock.lemon);
			printf(" ���� �꽺 ���� ���� : %d��\n", menu.stock.grape);
			printf(" ��� �꽺 ���� ���� : %d��\n", menu.stock.apple);
			printf(" �� ���� ���� : %d��\n\n", menu.stock.water);
			continue;
		case 0:
			printf("���Ǳ⸦ �ʱ�ȭ�մϴ�.\n\n");
			return 0;
		default:
			printf("Error! �ٽ� �Է��� �ּ���.\n\n");
			continue;
		}
	}
}