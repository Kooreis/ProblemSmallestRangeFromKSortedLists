Here is a Java console application that solves the problem:

```java
import java.util.*;

class Node {
    int elementIndex;
    int arrayIndex;

    Node(int elementIndex, int arrayIndex) {
        this.elementIndex = elementIndex;
        this.arrayIndex = arrayIndex;
    }
}

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(4, 7, 9, 12, 15));
        lists.add(Arrays.asList(0, 8, 10, 14, 20));
        lists.add(Arrays.asList(6, 12, 16, 30, 50));

        int[] result = findSmallestRange(lists);
        System.out.println("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }

    public static int[] findSmallestRange(List<List<Integer>> lists) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> lists.get(n.arrayIndex).get(n.elementIndex)));

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() > 0) {
                queue.add(new Node(0, i));
                max = Math.max(max, lists.get(i).get(0));
            }
        }

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;
        while (queue.size() == lists.size()) {
            Node node = queue.poll();
            int currentStart = lists.get(node.arrayIndex).get(node.elementIndex);
            if (max - currentStart < rangeEnd - rangeStart) {
                rangeStart = currentStart;
                rangeEnd = max;
            }

            node.elementIndex++;
            if (lists.get(node.arrayIndex).size() > node.elementIndex) {
                queue.add(node);
                max = Math.max(max, lists.get(node.arrayIndex).get(node.elementIndex));
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }
}
```

This program finds the smallest range that includes at least one number from each of the k sorted lists. It uses a priority queue to keep track of the smallest element not yet processed in each of the k lists. The range is updated whenever a smaller range is found. The process continues until the priority queue does not contain elements from all the lists, which means we have processed all elements in one of the lists.