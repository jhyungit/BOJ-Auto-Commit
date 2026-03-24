def findParent(parent, x):
    if parent[x] != x:
        parent[x] = findParent(parent, parent[x])
    return parent[x]

def unionParent(parent, a, b):
    a = findParent(parent,a)
    b = findParent(parent,b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

N = int(input())

arr = []
for _ in range(N):
    arr.append(list(map(int, input().split())))

graph = []

for u, ar in enumerate(arr):
    for v, w in enumerate(ar):
        if u == v:
            continue
        graph.append((u+1,v+1,w))

graph.sort(key= lambda x : x[2])
parent = [i for i in range (N+1)]
ans = 0
for u,v,w in graph:
    if findParent(parent, u) != findParent(parent, v):
        unionParent(parent, u, v)
        ans += w
print(ans)