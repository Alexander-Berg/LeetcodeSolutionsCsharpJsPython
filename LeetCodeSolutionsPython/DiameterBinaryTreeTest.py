import unittest

from DiameterBinaryTree import TreeNode2, DiameterBinaryTree


class TestDiameterBinaryTree(unittest.TestCase):

    def test_diameterOfBinaryTree(self):
        # create a binary tree with diameter 3
        root = TreeNode2(1)
        root.left = TreeNode2(2)
        root.left.left = TreeNode2(4)
        root.left.right = TreeNode2(5)
        root.right = TreeNode2(3)
        expected_output = 3
        dbt = DiameterBinaryTree()
        self.assertEqual(dbt.diameterOfBinaryTree(root), expected_output)

    def test_diameterOfBinaryTree2(self):
        # create a binary tree with diameter 0
        root = TreeNode2(1)
        expected_output = 0
        dbt = DiameterBinaryTree()
        self.assertEqual(dbt.diameterOfBinaryTree(root), expected_output)

    def test_diameterOfBinaryTree3(self):
        # create a binary tree with diameter 2
        root = TreeNode2(1)
        root.left = TreeNode2(2)
        root.left.right = TreeNode2(3)
        expected_output = 2
        dbt = DiameterBinaryTree()
        self.assertEqual(dbt.diameterOfBinaryTree(root), expected_output)

        # create a binary tree with diameter 5
        root = TreeNode2(1)
        root.left = TreeNode2(2)
        root.left.left = TreeNode2(4)
        root.left.left.left = TreeNode2(5)
        root.right = TreeNode2(3)
        expected_output = 5
        dbt = DiameterBinaryTree()
        self.assertEqual(dbt.diameterOfBinaryTree(root), expected_output)


if __name__ == '__main__':
    unittest.main()
