from collections import deque

def hiding(n, k):
    visited = set([n])
    q = deque([(n, 0)])
    
    if n >= k:
        print(n-k)
        return
    
    while q:
        loc, move = q.popleft()
        if loc == k:
            print(move)
            return
        
        if loc*2 <= 2*k:
            if loc*2 not in visited:
                q.append((loc*2, move+1))
                visited.add(loc*2)
                
        if loc+1 <= k:
            if loc+1 not in visited:
                q.append((loc+1, move+1))
                visited.add(loc+1)
                
        if 0 <= loc-1 <= k:
            if loc-1 not in visited:
                q.append((loc-1, move+1))
                visited.add(loc-1)

n, k = map(int, input().split())
hiding(n, k)