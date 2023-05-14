using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCodeSolutionsCSharp
{
    
      // Definition for singly-linked list.
      public class ListNodeX {
          public int val;
          public ListNodeX next;
          public ListNodeX(int val=0, ListNodeX next=null) {
              this.val = val;
              this.next = next;
          }
      }
     
    public class ReversedLinkedList
    {
        public ListNodeX ReverseList(ListNodeX head)
        {
            ListNodeX prev = null;
            ListNodeX curr = head;
            ListNodeX next = null;

            while (curr != null)
            {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;
        }
    }
}
