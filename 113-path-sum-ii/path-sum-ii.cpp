class Solution {
public:
    vector<vector<int>> result;
    vector<int> path;

    void dfs(TreeNode* root, int targetSum) {
        if (root == nullptr)
            return;

        path.push_back(root->val);
        targetSum -= root->val;

        if (root->left == nullptr && root->right == nullptr) {
            if (targetSum == 0)
                result.push_back(path);
        } else {
            dfs(root->left, targetSum);
            dfs(root->right, targetSum);
        }

        path.pop_back();
    }

    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        dfs(root, targetSum);
        return result;
    }
};