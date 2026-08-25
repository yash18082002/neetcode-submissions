class Solution {
    List<String> result;
    private String[] LETTERS = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    private void backtrack(String digits, int pos, int len, StringBuilder sb) {
        if (pos > len) {
            result.add(sb.toString());
            return;
        }
        char c = digits.charAt(pos);
        String letters = LETTERS[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtrack(digits, pos + 1, len, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.equals("")) return result;
        int n = digits.length();
        backtrack(digits, 0, n - 1, new StringBuilder());
        return result;
    }
}
