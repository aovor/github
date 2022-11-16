print("사이버보안전공 19121021 오혜승")

i = 1
even = 0
odd = 0

while i <= 10:
    a = int(input())
    if a % 2 == 0:
        even += a
        i += 1
    else:
        odd += a
        i += 1

print("홀수의 총합:", odd)
print("짝수의 총합:", even)
