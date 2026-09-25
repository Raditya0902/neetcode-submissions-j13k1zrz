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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while(curr != null && curr.next != null){
            ListNode nextNode = curr.next;
            int g = gcd(curr.val, nextNode.val);
            ListNode newNode = new ListNode(g);
            newNode.next = nextNode;
            curr.next = newNode;
            curr = nextNode;
        }  
        return head; 
    }

    int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}