using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCodeSolutionsCSharp
{

    // Definition for singly-linked list.
    public class ListNodeB
    {
        public int val;
        public ListNodeB next;
        public ListNodeB(int val = 0, ListNodeB next = null)
        {
            this.val = val;
            this.next = next;
        }
    }

    public class RemoveLinkedListElements
    {
        public ListNodeB RemoveElements(ListNodeB head, int val)
        {
            ListNodeB dummy = new ListNodeB(0);
            dummy.next = head;

            ListNodeB prev = dummy;
            ListNodeB curr = head;

            while (curr != null)
            {
                if (curr.val == val)
                    prev.next = curr.next;
                else
                    prev = curr;
                curr = curr.next;
            }

            return dummy.next;
        }
    }
}
