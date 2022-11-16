print("사이버보안전공 19121021 오혜승")

a = int(input())

while a != -1:
    while True:
        b = int(input())
        if b > a: break
    i = a
    while i <= b:
        print(i)
        i = i + 1
    a = int(input())
