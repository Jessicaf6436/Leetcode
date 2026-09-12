class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) {
            return 0;
        }

        int n = nums.length;
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] used = new boolean[bucketCount];

        for (int num : nums) {
            int index = (num - min) / bucketSize;

            if (!used[index]) {
                bucketMin[index] = num;
                bucketMax[index] = num;
                used[index] = true;
            } else {
                bucketMin[index] = Math.min(bucketMin[index], num);
                bucketMax[index] = Math.max(bucketMax[index], num);
            }
        }

        int answer = 0;
        int previous = min;

        for (int i = 0; i < bucketCount; i++) {
            if (!used[i]) {
                continue;
            }

            answer = Math.max(answer, bucketMin[i] - previous);
            previous = bucketMax[i];
        }

        return answer;
    }
}