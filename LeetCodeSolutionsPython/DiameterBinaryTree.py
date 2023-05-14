# Definition for a binary tree node.
class TreeNode2:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right


class DiameterBinaryTree:
    def diameterOfBinaryTree(self, root: TreeNode2) -> int:
        self.ans = 0  # variable to store the maximum diameter found so far

        def dfs(node):
            if not node:
                return 0
            left = dfs(node.left)
            right = dfs(node.right)
            self.ans = max(self.ans, left + right)  # update ans if new diameter is found
            return max(left, right) + 1  # return the maximum height of the node

        dfs(root)
        return self.ans