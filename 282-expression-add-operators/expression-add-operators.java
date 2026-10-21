
import java.util.*;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), num, target, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder path,
                           String num, long target, int index,
                           long value, long last) {
        if (index == num.length()) {
            if (value == target) {
                result.add(path.toString());
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') {
                break;
            }

            long current = Long.parseLong(num.substring(index, i + 1));
            int length = path.length();

            if (index == 0) {
                path.append(current);
                backtrack(result, path, num, target, i + 1,
                          current, current);
                path.setLength(length);
            } else {
                path.append('+').append(current);
                backtrack(result, path, num, target, i + 1,
                          value + current, current);
                path.setLength(length);

                path.append('-').append(current);
                backtrack(result, path, num, target, i + 1,
                          value - current, -current);
                path.setLength(length);

                path.append('*').append(current);
                backtrack(result, path, num, target, i + 1,
                          value - last + last * current,
                          last * current);
                path.setLength(length);
            }
        }
    }
}
