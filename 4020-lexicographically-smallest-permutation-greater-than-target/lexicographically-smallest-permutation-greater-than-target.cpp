class Solution {
public:
    string lexGreaterPermutation(string s, string target) {
        int n = s.size();

        vector<int> freq(26, 0);
        for (char c : s) {
            freq[c - 'a']++;
        }

        string prefix = "";

        for (int i = 0; i < n; i++) {
            int x = target[i] - 'a';

            if (freq[x] > 0) {
                freq[x]--;
                prefix += target[i];
            } else {
                for (int c = x + 1; c < 26; c++) {
                    if (freq[c] > 0) {
                        freq[c]--;

                        string ans = prefix;
                        ans += char('a' + c);

                        for (int j = 0; j < 26; j++) {
                            ans += string(freq[j], char('a' + j));
                        }

                        return ans;
                    }
                }

                break;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            vector<int> rem(26, 0);

            for (char c : s) {
                rem[c - 'a']++;
            }

            string prefix2 = "";

            for (int j = 0; j < i; j++) {
                int x = target[j] - 'a';

                if (rem[x] == 0) {
                    break;
                }

                rem[x]--;
                prefix2 += target[j];
            }

            if ((int)prefix2.size() != i) {
                continue;
            }

            int x = target[i] - 'a';

            for (int c = x + 1; c < 26; c++) {
                if (rem[c] > 0) {
                    rem[c]--;

                    string ans = prefix2;
                    ans += char('a' + c);

                    for (int j = 0; j < 26; j++) {
                        ans += string(rem[j], char('a' + j));
                    }

                    return ans;
                }
            }
        }

        return "";
    }
};