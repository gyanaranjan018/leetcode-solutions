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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //recursive approch
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode res = null;
        if(list1.val < list2.val){
            res = new ListNode(list1.val);
            res.next = mergeTwoLists(list1.next, list2);
        }
        else{
            res = new ListNode(list2.val);
            res.next = mergeTwoLists(list1, list2.next);
        }
        return res;

        /**  Iterative Approch
        ListNode head = new ListNode(-1);
        ListNode res = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                res.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else{
                res.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            res = res.next;
        }
        if(list1 != null){
            res.next = list1;
        }
        if(list2 != null){
            res.next = list2;
        }   
        return head.next;
        **/
    }
}