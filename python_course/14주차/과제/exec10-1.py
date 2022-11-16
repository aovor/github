print("사이버보안전공 19121021 오혜승")

A = 14
B = 20

a = [[None] * A for i in range(B)]

for i in range(B):
    for j in range(A):
        a[i][j] = input()

for i in range(B):
    for j in range(A):
        if len(a[i][j]) <= 5:
            print(a[i][j])
        
