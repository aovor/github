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
	puts("19121021 IT공학부 오혜승\n");
	while (1)
	{
		showmenu();
		mainmenu();
	}

	return 0;
}

void showmenu()
{
	printf("┌────────────────────────────────────┐\n");
	printf("│               자판기               │\n");
	printf("└────────────────────────────────────┘\n");
	printf("┌────────────────────────────────────┐\n");
	printf("│         메뉴 키<key> 안내          │\n");
	printf("│                                    │\n");
	printf("│  → 1 : 코카콜라          [700원]  │\n");
	printf("│  → 2 : 사이다            [700원]  │\n");
	printf("│  → 3 : 커피              [800원]  │\n");
	printf("│  → 4 : 오렌지 쥬스       [800원]  │\n");
	printf("│  → 5 : 레몬 쥬스         [800원]  │\n");
	printf("│  → 6 : 포도 쥬스         [800원]  │\n");
	printf("│  → 7 : 사과 쥬스         [800원]  │\n");
	printf("│  → 8 : 물                [800원]  │\n");
	printf("│                                    │\n");
	printf("│  ♩ 9 : 자판기 돈 투입             │\n");
	printf("│  ♪ 10 : 현재 투입된 총 금액 보기  │\n");
	printf("│  ♬ 11 : 동전 반환                 │\n");
	printf("│  ♭ 12 : 자판기 판매 매출 보기     │\n");
	printf("│  § 13 : 자판기 물량 확인          │\n");
	printf("│  ⅹ 0 : 자판기 초기화              │\n");
	printf("│                                    │\n");
	printf("└────────────────────────────────────┘\n");
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
		printf(" *Key 를 입력하세요 : ");
		scanf(" %d", &key);
		printf("\n");

		switch (key) {
		case 1:
			if (menu.stock.cola > 0)
			{
				if (money >= menu.price.cola)
				{
					printf(" 코카콜라를 반환합니다.\n");
					menu.stock.cola--;
					money = money - menu.price.cola;
					total += menu.price.cola;
					printf(" 코카콜라 남은 물량: %d개\n\n", menu.stock.cola);
					continue;
				}
				else
				{
					printf(" Error! 돈이 부족합니다.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! 재고가 부족합니다.\n\n");
				continue;
			}
		case 2:
			if (menu.stock.saida > 0)
			{
				if (money >= menu.price.saida)
				{
					printf(" 사이다를 반환합니다.\n");
					menu.stock.saida--;
					money = money - menu.price.saida;
					total += menu.price.saida;
					printf(" 사이다 남은 물량: %d개\n\n", menu.stock.saida);
					continue;
				}
				else
				{
					printf(" Error! 돈이 부족합니다.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! 재고가 부족합니다.\n\n");
				continue;
			}
		case 3:
			if (menu.stock.coffee > 0)
			{
				if (money >= menu.price.coffee)
				{
					printf(" 커피를 반환합니다.\n");
					menu.stock.coffee--;
					money = money - menu.price.coffee;
					total += menu.price.coffee;
					printf(" 커피 남은 물량: %d개\n\n", menu.stock.coffee);
					continue;
				}
				else
				{
					printf(" Error! 돈이 부족합니다.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! 재고가 부족합니다.\n\n");
				continue;
			}
		case 4:
			if (menu.stock.orange > 0)
			{
				if (money >= menu.price.orange)
				{
					printf(" 오렌지 쥬스를 반환합니다.\n");
					menu.stock.orange--;
					money = money - menu.price.orange;
					total += menu.price.orange;
					printf(" 오렌지 쥬스 남은 물량: %d개\n\n", menu.stock.orange);
					continue;
				}
				else
				{
					printf(" Error! 돈이 부족합니다.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! 재고가 부족합니다.\n\n");
				continue;
			}
		case 5:
			if (menu.stock.lemon > 0)
			{
				if (money >= menu.price.lemon)
				{
					printf(" 레몬 쥬스를 반환합니다.\n");
					menu.stock.lemon--;
					money = money - menu.price.lemon;
					total += menu.price.lemon;
					printf(" 레몬 쥬스 남은 물량: %d개\n\n", menu.stock.lemon);
					continue;
				}
				else
				{
					printf(" Error! 돈이 부족합니다.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! 재고가 부족합니다.\n\n");
				continue;
			}
		case 6:
			if (menu.stock.grape > 0)
			{
				if (money >= menu.price.grape)
				{
					printf(" 포도 쥬스를 반환합니다.\n\n");
					menu.stock.grape--;
					money = money - menu.price.grape;
					total += menu.price.grape;
					printf(" 포도 쥬스 남은 물량: %d개\n\n", menu.stock.grape);
					continue;
				}
				else
				{
					printf(" Error! 돈이 부족합니다.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! 재고가 부족합니다.\n\n");
				continue;
			}
		case 7:
			if (menu.stock.apple > 0)
			{
				if (money >= menu.price.apple)
				{
					printf(" 사과 쥬스를 반환합니다.\n\n");
					menu.stock.apple--;
					money = money - menu.price.apple;
					total += menu.price.apple;
					printf(" 사과 쥬스 남은 물량: %d개\n\n", menu.stock.apple);
					continue;
				}
				else
				{
					printf(" Error! 돈이 부족합니다.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! 재고가 부족합니다.\n\n");
				continue;
			}
		case 8:
			if (menu.stock.water > 0)
			{
				if (money >= menu.price.water)
				{
					printf(" 물을 반환합니다.\n");
					menu.stock.water--;
					money = money - menu.price.water;
					total += menu.price.water;
					printf(" 물 남은 물량: %d개\n\n", menu.stock.water);
					continue;
				}
				else
				{
					printf(" Error! 돈이 부족합니다.\n\n");
					continue;
				}
			}
			else
			{
				printf(" Error! 재고가 부족합니다.\n\n");
				continue;
			}
		case 9:
			printf(" ☞ 100 : 100원 투입\n");
			printf(" ☞ 500 : 500원 투입\n");
			printf(" ☞ 1000 : 1000원 투입\n");
			printf(" 얼마를 투입하시겠습니까? : ");
			scanf("%d", &tmp);
			if (tmp == 100 || tmp == 500 || tmp == 1000)
				money += tmp;
			else
				printf(" Error! 100원, 500원, 1000원만 투입 가능합니다.\n");
			printf("\n");			
			continue;
		case 10:
			printf(" 현재 투입된 총 금액은 %d원입니다.\n\n", money);
			continue;
		case 11:
			printf(" 거스름돈 %d원을 반환합니다.\n\n", money);
			money -= money;
			continue;
		case 12:
			printf("현재 자판기의 총 매출은 %d원입니다.\n\n", total);
			continue;
		case 13:
			printf(" 코카콜라 남은 물량 : %d개\n", menu.stock.cola);
			printf(" 사이다 남은 물량 : %d개\n", menu.stock.saida);
			printf(" 커피 남은 물량 : %d개\n", menu.stock.coffee);
			printf(" 오렌지 쥬스 남은 물량 : %d개\n", menu.stock.orange);
			printf(" 레몬 쥬스 남은 물량 : %d개\n", menu.stock.lemon);
			printf(" 포도 쥬스 남은 물량 : %d개\n", menu.stock.grape);
			printf(" 사과 쥬스 남은 물량 : %d개\n", menu.stock.apple);
			printf(" 물 남은 물량 : %d개\n\n", menu.stock.water);
			continue;
		case 0:
			printf("자판기를 초기화합니다.\n\n");
			return 0;
		default:
			printf("Error! 다시 입력해 주세요.\n\n");
			continue;
		}
	}
}