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
            int gcdValue = gcd(curr.val, nextNode.val);
            ListNode newNode = new ListNode(gcdValue);
            curr.next = newNode;
            newNode.next = nextNode;
            curr = nextNode;
        }
        return head;
    }

    private int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}