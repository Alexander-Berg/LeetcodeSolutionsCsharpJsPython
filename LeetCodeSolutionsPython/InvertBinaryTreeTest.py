from InvertBinaryTree import TreeNode

import unittest
class MyTestCase(unittest.TestCase):
    def test_invertTree(invertBinaryTree):
       # Test Case 1
       root1 = TreeNode(4)
       root1.left = TreeNode(2)
       root1.left.left = TreeNode(1)
       root1.left.right = TreeNode(3)
       root1.right = TreeNode(7)
       root1.right.left = TreeNode(6)
       root1.right.right = TreeNode(9)
       expected_output1 = TreeNode(4)
       expected_output1.left = TreeNode(7)
       expected_output1.left.left = TreeNode(9)
       expected_output1.left.right = TreeNode(6)
       expected_output1.right = TreeNode(2)
       expected_output1.right.left = TreeNode(3)
       expected_output1.right.right = TreeNode(1)
       assert invertBinaryTree.invertTree(root1) == expected_output1


    def test_invertTree2(invertBinaryTree):
       # Test Case 2
       root2 = TreeNode(2)
       root2.left = TreeNode(1)
       root2.right = TreeNode(3)
       expected_output2 = TreeNode(2)
       expected_output2.left = TreeNode(3)
       expected_output2.right = TreeNode(1)
       assert invertBinaryTree.invertTree(root2) == expected_output2


    def test_invertTree3(invertBinaryTree):
       # Test Case 3
       root3 = TreeNode(1)
       expected_output3 = TreeNode(1)
       assert invertBinaryTree.invertTree(root3) == expected_output3


    def test_invertTree4(invertBinaryTree):
       # Test Case 4
       root4 = None
       expected_output4 = None
       assert invertBinaryTree.invertTree(root4) == expected_output4


    def test_invertTree5(invertBinaryTree):
      # Test Case 5
      root5 = TreeNode(4)
      root5.left = TreeNode(2)
      root5.right = TreeNode(7)
      root5.right.left = TreeNode(6)
      root5.right.right = TreeNode(9)
      expected_output5 = TreeNode(4)
      expected_output5.left = TreeNode(7)
      expected_output5.left.left = TreeNode(9)
      expected_output5.left.right = TreeNode(6)
      expected_output5.right = TreeNode(2)
      assert invertBinaryTree.invertTree(root5) == expected_output5

if __name__ == '__main__':
    unittest.main()