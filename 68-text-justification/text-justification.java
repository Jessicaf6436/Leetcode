class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i;
            int totalLength = 0;

            while (j < words.length) {
                if (totalLength + words[j].length() + (j - i) > maxWidth) {
                    break;
                }

                totalLength += words[j].length();
                j++;
            }

            int wordCount = j - i;
            int spaces = maxWidth - totalLength;

            StringBuilder line = new StringBuilder();

            if (j == words.length || wordCount == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int gaps = wordCount - 1;
                int spacesPerGap = spaces / gaps;
                int extraSpaces = spaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        int count = spacesPerGap;

                        if (extraSpaces > 0) {
                            count++;
                            extraSpaces--;
                        }

                        for (int s = 0; s < count; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}
