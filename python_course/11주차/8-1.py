a = 1
j = 1
while j <= 2:
    i = 10
    while i < 30:
        a = a + j + i
        i += 10
        print("i<30")
    j += 0.5
    print("j<=2")
print(a)
