import sys
input = sys.stdin.readline

def solution():
    # left | right 커서 위치 기준 나눔(stack 관리)
    left = []
    right = []
    keyboard = input().strip()

    for k in keyboard:
        if k == '>':
            if right:
                left.append(right.pop())
        elif k == '<':
            if left:
                right.append(left.pop())
        elif k == '-':
            if left:
                left.pop()
        else:
            left.append(k)

    return "".join(left) + "".join(reversed(right))

n = int(input())
for _ in range(n):
    print(solution())