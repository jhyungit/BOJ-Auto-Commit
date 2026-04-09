import sys
from collections import deque
input = sys.stdin.readline


n = int(input())
adj = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    u,v = map(int, input().split())
    adj[u].append(v)
    adj[v].append(u)

# BFS로 부모-자식 관계 및 순서 확정
root = 1
parent = [0] * (n + 1)
order = []
visited = [False] * (n + 1)
queue = deque([root])
visited[root] = True

while queue:
    node = queue.popleft()
    order.append(node)
    for neighbor in adj[node]:
        if not visited[neighbor]:
            visited[neighbor] = True
            parent[neighbor] = node
            queue.append(neighbor)

# 리프부터 역순으로 DP
dp = [[0, 1] for _ in range(n + 1)]  # dp[node][0]: node 미선택, dp[node][1]: node 선택
for node in reversed(order):
    for neighbor in adj[node]:
        if neighbor == parent[node]:  # 부모 노드
            continue
        dp[node][0] += dp[neighbor][1]   # node 미선택 → 자식은 반드시 선택
        dp[node][1] += min(dp[neighbor][0], dp[neighbor][1])  # node 선택 → 자식은 자유

print(min(dp[root][0], dp[root][1]))  # 루트 노드 선택 여부에 따른 최소 얼리어답터 수