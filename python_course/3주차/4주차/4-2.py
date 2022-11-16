print("사이버보안전공 19121021 오혜승")

print("소계와 팁 비율을 입력하세요.")
print("비율은 1에서 100 사이의 값만 입력해 주세요.")
sub = int(input())
ratio = int(input())

tip = sub * (ratio/100)

print("팁은 ", tip, "원이고, 총계는 ", sub+tip, "원입니다.")
