using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCodeSolutionsCSharp
{

    
 // Definition for a binary tree node.
  public class TreeNodeN {
      public int val;
      public TreeNodeN left;
      public TreeNodeN right;
     public TreeNodeN(int val=0, TreeNodeN left=null, TreeNodeN right=null) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 


    public class BalancedBinaryTreeSolution
    {
        public bool IsBalanced(TreeNodeN root)
        {
            if (root == null)
                return true;

            int height = GetHeight(root);
            return height >= 0;
        }


        // -1 indicates that a child is imbalanced
        // >0 indicates height of highest child
        private int GetHeight(TreeNodeN node)
        {
            if (node == null) return 0;

            // If this node has any parent children, then height must be at least 2.  Otherwise at least 1
            //var minHeightThisNode = (node.left != null || node.right != null) ? 1 : 0;

            var leftChildHeight = GetHeight(node.left);
            var rightChildHeight = GetHeight(node.right);

            // If a child is not balanced, propogate upwards
            if (leftChildHeight == -1 || rightChildHeight == -1)
                return -1;

            // If this node is not balanced, indicate so
            if (Math.Abs(leftChildHeight - rightChildHeight) > 1)
                return -1;

            // Return the height of tallest child, and increment by one (because it will become height of parent)
            return Math.Max(leftChildHeight, rightChildHeight) + 1;
        }
    }
}
