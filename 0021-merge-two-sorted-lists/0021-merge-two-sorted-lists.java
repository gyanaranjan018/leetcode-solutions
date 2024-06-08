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
        ListNode res = null, temp = null, ans = null;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp = new ListNode(list1.val);
                list1 = list1.next;
            }
            else{
                temp = new ListNode(list2.val);
                list2 = list2.next;
            }
            if(res == null){
                res = temp;
                ans = res;
            }
            else{
                res.next = temp;
                res = res.next;
            }
        }
        if(list1 != null){
            while(list1 != null){
            if(res == null){
                res = new ListNode(list1.val);
                ans = res;
            }
            else{
                res.next = new ListNode(list1.val);
                res = res.next;
            }
            list1= list1.next;
            }
        }
        if(list2 != null){
            while(list2 != null){
                if(res == null){
                res = new ListNode(list2.val);
                ans = res;
            }
            else{
                res.next = new ListNode(list2.val);
                res = res.next;
            }
            list2 = list2.next;
            }
        }
        return ans;
    }
}