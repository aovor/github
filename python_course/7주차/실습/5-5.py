print("사이버보안전공 19121021 오혜승")

y = int(input())
x = int(input())

if y > 0:
    a = x * 4 * y
    a += 1
else:
    a = x * 2 * y + 7
    a -= 1

print(y)
print(a)

print("--- 재작성하기 전의 파이썬 코드 ---")

y = int(input())

if y > 0:
    x = int(input())
    a = x * 4 * y
    print(y)
    a+=1
else:
    x = int(input())
    a = x * 2 * y + 7
    print(y)
    a -= 1

print(a)
