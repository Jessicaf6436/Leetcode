class Solution {
    public String minWindow(String s, String t) {

        int[] need = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int right = 0;

        int required = t.length();
        int start = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < s.length()) {

            char c = s.charAt(right);

            if (need[c] > 0) {
                required--;
            }

            need[c]--;

            right++;

            while (required == 0) {

                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);

                need[leftChar]++;

                if (need[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}