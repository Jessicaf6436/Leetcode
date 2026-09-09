class Solution {
    public int residuePrefixes(String s) {
        boolean[] seen = new boolean[26];
        int distinct = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';

            if (!seen[c]) {
                seen[c] = true;
                distinct++;
            }

            if (distinct == (i + 1) % 3) {
                ans++;
            }
        }

        return ans;
    }
}