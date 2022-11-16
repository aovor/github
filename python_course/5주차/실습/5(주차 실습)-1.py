print("사이버보안전공 19121021 오혜승")

import math

a = float(input("가속도값을 입력하여라: "))
S = float(input("주행 거리를 입력하여라: "))

t = math.sqrt(2 * S / a)
print("주행 시간(초):", t)
