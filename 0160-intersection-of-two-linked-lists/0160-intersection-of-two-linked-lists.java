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

        if(n1 < n2){
            return collisionPoint(temp1, temp2, n2-n1);
        }
        else{
            return collisionPoint(temp2, temp1, n1-n2);
        }
    }
    public ListNode collisionPoint(ListNode smaller, ListNode greater, int diff){
        for(int i = 0; i < diff; i++){
            greater = greater.next;
        }
        while(smaller != greater){
            smaller = smaller.next;
            greater = greater.next;
        }
        return smaller;
    }
}