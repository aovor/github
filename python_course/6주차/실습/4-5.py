print("사이버보안전공 19121021 오혜승")

a = float(input())
b = float(input())

if b > a:
    maximum = b

else:
    maxinum = a

print("큰 값:",maximum)

print("--------------------------------------")

a = float(input())
b = float(input())

maximum = a
if b > a:
    maximum = b

print("큰 값:", maximum)

print("--------------------------------------")

a = float(input())
b = float(input())

maximum = max(a, b)
print("큰 값:", maximum)
