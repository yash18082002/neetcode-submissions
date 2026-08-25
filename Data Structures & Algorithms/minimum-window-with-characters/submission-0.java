class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] freqT = new int[128];
        int[] freqS = new int[128];
        int unique = 0;

        for (char c : t.toCharArray()) {
            if (freqT[c] == 0) unique++;
            freqT[c]++;
        }
        
        int left = 0;
        int n = s.length();
        int match = 0;
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            freqS[c]++;
            if (freqT[c] > 0 && freqS[c] == freqT[c]) {
                match++;
            }
            while (match == unique) {
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }
                char l = s.charAt(left++);
                freqS[l]--;
                if (freqT[l] > 0 && freqS[l] < freqT[l]) {
                    match--;
                }
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}
