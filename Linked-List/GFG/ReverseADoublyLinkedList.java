class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
    }
}



class Solution {
    public Node reverse(Node head) {
        // code here
        if(head.next == null) return head;
        Node curr = head;
        Node temp = null;
        
        while(curr != null){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        
        return temp.prev;
    }
}