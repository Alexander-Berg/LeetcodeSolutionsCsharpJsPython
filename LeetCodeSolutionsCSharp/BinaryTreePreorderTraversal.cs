using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCodeSolutionsCSharp
{
    
        
 // Definition for a binary tree node.
  public class TreeNodeO {
      public int val;
      public TreeNodeO left;
     public TreeNodeO right;
      public TreeNodeO(int val=0, TreeNodeO left=null, TreeNodeO right=null) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
  }
 
    public class BinaryTreePreorderTraversal
    {
        public IList<int> PreorderTraversal(TreeNodeO root)
        {
            var list = new List<int>();
            Traverse(list, root);
            return list;
        }

        private static void Traverse(List<int> list, TreeNodeO node)
        {
            if (node == null)
                return;

            list.Add(node.val);

            Traverse(list, node.left);
            Traverse(list, node.right);
        }
    }
}
