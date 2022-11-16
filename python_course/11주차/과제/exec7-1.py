print("사이버보안전공 19121021 오혜승")

start = int(input("start 값을 입력하세요: "))
finish = int(input("finish 값을 입력하세요: "))

if start > finish:
    temp = start
    start = finish
    finish = temp

for i in range(start, finish + 1, 1):
    print(i)
