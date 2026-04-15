# 구현
import sys
input = sys.stdin.readline

from collections import deque

def solution(qwal):
    stack = deque()

    for q in qwal:
        if q == '(' or q == '[':
            stack.append(q)
        elif q == ')' or q == ']':
            total = 0
            while True:
                if not stack: # 스택 비어있으면 잘못된 괄호
                    return 0
                cur = stack.pop()
                if cur == '(' or cur == '[':
                    if q == ')' and cur == '[':
                        return 0
                    if q == ']' and cur == '(':
                        return 0
                    if total == 0:
                        stack.append(2 if q == ')' else 3)
                    else:
                        stack.append(total * (2 if q == ')' else 3))
                    break
                else:
                    total += cur
    
    for item in stack:
        if item == '(' or item == '[':
            return 0

    return sum(stack)

qwal = list(input().strip())
print(solution(qwal))