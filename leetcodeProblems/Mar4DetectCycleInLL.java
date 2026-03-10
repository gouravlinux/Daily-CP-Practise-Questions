/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // floyd's tortoise and hare(2 pointer technique)
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
public class Solution {
    private boolean solve(ListNode slow,ListNode fast){
        if (fast == null || fast.next == null) return false;//no cycle present
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
        return solve(slow, fast);
    }
    public boolean hasCycle(ListNode head) {
        // recursive solution
        return solve(head, head);
    }
}
