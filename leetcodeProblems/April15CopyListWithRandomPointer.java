class Solution {
    Map<Node, Integer> map;
    Map<Integer, Node> newMap;
    private void makeMap(int i, Node head){
        if(head == null) return;
        map.put(head, i);
        makeMap(i+1, head.next);
    }
    private void makeNewMap(int i,Node head){
        if(head == null) return;
        newMap.put(i, head);
        makeNewMap(i+1, head.next);
    }
    private Node makeNewList(Node head){
        if(head == null){
            return null;
        }
        Node newHead = new Node(head.val);
        newHead.next = makeNewList(head.next);
        return newHead;
    }
    public Node copyRandomList(Node head) {
        // TC : O(n)
        // SC : O(n)
        map = new HashMap<>();
        newMap = new HashMap<>();
        // build a map for idx, random for all
        makeMap(0, head);
        Node newHead = makeNewList(head);
        makeNewMap(0, newHead);
        Node temp = head;
        Node newTemp = newHead;
        while(temp != null){
            int idx = map.getOrDefault(temp.random,-1);
            if(idx == -1){
                newTemp.random = null;
            }
            else{
                newTemp.random = newMap.get(idx);
            }
            newTemp = newTemp.next;
            temp = temp.next;
        }
        return newHead;
    }
}
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> map;// maps old node to new node
    private Node makeNewList(Node head){
        if(head == null) return null;
        Node newHead = new Node(head.val);
        newHead.next = makeNewList(head.next);
        map.put(head, newHead);
        return newHead;
    }
    public Node copyRandomList(Node head) {
        // TC : O(n)
        // SC : O(n)
        map = new HashMap<>();
        Node newHead = makeNewList(head);
        Node temp = head;
        Node newTemp = newHead;
        while(temp != null){
            if(temp.random == null){
                newTemp.random = null;
            }
            else{
                newTemp.random = map.get(temp.random);
            }
            temp = temp.next;
            newTemp = newTemp.next;
        }
        return newHead;
    }
}

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        // space complexity : O(n)
        // extra space: O(1)
        Node curr = head;
        // make duplicates of the nodes and point it to the next
        // that is only modifying the actual linked list
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        // make random pointers filled in newly made nodes
        curr = head;
        while(curr != null){
            if(curr.random == null){
                curr.next.random = null;
            }
            else{
                curr.next.random = curr.random.next;
            }
            curr = curr.next==null?null:curr.next.next;
        }
        // separate the linked lists
        Node newHead = head.next;
        Node newCurr = newHead;
        curr = head;
        while(curr != null && newCurr != null){
            curr.next = curr.next == null ? null:curr.next.next;
            newCurr.next = newCurr.next == null ? null:newCurr.next.next;
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}
