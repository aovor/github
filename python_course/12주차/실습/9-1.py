print("사이버보안전공 19121021 오혜승")

import math

s = 10

for i in range(1, 11):
    s += math.sqrt(i)
    
print(s)

print("--- for >>> while ---")
s = 10
i = 1

while i < 11:
    s += math.sqrt(i)
    i += 1

print(s)
