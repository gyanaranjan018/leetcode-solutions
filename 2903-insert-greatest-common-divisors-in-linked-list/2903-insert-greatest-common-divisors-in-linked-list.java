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
        if(head == null || head.next == null) return head;
        
        ListNode currNode = head;
        ListNode nextNode = head.next;

        while(nextNode != null){
            ListNode gcdNode = new ListNode(gcd(currNode.val, nextNode.val));
            currNode.next = gcdNode;
            gcdNode.next = nextNode;

            currNode = nextNode;
            nextNode = nextNode.next;
        }
        return head;
    }

    public int gcd(int a, int b){
        if(b == 0)
            return a;
        else
            return gcd(b, Math.abs(a-b));
    }
}