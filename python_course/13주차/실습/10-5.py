print("사이버보안전공 19121021 오혜승")

a = [None] * 10

for i in range(0, 10, 1):
    while True:
        a[i] = int(input())
        if 10 <= a[i] <= 99: break
        print("두 자릿수 정수를 입력하세요")

total = 0
for i in range(0, 10, 1):
    total = total + a[i]

print(total)
