"""
Sprint Training
Imagine there are n points along a straight trail, while a runner run sprints of intervals between those point.
The training plan is an array a[], which implies the runner should run from point a[i] to point a[i+1].

For example, given n = 5, a = [2, 4, 1, 2].
The runner should run from point 2 to point 4,
then turn back from point 4 to point 1,
and then from point 1 to point 2.
Find the point that visited the most by runner after he finished training, i.e. in above example, point 2 is the most visited.
If more than one point are visited the most, find the point with minimum index.
"""
def getMostVisited1(n, sprints):
    points = [0]*n
    for i in range(len(sprints)-1):
        start,end = sprints[i],sprints[i+1]
        if start>end:start,end = end,start
        for i in range(start-1,end): points[i]+=1
    return next(i+1 for i in range(n) if points[i] == max(points))

def getMostVisited2(markerCount,sprints):
    incremental = [0]*(markerCount + 2)
    for i in range(len(sprints)-1):
        start = min(sprints[i], sprints[i + 1])
        end = max(sprints[i], sprints[i + 1])
        incremental[start]+=1
        incremental[end + 1]-=1
        print(incremental)
    
    scores = [0]*(markerCount + 1)
    score = 0
    for i in range(1,markerCount+1):
        score += incremental[i]
        scores[i] = score
        print(scores)

    result,out = 0, 0
    for i in range(1,markerCount + 1):
        if (scores[i] > out): result,out = i, scores[i]
    return result

if __name__=='__main__':
    print(getMostVisited1(5,[2,4,1,3]))
    print(getMostVisited2(5,[2,4,1,3]))
