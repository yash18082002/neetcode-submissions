class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freqs = new List[nums.length + 1];
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (freqs[freq] == null) freqs[freq] = new ArrayList<>();
            freqs[freq].add(num);
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = nums.length; i >= 1; i--) {
            if (freqs[i] == null) continue;
            for (int num : freqs[i]) {
                result[index] = num;
                index++;
                if (index == k) return result;
            }
        }
        return result;
    }
}
