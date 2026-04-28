x = input().split()
sum = 0

for i in range(5):
    sum += pow(int((x[i])),2)
print(sum%10)