print("사이버보안전공 19121021 오혜승")

n = int(input("구매 도서의 수를 입력하세요: "))

if n < 3:
    total = n * 10000
    print("총 금액은", total,"원 입니다.")
elif 3 <= n <=5:
    total = (n * 10000) - ((n * 10000) * (10/100))
    print("총 금액은", total,"원 입니다.")
elif 6 <= n <= 9:
    total = (n * 10000) - ((n * 10000) * (15/100))
    print("총 금액은", total,"원 입니다.")
elif 10 <= n <= 13:
    total = (n * 10000) - ((n * 10000) * (20/100))
    print("총 금액은", total,"원 입니다.")
elif 14 <= n <= 19:
    total = (n * 10000) - ((n * 10000) * (27/100))
    print("총 금액은", total,"원 입니다.")
elif 20 <= n:
    total = (n * 10000) - ((n * 10000) * (30/100))
    print("총 금액은", total,"원 입니다.")
