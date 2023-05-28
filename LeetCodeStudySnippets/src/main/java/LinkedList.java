import java.util.Stack;

public class LinkedList {
    // Definition for singly-linked list.
    public class SinglyListNode {
        int val;
        SinglyListNode next;

        SinglyListNode(int x) {
            val = x;
        }
    }


    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode() {

        }
    }

    public class LinkedListCycle {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    break;
                }
            }
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class RemoveLinkedListElements {
        public ListNode removeElements(ListNode head, int val) {
            ListNode result = new ListNode(0);
            result.next = head;

            ListNode current = result;

            while (current.next != null) {
                if (current.next.val == val) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }

            return result.next;
        }
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            ListNode es=null,ee=null,os=null,oe = null;
            // es->even start  ee->even end  os->odd start  oe->odd end
            int count=0;
            ListNode curr = head;
            while(curr!=null){
                count++;
                if(count%2 != 0){  if(os==null) {os = oe = curr;}
                else  {oe.next = curr;  oe = oe.next; }
                }
                else{
                    if(es==null){
                        es = ee = curr;}
                    else{
                        ee.next = curr;
                        ee = ee.next;
                    }}
                curr = curr.next;
            }
            if(os==null || es==null)   return head;
            oe.next = es;
            ee.next = null;
            return os;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class OddEvenLinkedList {
        public ListNode oddEvenList(ListNode head) {
            ListNode es=null,ee=null,os=null,oe = null;
            // es->even start  ee->even end  os->odd start  oe->odd end
            int count=0;
            ListNode curr = head;
            while(curr!=null){
                count++;
                if(count%2 != 0){  if(os==null) {os = oe = curr;}
                else  {oe.next = curr;  oe = oe.next; }
                }
                else{
                    if(es==null){
                        es = ee = curr;}
                    else{
                        ee.next = curr;
                        ee = ee.next;
                    }}
                curr = curr.next;
            }
            if(os==null || es==null)   return head;
            oe.next = es;
            ee.next = null;
            return os;
        }
    }

    // Definition for doubly-linked list.
    class DoublyListNode {
        int val;
        DoublyListNode next, prev;
        DoublyListNode(int x) {val = x;}
    }


// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};



    class FlattenMultilevelDoublyLinkedList{
        public Node flatten(Node head) {
            Stack<Node> stk = new Stack<>();
            Node curr =  head;
            if(curr==null)
                return null;
            while(curr.next !=null  || curr.child!=null)
            {
                while(curr.child==null)
                {
                    if(curr.next ==null)
                        break;
                    curr= curr.next;
                }
                if(curr.next!=null)
                {
                    curr.next.prev = null;
                    stk.add(curr.next);
                    curr.next = null;
                }
                if(curr.child!=null)
                {
                    Node temp = curr.child;
                    temp.prev = curr;
                    curr.child = null;
                    curr.next = temp;
                    curr = temp;
                }
            }
            while(!stk.isEmpty())
            {
                Node rem =  stk.pop();
                rem.prev = curr;
                curr.next = rem;
                while(curr.next!=null)
                {
                    curr = curr.next;
                }
            }
            return head;
        }
    }
}
