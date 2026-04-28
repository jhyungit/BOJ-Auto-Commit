n,m = map(int, input().split())

track = []
for i in range(n):
    track.append(list(map(int,input().split())))

# 첫 줄
for i in range(1,m):
    track[0][i] += track[0][i-1]


for i in range(1,n):
    l_r = track[i][:]
    r_l = track[i][:]
    # 왼쪽->오른쪽
    for j in range(m):
        if j == 0:
            l_r[j] += track[i-1][0]
        else:
            l_r[j] += max(track[i-1][j], l_r[j-1])
    # 오른쪽->왼쪽    
    for j in range(m-1,-1, -1):
        if j == m-1:
            r_l[j] += track[i-1][-1]
        else:
            r_l[j] += max(track[i-1][j], r_l[j+1])
    
    # 위 두 가지 비교해 업데이트
    for j in range(m):
        track[i][j] = max(l_r[j], r_l[j])

print(track[n-1][m-1])