print("사이버보안전공 19121021 오혜승")

x = int(input("운행한 마일 수를 입력하세요:"))
y = x - (12000 * (x // 12000)) #이전 정기 점검 서비스를 받고 난 후 주행한 마일

if x < 6000:
    print("단기 정기 점검 서비스까지", 6000 - x, "마일 남았습니다.")
if 6000 <= x < 12000:
    print("장기 정기 점검 서비스까지", 12000 - x, "마일 남았습니다.")
if x >= 12000 and 6000 - y > 0:
    print("단기 정기 점검 서비스까지", 6000 - y,"마일 남았습니다.")
if x >= 12000 and 6000 - y < 0:
    print("장기 정기 점검 서비스까지", 12000 - y,"마일 남았습니다.")
