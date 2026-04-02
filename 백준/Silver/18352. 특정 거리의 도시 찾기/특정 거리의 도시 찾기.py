import sys
input = sys.stdin.readline

import heapq

INF = float("inf")

def dijkstra(start):
    heap = []
    dist[start] = 0
    heapq.heappush(heap, (0, start)) # 거리, 출발좌표

    while heap:
        w, u = heapq.heappop(heap)
        
        if dist[u] < w:
            continue

        for next in graph[u]:
            if dist[u] + w < dist[next]:
                dist[next] = dist[u] + 1
                heapq.heappush(heap, (dist[next], next))

def solution():
    global graph, dist
    
    # 도시 수, 도로 수, 거리 정보, 출발 좌표
    n,m,k,x = map(int, input().split())
    
    graph = [[] for _ in range(n+1)]

    # u -> v 단 방향 도로
    for _ in range(m):
        u, v = map(int, input().split())
        graph[u].append(v)

    # x에서 모든 좌표 최단 거리
    dist = [INF] * (n+1)

    dijkstra(x)

    ans = []
    for i in range(1, n+1):
        if dist[i] == k:
            ans.append(i)

    if ans == []:
        return print(-1)
    ans.sort()

    for i in range(len(ans)):
        print(ans[i])



solution()