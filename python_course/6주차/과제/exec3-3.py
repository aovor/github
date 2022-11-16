print("사이버보안전공 19121021 오혜승")

x = int(input("서울의 온도를 입력하세요: "))
y = int(input("부산의 온도를 입력하세요: "))
w = int(input("대구의 온도를 입력하세요: "))

avg = (x+y+w)/3

if avg >= 35:
    print("세 지역의 평균 온도:", avg)
    print("폭염 경보")

else:
    print("세 지역의 평균 온도:", avg)
