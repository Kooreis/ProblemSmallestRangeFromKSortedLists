public class Main {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(4, 7, 9, 12, 15));
        lists.add(Arrays.asList(0, 8, 10, 14, 20));
        lists.add(Arrays.asList(6, 12, 16, 30, 50));

        int[] result = findSmallestRange(lists);
        System.out.println("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }