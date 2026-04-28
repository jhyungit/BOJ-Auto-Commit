arr = []
for i in range(10):
    x = int(input())
    arr.append(x % 42)
arr = set(arr)
print(len(arr))

