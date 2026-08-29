class Solution {
public:
    unordered_map<int, int> pos;
    int idx;

    TreeNode* build(vector<int>& inorder, vector<int>& postorder, int left, int right) {
        if (left > right) return nullptr;

        int rootValue = postorder[idx--];
        TreeNode* root = new TreeNode(rootValue);

        int mid = pos[rootValue];

        root->right = build(inorder, postorder, mid + 1, right);
        root->left = build(inorder, postorder, left, mid - 1);

        return root;
    }

    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        for (int i = 0; i < inorder.size(); i++)
            pos[inorder[i]] = i;

        idx = postorder.size() - 1;

        return build(inorder, postorder, 0, inorder.size() - 1);
    }
};