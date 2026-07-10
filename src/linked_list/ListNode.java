package linked_list;

/*

You are given the head of a singly linked list. Your task is to return the number of nodes in the linked list.


Example 1

Input: head = [1, 2, 3, 4, 5]

Output: 5

Example 2

Input: head = [8, 6]

Output: 2

 */

public class ListNode {


    private ListNode next;

    public ListNode(int i) {
        this.next = null;
    }

    public ListNode() {

    }

    public int getLength(ListNode head) {
        // Your code goes here
        int count = 1;
        ListNode fast = head;
        if(head == null) return 0;
        if(head.next == null) return 1;

        while(fast.next != null){
            fast = fast.next;
            count++;
        }
        return count;
    }

        public static void main(String[] args) {
            ListNode obj = new ListNode();
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            int ans = obj.getLength(head);
            System.out.println(ans);
        }
}
