class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        long[][] arr = new long[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        long[][] dp = new long[n + 1][5];
        List<Integer>[][] path = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 4; j++) {
                path[i][j] = new ArrayList<>();
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 4; k++) {
                dp[i][k] = dp[i + 1][k];
                path[i][k] = new ArrayList<>(path[i + 1][k]);

                int next = findNext(arr, i + 1, arr[i][1]);

                long take = arr[i][2] + dp[next][k - 1];

                List<Integer> takePath = new ArrayList<>();
                takePath.add((int) arr[i][3]);
                takePath.addAll(path[next][k - 1]);

                if (take > dp[i][k] ||
                    (take == dp[i][k] && isSmaller(takePath, path[i][k]))) {
                    dp[i][k] = take;
                    path[i][k] = takePath;
                }
            }
        }

        Collections.sort(path[0][4]);

        int[] ans = new int[path[0][4].size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = path[0][4].get(i);
        }

        return ans;
    }

    private int findNext(long[][] arr, int start, long end) {
        int left = start;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid][0] > end) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isSmaller(List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);

        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}