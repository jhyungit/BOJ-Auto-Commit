import math

h, m = input().split()
time = 60 * int(h) + int(m)
alarm = 45
set = time - alarm
if set < 0:
    new_h = 23
else:
    new_h = math.trunc(set/60)
new_m = set % 60
print(new_h, new_m)