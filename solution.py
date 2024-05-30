ans = -1e9, 1e9
    right = max(row[0] for row in lists)

    while pq:
        left, i, j = heapq.heappop(pq)
        if right - left < ans[1] - ans[0]:
            ans = left, right