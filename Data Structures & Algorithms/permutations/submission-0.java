class Solution {
    List<List<Integer>> result;

    private void backtrack(int[] nums, boolean[] used, int n, int pos, List<Integer> arr) {
        if (n == pos) {
            result.add(new ArrayList<>(arr));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            used[i] = true;
            arr.add(nums[i]);
            backtrack(nums, used, n, pos + 1, arr);
            arr.remove(arr.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        result = new ArrayList<>();
        backtrack(nums, used, n, 0, new ArrayList<>());
        return result;
    }
}
