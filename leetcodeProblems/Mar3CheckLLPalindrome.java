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
    private boolean isPalindrome(List<Integer> ls){
        int n = ls.size();
        int i = 0;
        int j = n-1;
        while(i < j){
            if (ls.get(i) != ls.get(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        List<Integer> ls = new ArrayList<>();
        while(head != null){
            ls.add(head.val);
            head = head.next;
        }
        return isPalindrome(ls);
    }
}
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
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        // using recursion
        if (head == null || head.next == null)
            return head;//0 or 1 node
        ListNode newHead = reverseList(head.next);//subproblem
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode middle = middleNode(head);
        ListNode newHead = reverseList(middle);
        while (newHead != null && head != newHead) {
            if (head.val != newHead.val)
                return false;
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
}
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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode temp = slow.next;//store it
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        if (fast != null){
            // odd length
            slow = slow.next;
        }
        while(prev != null && slow != null){
            if (prev.val != slow.val){
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}
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
    ListNode curr;
    public boolean recurr(ListNode head) {
        if (head == null){
            return true;//empty LLs are palindromes
        }
        boolean ans = recurr(head.next);
        if (head.val != curr.val){
            return false;
        }
        else{
            curr = curr.next;
        }
        return ans;
    }
    public boolean isPalindrome(ListNode head){
        curr = head;
        return recurr(head);
    }
}
