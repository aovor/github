print("사이버보안전공 19121021 오혜승")

number = int(input("네 자리 정수를 입력하여라: "))


digit4 = number % 10 
r = number // 10 

digit3 = r % 10 
r = r // 10 

digit2 = r % 10 
digit1 = r // 10 

reversed_number = digit4 * 1000 + digit3 * 100 + digit2 * 10 + digit1
print(reversed_number)
