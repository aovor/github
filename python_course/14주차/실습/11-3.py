print("사이버보안전공 19121021 오혜승")

a = [[None] * 3 for i in range(3)]

for i in range(3):
    for j in range(3):
        a[i][j] = int(input())

for i in range(3):
    for j in range(3):    
        if a[i][j] % 2 == 1:
            print(a[i][j])
