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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> res = new Stack<>();

        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;

        while(!s1.isEmpty() || !s2.isEmpty()){
            int sum = carry;
            if(!s1.isEmpty()){
                sum += s1.pop();
            }
            if(!s2.isEmpty()){
                sum += s2.pop();
            }
            res.push(sum % 10);
            carry = sum /10;
        }

        if(carry>0){
            res.push(carry);
        }

        ListNode resList = new ListNode(-1);
        ListNode curr = resList;
        while(!res.isEmpty()){
            curr.next = new ListNode(res.pop());
            curr = curr.next;
        }
        return resList.next;
    }
}