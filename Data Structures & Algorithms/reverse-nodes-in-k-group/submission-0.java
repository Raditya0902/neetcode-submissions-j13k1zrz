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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode kPrev = dummy;
        while(true){
            ListNode kth = getKth(kPrev, k);
            if(kth == null) break;
            ListNode kNext = kth.next;
            ListNode prev = kth.next;
            ListNode curr = kPrev.next;
            while(curr != kNext){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode temp = kPrev.next;
            kPrev.next = kth;
            kPrev = temp;
        }
        return dummy.next;
    }  

    ListNode getKth(ListNode curr, int k){
        while(curr != null && k > 0){
            curr = curr.next;
            k--;
        }
        return curr;
    } 
}
