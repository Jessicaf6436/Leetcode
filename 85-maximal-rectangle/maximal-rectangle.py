class Solution:
    def maximalRectangle(self, matrix):
        rows = len(matrix)
        cols = len(matrix[0])
        heights = [0] * cols
        max_area = 0

        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == '1':
                    heights[j] += 1
                else:
                    heights[j] = 0

            max_area = max(max_area, self.largestRectangle(heights))

        return max_area

    def largestRectangle(self, heights):
        stack = []
        max_area = 0

        for i in range(len(heights) + 1):
            current = 0 if i == len(heights) else heights[i]

            while stack and heights[stack[-1]] > current:
                height = heights[stack.pop()]
                width = i if not stack else i - stack[-1] - 1
                max_area = max(max_area, height * width)

            stack.append(i)

        return max_area
