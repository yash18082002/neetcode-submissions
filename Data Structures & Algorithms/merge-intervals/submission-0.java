class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int[] curr = intervals[0];
        result.add(curr);

        for (int[] next : intervals) {
            if (next[0] <= curr[1]) {
                curr[1] = Math.max(next[1], curr[1]);
            } else {
                curr = next;
                result.add(curr);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
