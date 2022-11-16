print("사이버보안전공 19121021 오혜승")

number = int(input("경과 시간(초)를 입력하여라: "))
week, r = divmod(number, 604800) #60 * 60 * 24 * 7 = 604800
day, r = divmod(r, 86400) #60 * 60 * 24 = 86400
hours, r = divmod(r, 3600) # 60 * 60 = 3600
min, sec = divmod(r, 60)

print(week, "주", day, "일", hours, "시간", min, "분", sec, "초")
