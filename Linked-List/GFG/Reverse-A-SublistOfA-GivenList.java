class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    
    Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    Node reverseBetween(int a, int b, Node head) {
        
        Node dummy = new Node(-1);
        Node temp = dummy;
        dummy.next = head;
        
        for(int i = 1; i <= a-1; i++){
            temp = temp.next;
        }
        
        Node tail1 = temp;
        Node head2 = temp.next;
        
        for(int i = 1; i <= b-a+1; i++){
            temp = temp.next;
        }
        
        Node tail2 = temp;
        Node head3 = temp.next;
        tail1.next = null;
        tail2.next = null;
        
        reverse(head2);
        
        tail1.next = tail2;
        head2.next = head3;
        
        return dummy.next;
    }
}