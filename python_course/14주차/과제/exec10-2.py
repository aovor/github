print("사이버보안전공 19121021 오혜승")

MONTH = 12
PEOPLE = 30

weight = [[None] * PEOPLE for i in range(MONTH)]
height = [[None] * PEOPLE for i in range(MONTH)]

for i in range(MONTH):
    for j in range(PEOPLE):
        weight[i][j] = int(input(str(j+1) + "번째 사람의 " + str(i+1) + "월의 몸무게를 입력하세요(kg):"))
        height[i][j] = float(input(str(j+1) + "번째 사람의 " + str(i+1) +"월의 키를 입력하세요(m):"))

bmi = [[None] * PEOPLE for i in range(MONTH)]
for i in range(MONTH):
    for j in range(PEOPLE):
        bmi[i][j] = weight[i][j] / (height[i][j] ** 2)

#각 사람의 월별 평균 몸무게, 평균 키, 평균 BMI
avg1 = [None] * PEOPLE
for i in range(PEOPLE):
    avg1[i] = 0
    for j in range(MONTH):
        avg1[i] = avg1[i] + weight[j][i]

for i in range(PEOPLE):
    avg1[i] = avg1[i] / MONTH
    print(str(i+1), "번째 사람의 평균 몸무게:", round(avg1[i], 2))

avg2 = [None] * PEOPLE
for i in range(PEOPLE):
    avg2[i] = 0
    for j in range(MONTH):
        avg2[i] = avg2[i] + height[j][i]

for i in range(PEOPLE):
    avg2[i] = avg2[i] / MONTH
    print(str(i+1), "번째 사람의 평균 키:", round(avg2[i], 2))

avg3 = [None] * PEOPLE
for i in range(PEOPLE):
    avg3[i] = 0
    for j in range(MONTH):
        avg3[i] = avg3[i] + bmi[j][i]

for i in range(PEOPLE):
    avg3[i] = avg3[i] / MONTH
    print(str(i+1), "번째 사람의 평균 BMI:", round(avg3[i], 2))

#각 사람의 5월, 8월의 BMI
for i in range(PEOPLE):
    for j in range(MONTH):
        if j == 4 or j == 7:
            print(str(i+1), "번째 사람의", str(j+1), "월의 BMI:", round(bmi[j][i], 2))
