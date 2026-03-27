import heapq
import sys
input = sys.stdin.readline


def solution():
    n = int(input())
    visited = [False] * n
    answer = 0
    
    digCost = []
    for _ in range(n):
        digCost.append(int(input()))
    minCost = digCost[:]

    adjMatrix = []
    for _ in range(n):
        adjMatrix.append(list(map(int, input().split())))
        
    for _ in range(n):
        # 아직 방문 안 한 논 중 최소 비용 선택
        u = -1
        minValue = float('inf')

        for i in range(n):
            if not visited[i] and minCost[i] < minValue:
                minValue = minCost[i]
                u = i
        
        visited[u] = True
        answer += minValue

        # 새로 선택한 논 u를 통해 더 싸게 연결 가능한지 확인
        for v in range(n):
            if not visited[v]:
                minCost[v] = min(minCost[v], adjMatrix[u][v])

    return answer

print(solution())