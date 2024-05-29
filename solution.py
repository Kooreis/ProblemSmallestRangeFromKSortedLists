import heapq

def smallest_range(lists):
    pq = [(row[0], i, 0) for i, row in enumerate(lists)]
    heapq.heapify(pq)