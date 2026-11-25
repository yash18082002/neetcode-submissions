class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int hash = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, hash));
            int start = hash + 1;
            result.add(str.substring(start, start + len));
            i = start + len;
        }
        return result;
    }
}
