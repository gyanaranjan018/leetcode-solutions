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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode lhead = head;
        ListNode slow = lhead;
        ListNode fast = lhead;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rhead = slow.next;
        slow.next = null;
        return merge(sortList(lhead), sortList(rhead));
    }
    public ListNode merge(ListNode lhead, ListNode rhead){
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(lhead != null && rhead != null){
            if(lhead.val <= rhead.val){
                temp.next = lhead;
                lhead = lhead.next;
            }
            else{
                temp.next = rhead;
                rhead = rhead.next;
            }
            temp = temp.next;
        }
        while(lhead != null){
            temp.next = lhead;
            lhead = lhead.next;
            temp = temp.next;
        }
        while(rhead != null){
            temp.next = rhead;
            rhead = rhead.next;
            temp = temp.next;
        }
        return head.next;
    }
}