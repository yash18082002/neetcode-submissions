class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        int fleets = 0;
        double maxTime = Integer.MIN_VALUE;
        for (int[] car : arr) {
            double time = ((double) target - car[0]) / car[1];
            if (time > maxTime) {
                fleets++;
                maxTime = time;
            }
        }
        return fleets;
    }
}
