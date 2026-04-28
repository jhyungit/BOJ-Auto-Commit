arr = []
for i in range(9):
    x = input()
    arr.append(int(x))
print(max(arr))
place = max(arr)
print(arr.index(place)+1)