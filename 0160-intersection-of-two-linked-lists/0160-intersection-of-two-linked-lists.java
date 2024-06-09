/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int n1 =0, n2=0;

        while(temp1 != null){
            n1++;
            temp1 = temp1.next;
        }

        while(temp2 != null){
            n2++;
            temp2 = temp2.next;
        }

        temp1 = headA;
        temp2 = headB;

        if(n2 > n1){
            for(int i = 0; i< n2-n1; i++){
                temp2 = temp2.next;
            }
        }
        else if(n1 > n2){
            for(int i = 0; i< n1-n2; i++){
                temp1 = temp1.next;
            }
        }
        while(temp1 != null && temp2 != null){
            if(temp1 == temp2){
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }
}