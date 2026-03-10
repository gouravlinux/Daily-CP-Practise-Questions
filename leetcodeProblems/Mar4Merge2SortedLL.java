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
    private ListNode merge(ListNode list1, ListNode list2){
        if(list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head;
        if (list1.val <= list2.val){
            head = list1;
            list1 = list1.next;
        }
        else{
            head = list2;
            list2 = list2.next;
        } 
        ListNode mergedHead = merge(list1, list2);
        head.next = mergedHead;
        return head;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	// recursive solution
        ListNode head = merge(list1, list2);
        return head;
    }
}
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //iterative solution
        ListNode head;
        ListNode curr;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
            if (list1.val <= list2.val) {
                head = list1;
                curr = list1;
                list1 = list1.next;
            } else {
                curr = list2;
                head = list2;
                list2 = list2.next;
            }
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        while (list1 != null) {
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
        }
        while (list2 != null) {
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }
        return head;
    }
}
