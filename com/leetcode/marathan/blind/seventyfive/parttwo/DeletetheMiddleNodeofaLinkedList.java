package com.com.leetcode.marathan.blind.seventyfive.parttwo;

public class DeletetheMiddleNodeofaLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(1);
//        head.next.next.next.next.next = new ListNode(2);
//        head.next.next.next.next.next.next = new ListNode(6);
        ListNode res = deleteMiddle(head);
        while(res != null){
            System.out.print(res.val+", ");
            res = res.next;
        }
    }

    private static ListNode deleteMiddle(ListNode head) {
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast !=null && fast.next !=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
//    private static ListNode deleteMiddle(ListNode head) {
//        ListNode node = head;
//        int len = 0;
//        while(node !=null){
//            len +=1;
//            node = node.next;
//        }
//        System.out.println(len);
//        int mid = (len/2);
//        ListNode prev = null;
//        node = head;
//        ListNode res = node;
//        int count=0;
//        while(node !=null){
//            prev = node;
//            node = node.next;
//            count++;
//            if(count==mid)
//                prev.next = node.next;
//        }
//        return res;
//    }
}
