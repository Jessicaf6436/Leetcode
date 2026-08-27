class Solution:
    def lexGreaterPermutation(self, s, target):
        n = len(s)

        for i in range(n - 1, -1, -1):
            freq = [0] * 26

            for c in s:
                freq[ord(c) - 97] += 1

            possible = True

            for j in range(i):
                x = ord(target[j]) - 97
                freq[x] -= 1

                if freq[x] < 0:
                    possible = False
                    break

            if not possible:
                continue

            cur = ord(target[i]) - 97

            for c in range(cur + 1, 26):
                if freq[c] > 0:
                    freq[c] -= 1

                    ans = target[:i] + chr(c + 97)

                    for k in range(26):
                        ans += chr(k + 97) * freq[k]

                    return ans

        return ""