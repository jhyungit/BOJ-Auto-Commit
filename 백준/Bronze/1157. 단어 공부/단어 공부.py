x = input().lower()
set_x = list(set(x))

arr = []

for i in set_x:
    num = x.count(i)
    arr.append(num)

if arr.count(max(arr))>=2:
    print("?")
else:
    print(set_x[arr.index(max(arr))].upper())