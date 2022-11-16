print("사이버보안전공 19121021 오혜승")

N = 10
a = [[None] * N for i in range(N)]

for i in range(N):
    for j in range(N):
        a[i][j] = float(input())

#total 계산
total = 0
for i in range(N):
    for j in range(N):
        if i == j:
            total = total + a[i][j]

print("총합:", total)

print("--------------------------------")

N = 10
a = [[None] * N for i in range(N)]

for i in range(N):
    for j in range(N):
        a[i][j] = float(input())

#float 계산

total = 0
for k in range(N):
    total = total + a[k][k]

print("총합:", total)
