using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCodeSolutionsCSharp
{
    
  //Definition for a binary tree node.
   public class TreeNodeC {
      public int val;
      public TreeNodeC left;
      public TreeNodeC right;
      public TreeNodeC(int val=0, TreeNodeC left=null, TreeNodeC right=null) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  
 
    public class PathSumSolution
    {
        public bool HasPathSum(TreeNodeC root, int targetSum)
        {
            if (root == null) return false;
            if (root.left == null && root.right == null && root.val == targetSum) return true;
            if (HasPathSum(root.left, targetSum - root.val)) return true;
            return HasPathSum(root.right, targetSum - root.val);
        }
    }
}
