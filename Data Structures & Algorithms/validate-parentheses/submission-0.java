class Solution {
    public boolean isValid(String str) {
        if (str.length() % 2 != 0) return false;
        Stack<Character> s = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                s.push(')');
            } else if (c == '{') {
                s.push('}');
            } else if (c == '[') {
                s.push(']');
            } else {
                if (s.isEmpty() || s.peek() != c) {
                    return false;
                }
                s.pop();
            }
        }
        return s.isEmpty();
    }
}
