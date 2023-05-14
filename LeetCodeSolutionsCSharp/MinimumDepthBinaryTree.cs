using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCodeSolutionsCSharp
{
    
  public class TreeNodeB {
      public int val;
     public TreeNodeB left;
     public TreeNodeB right;
     public TreeNodeB(int val=0, TreeNodeB left=null, TreeNodeB right=null) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
  }
 
    public class MinimumDepthBinaryTree
    {
        public int MinDepth(TreeNodeB root)
        {
            if (root == null)
            {
                return 0;
            }

            var leftMinDepth = MinDepth(root.left);
            var rightMinDepth = MinDepth(root.right);

            if (leftMinDepth == 0 || rightMinDepth == 0)
            {
                return Math.Max(leftMinDepth, rightMinDepth) + 1;
            }

            return Math.Min(leftMinDepth, rightMinDepth) + 1;
        }
    }
}
