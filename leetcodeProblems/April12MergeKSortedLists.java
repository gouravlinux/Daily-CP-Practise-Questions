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
    private ListNode merge2Lists(ListNode node1, ListNode node2){
        if(node1 == null) return node2;
        if(node2 == null) return node1;
        ListNode head = new ListNode(0);
        if(node1.val <= node2.val){
            head.next = node1;
            node1 = node1.next;
        }
        else{
            head.next = node2;
            node2 = node2.next;
        }
        ListNode nextNode = merge2Lists(node1, node2);
        head.next.next = nextNode;
        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        // k -> k-1
        // TC : O(n*k)
        // SC : O(n)
        int k = lists.length;
        if(k == 0){
            return null;
        }
        if(k == 1){
            return lists[0];
        }
        // if more than 2
        ListNode head = merge2Lists(lists[0], lists[1]);
        ListNode[] newList = new ListNode[k-1];
        newList[0] = head;
        for(int i = 2;i < k;i++){
            newList[i-1] = lists[i]; 
        } 
        return mergeKLists(newList);
    }
}

class Solution {
    int k;
    private ListNode merge2Lists(ListNode node1, ListNode node2){
        if(node1 == null) return node2;
        if(node2 == null) return node1;
        if(node1.val <= node2.val){
            node1.next = merge2Lists(node1.next, node2);
            return node1;
        }
        else{
            node2.next = merge2Lists(node1, node2.next);
            return node2;
        }
    }
    private ListNode partition(ListNode[] lists, int l,int r){
        if(l > r){
            return null;
        }
        if(l == r){
            return lists[l];
        }
        // else we have more than 2 LLs to be merged
        // use D&C
        int mid = l+(r-l)/2;
        ListNode leftNode = partition(lists, l, mid);
        ListNode rightNode = partition(lists, mid+1, r);
        return merge2Lists(leftNode, rightNode);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        // using divide and conquer approach
        // height of tree  = log(k)
        // let N be total no. of nodes in 2 lists merged
        // TC : O(log(k) * N)
        // SC : O(log(k))->stack space and merge2Lists -> O(N)
        k = lists.length;
        int l = 0;
        int r = k-1;
        ListNode head = partition(lists, l, r);
        return head;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // TC : O(klog(k) + k*N*log(k))
        // SC : O(k)
        // using min - Priority Queue
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node: lists){
            if(node != null)
                pq.add(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            temp.next = minNode;
            if(minNode.next != null){
                pq.add(minNode.next);
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}
