x = float(input())

y = -5
if x * y > 20:
    y -= 1
    x -= 4

if x > 0:
    y += 30
    x = x ** 2

print(x, ",", y)
