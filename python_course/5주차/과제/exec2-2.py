print("사이버보안전공 19121021 오혜승")

import math

x = int(input("x의 값을 입력하세요: "))
w = int(input("w의 값을 입력하세요: "))

y = (x ** x / ((math.sin(2*w/3 + 5) - x) ** 2)) + ((math.sin(3*x) + w) ** (x+1)) / ((math.sqrt(7*w)) ** 3/2)
print("y의 값은", y, "입니다.")
