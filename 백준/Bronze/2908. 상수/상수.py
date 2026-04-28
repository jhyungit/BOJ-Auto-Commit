n1, n2 = input().split()
new_n1 = int(n1[::-1])
new_n2 = int(n2[::-1])

if new_n1 > new_n2:
    print(new_n1)
else:
    print(new_n2)