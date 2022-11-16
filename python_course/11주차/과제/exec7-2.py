print("사이버보안전공 19121021 오혜승")

num = int(input("3과 20 사이의 정수 하나를 입력하세요: "))

for i in range(0, num, 1):
    print("*", end = " ")
    
print("")

for i in range(0, num - 2, 1):
    print("*", end = "")
    for j in range(0, num - 1 + num - 2, 1):
        print(" ", end = "")
    print("*")


for i in range(0, num, 1):
    print("*", end = " ")
