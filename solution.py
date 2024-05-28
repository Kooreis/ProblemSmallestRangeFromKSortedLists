Here is a Python solution using a priority queue:

```python
import heapq

def smallest_range(lists):
    pq = [(row[0], i, 0) for i, row in enumerate(lists)]
    heapq.heapify(pq)

    ans = -1e9, 1e9
    right = max(row[0] for row in lists)

    while pq:
        left, i, j = heapq.heappop(pq)
        if right - left < ans[1] - ans[0]:
            ans = left, right
        if j + 1 == len(lists[i]):
            return ans
        v = lists[i][j+1]
        right = max(right, v)
        heapq.heappush(pq, (v, i, j+1))

    return ans

def main():
    lists = [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
    print(smallest_range(lists))

if __name__ == "__main__":
    main()
```

This script will print the smallest range that includes at least one number from each of the sorted lists. The `smallest_range` function uses a priority queue to keep track of the smallest element not yet used in each of the k lists, and updates the range as it pops elements from the queue. The `main` function is the entry point of the script, which calls the `smallest_range` function with the input lists and prints the result.