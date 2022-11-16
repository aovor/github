print("사이버보안전공 19121021 오혜승")

age = int(input("나이를 입력하세요: "))
weight = int(input("체중(kg)을 입력하세요: "))
height = float(input("키(m)를 입력하세요: "))

BMI = weight / (height ** 2)

if age < 18:
    print("해당하지 않은 나이입니다.")
else:
    if BMI < 15:
        print("매우 마름")
    elif 15 <= BMI < 16:
        print("마름")
    elif 16 <= BMI < 18.5:
        print("저체중")
    elif 18.5 <= BMI < 25:
        print("보통")
    elif 25 <= BMI < 30:
        print("과체중")
    elif 30 <= BMI < 35:
        print("경도 비만")
    else:
        print("고도 비만")
