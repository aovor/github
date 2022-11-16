print("사이버보안전공 19121021 오혜승")

sum1 = 0
sum2 = 0
a = [None] * 10

for i in range(0, 10, 1):
    a[i] = int(input())

for i in range(0, 10, 1):
    if a[i] > 0:
        sum1 = sum1 + a[i]
    else:
        sum2 = sum2 + a[i]


print("양수의 총합:", sum1)
print("음수의 총합:", sum2)
