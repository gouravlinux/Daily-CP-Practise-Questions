class Solution {
    private int findSize(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = findSize(head);
        int removeIdx = size-n;
        ListNode prev = head;
        ListNode curr = head;
        if (removeIdx == 0) return head.next;//if node to delete is 1st node
        while(removeIdx != 0){
            prev = curr;
            curr = curr.next;
            removeIdx--;
        }
        prev.next = curr.next;
        return head;
    }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1-pass solution
        ListNode curr = head;
        ListNode prev = head;
        for(int i = 0;i<n;i++){
            curr = curr.next;
        }
        if (curr == null) return head.next;
        while(curr!=null && curr.next!=null){
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}
