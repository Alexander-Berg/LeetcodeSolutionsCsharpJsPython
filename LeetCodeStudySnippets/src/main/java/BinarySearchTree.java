import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {



     //Definition for a binary tree node.
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

    class InsertintoBinarySearchTree {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root == null) return new TreeNode(val);
            TreeNode cur = root;
            while(true) {
                if(cur.val <= val) {
                    if(cur.right != null) cur = cur.right;
                    else {
                        cur.right = new TreeNode(val);
                        break;
                    }
                } else {
                    if(cur.left != null) cur = cur.left;
                    else {
                        cur.left = new TreeNode(val);
                        break;
                    }
                }
            }
            return root;
        }

        /**
         * Definition for a binary tree node.
         * public class TreeNode {
         *     int val;
         *     TreeNode left;
         *     TreeNode right;
         *     TreeNode() {}
         *     TreeNode(int val) { this.val = val; }
         *     TreeNode(int val, TreeNode left, TreeNode right) {
         *         this.val = val;
         *         this.left = left;
         *         this.right = right;
         *     }
         * }
         */
        public class BalancedBinaryTree {
            private boolean result = true;

            public boolean isBalanced(TreeNode root) {
                maxDepth(root);
                return result;
            }

            public int maxDepth(TreeNode root) {
                if (root == null)
                    return 0;
                int l = maxDepth(root.left);
                int r = maxDepth(root.right);
                if (Math.abs(l - r) > 1)
                    result = false;
                return 1 + Math.max(l, r);
            }
        }
        class KthLargestElementStream {
            private static int k;
            private PriorityQueue<Integer> heap;

            public void KthLargest(int k, int[] nums) {
                this.k = k;
                heap = new PriorityQueue<>();

                for (int num: nums) {
                    heap.offer(num);
                }

                while (heap.size() > k) {
                    heap.poll();
                }
            }

            public int add(int val) {
                heap.offer(val);
                if (heap.size() > k) {
                    heap.poll();
                }

                return heap.peek();
            }
        }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */


class ContainsDuplicate {
    private long getID(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            if (d.containsKey(m))
                return true;
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }
}
    }
}
