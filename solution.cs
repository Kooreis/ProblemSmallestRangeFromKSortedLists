Here is a C# console application that solves the problem:

```C#
using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        List<List<int>> lists = new List<List<int>>
        {
            new List<int> {4, 10, 15, 24, 26},
            new List<int> {0, 9, 12, 20},
            new List<int> {5, 18, 22, 30}
        };

        var result = FindSmallestRange(lists);

        Console.WriteLine($"Smallest range is: [{result.Item1}, {result.Item2}]");
    }

    static Tuple<int, int> FindSmallestRange(List<List<int>> lists)
    {
        SortedSet<Tuple<int, int, int>> sortedSet = new SortedSet<Tuple<int, int, int>>();
        int max = int.MinValue;

        for (int i = 0; i < lists.Count; i++)
        {
            sortedSet.Add(new Tuple<int, int, int>(lists[i][0], i, 0));
            max = Math.Max(max, lists[i][0]);
        }

        int rangeStart = 0, rangeEnd = int.MaxValue;

        while (sortedSet.Count == lists.Count)
        {
            var min = sortedSet.Min;
            sortedSet.Remove(min);

            if (max - min.Item1 < rangeEnd - rangeStart)
            {
                rangeStart = min.Item1;
                rangeEnd = max;
            }

            if (min.Item3 + 1 < lists[min.Item2].Count)
            {
                sortedSet.Add(new Tuple<int, int, int>(lists[min.Item2][min.Item3 + 1], min.Item2, min.Item3 + 1));
                max = Math.Max(max, lists[min.Item2][min.Item3 + 1]);
            }
        }

        return new Tuple<int, int>(rangeStart, rangeEnd);
    }
}
```

This program finds the smallest range that includes at least one number from each of the k sorted lists. It uses a sorted set to keep track of the smallest and largest elements in the current range, and updates the range as it iterates through the lists. The smallest range is then printed to the console.