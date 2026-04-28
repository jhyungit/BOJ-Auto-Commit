x = int(input())
y = input().split()

arr = []

for i in range(x):
    arr.append(int(y[i]))
print(min(arr), max(arr))
