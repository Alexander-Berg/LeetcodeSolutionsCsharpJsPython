using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCodeSolutionsCSharp
{
    
  // Definition for a binary tree node.
   public class TreeNode {
       public int val;
       public TreeNode left;
       public TreeNode right;
       public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
           this.val = val;
          this.left = left;
           this.right = right;
       }
   }
  
    public class SameTreeSolution
    {
        public bool IsSameTree(TreeNode p, TreeNode q)
        {
            return (p == null && q == null) || ((p?.val == q?.val) && IsSameTree(p.left, q.left) && IsSameTree(p.right, q.right));
        }
    }
}
