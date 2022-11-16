print("사이버보안전공 19121021 오혜승")

a = [None] * 20

for i in range(0, 20, 1):
    a[i] = input()

for i in range(0, 20, 1):
    k = len(a[i])
    if k >= 10:
        print(a[i])
