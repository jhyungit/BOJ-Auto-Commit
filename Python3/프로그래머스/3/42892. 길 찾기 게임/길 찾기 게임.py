# 출처: https://deveun.tistory.com/entry/Python%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-42892%EA%B8%B8-%EC%B0%BE%EA%B8%B0-%EA%B2%8C%EC%9E%84

import sys
sys.setrecursionlimit(10**5) # 런타임 에러 방지

def getSubTree(nodes):
    parent = nodes[0]
    leftNodes = list(filter(lambda x: x[1] < parent[1], nodes))
    rightNodes = list(filter(lambda x: x[1] > parent[1],nodes))
    
    left = getSubTree(leftNodes) if leftNodes else False
    right = getSubTree(rightNodes) if rightNodes else False
    return (left,right, parent[0])

def preOrder(tree,pre):
    pre.append(tree[2]) # 부모 노드
    
    preOrder(tree[0], pre) if tree[0] else None # 왼쪽 자식 노드
    preOrder(tree[1], pre) if tree[1] else None # 오른쪽 자식 노드
    
    return pre
    
def postOrder(tree,post):
    postOrder(tree[0], post) if tree[0] else None
    postOrder(tree[1], post) if tree[1] else None
    
    post.append(tree[2])
    
    return post

def midOrder(tree,mid):
    midOrder(tree[0],mid) if tree[0] else None
    mid.append(tree[2])
    midOrder(tree[1],mid) if tree[1] else None
    
    return mid
    
def solution(nodeinfo):
    nodes = [(i+1,pos[0], pos[1]) for i,pos in enumerate(nodeinfo)]
    # y값 내림차순, x값 오름차순 정렬
    nodes.sort(key = lambda x : (-x[2],x[1]))
    
    tree = getSubTree(nodes)

    # 전위, 후위
    pre, post = [], []
    # mid = [] # 중위
    
    pre = preOrder(tree, pre)
    post = postOrder(tree, post)
    # mid = midOrder(tree, mid)
    
    return [pre,post]