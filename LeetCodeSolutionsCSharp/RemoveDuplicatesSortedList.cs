using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCodeSolutionsCSharp
{
   
   //Definition for singly-linked list.
   public class ListNode {
       public int val;
       public ListNode next;
       public ListNode(int val=0, ListNode next=null) {
           this.val = val;
           this.next = next;
       }
   }
  
    public class RemoveDuplicateSortedListSolution
    {
        public ListNode DeleteDuplicates(ListNode head)
        {

            if (head == null)
                return null;

            if (head.next == null)
                return head;

            ListNode prevNode = head;
            for (ListNode node = head.next; node != null; node = node.next)
            {
                if (node.val == prevNode.val)
                {
                    prevNode.next = node.next;
                }
                else
                {
                    prevNode = node;
                }
            }

            return head;

        }
    }
}
