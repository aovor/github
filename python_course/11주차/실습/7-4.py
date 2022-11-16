print("사이버보안전공 19121021 오혜승")

even = 0
odd = 0
e = 0
o = 0

for i in range(10):
    num = int(input())
    if num % 2 == 0:
        even += num
        e += 1
    if num % 2 == 1:
        odd += num
        o += 1
        
print("홀수 정수의 평균값: ", odd / o)
print("짝수 정수의 평균값: ", even / e)
