a = int(input())
b = int(input())
c = int(input())

mul = a * b * c
mul_list = list(map(int, str(mul)))
for i in range(10):
    print(mul_list.count(i))