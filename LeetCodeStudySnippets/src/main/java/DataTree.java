import java.util.ArrayList;
import java.util.List;

public class DataTree {

     // Definition for a binary tree node.
      public class TreeNode {
         int val;
          TreeNode left;
          TreeNode right;
         TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
              this.left = left;
             this.right = right;
          }
      }

    class BinaryTreePreorderTraversal {
        private List<Integer> answer = new ArrayList<>();

        private void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            // Visit the root first, then the left subtree, then the right subtree.
            answer.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }

        public List<Integer> preorderTraversal(TreeNode root) {
            dfs(root);
            return answer;
        }
    }

    class BinaryTreePostOrderTraversal {
        static List<Integer> result;

        private static void traversePostOrder(TreeNode node) {
            if (node == null) return;
            if (node.left != null) {
                traversePostOrder(node.left);
            }
            if (node.right != null) {
                traversePostOrder(node.right);
            }
            result.add(node.val);
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            result = new ArrayList<>();
            traversePostOrder(root);
            return result;
        }
    }

    class BinaryTreeInorderTraversal {
        List<Integer> list = new ArrayList<Integer>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root != null){
                inorderTraversal(root.left);
                list.add(root.val);
                inorderTraversal(root.right);
            }
            return list;
        }
    }
    class TopDown {
        private int answer; // don't forget to initialize answer before call maximum_depth
        private void maximum_depth(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                answer = Math.max(answer, depth);
            }
            maximum_depth(root.left, depth + 1);
            maximum_depth(root.right, depth + 1);
        }
    }
    class BottomUp {
        public int maximum_depth(TreeNode root) {
            if (root == null) {
                return 0;                                   // return 0 for null node
            }
            int left_depth = maximum_depth(root.left);
            int right_depth = maximum_depth(root.right);
            return Math.max(left_depth, right_depth) + 1;   // return depth of the subtree rooted at root
        }
    }

}
