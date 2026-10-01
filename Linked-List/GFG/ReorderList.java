/*
Problem: Reorder List
Platform: GeeksforGeeks
Problem Link: https://www.geeksforgeeks.org/problems/reorder-list/1

Approach:
1. Find the middle of the linked list.
2. Split the list into two halves.
3. Reverse the second half.
4. Merge both halves alternately.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {

    Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    Node reverse(Node head) {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reorderList(Node head) {

        if (head == null || head.next == null) {
            return;
        }

        Node middle = getMiddle(head);

        Node second = middle.next;
        middle.next = null;

        second = reverse(second);

        Node first = head;

        while (first != null && second != null) {

            Node firstNext = first.next;
            Node secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}