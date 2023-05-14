using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCodeSolutionsCSharp
{
    
  // Definition for a binary tree node.
   public class TreeNodeP {
       public int val;
       public TreeNodeP left;
       public TreeNodeP right;
       public TreeNodeP(int val=0, TreeNodeP left=null, TreeNodeP right=null) {
           this.val = val;
          this.left = left;
           this.right = right;
       }
   }
  
    public class BinaryTreePostorderTraversal
    {
        public IList<int> PostorderTraversal(TreeNodeP root)
        {
            var list = new List<int>();

            Traverse(list, root);
            return list;
        }

        private static void Traverse(List<int> list, TreeNodeP node)
        {
            if (node == null)
                return;

            Traverse(list, node.left);
            Traverse(list, node.right);

            list.Insert(list.Count, node.val);
        }
    }
}
