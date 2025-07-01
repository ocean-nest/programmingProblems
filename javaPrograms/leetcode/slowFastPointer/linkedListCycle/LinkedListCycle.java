package linkedListCycle;

public class LinkedListCycle {

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(0);
        ListNode next3 = new ListNode(-4);

        next3.next = next1;// input pos = 1
        next2.next = next3;
        next1.next = next2;
        head.next = next1;

        //head.next.next = null;
        System.out.println(new Solution().hasCycle(head));
    }

}

class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while(fastPointer!= null && fastPointer.next != null ) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer) {
                return true;
            }
        }
        return false;


    }
}