package com.leetcodeblind75;

public class DetectCycleInLinkedList {

    /* Take two pointer  fast and slow point both to head initially 
       then move slow by one node and fast by two node until fast point to null .
        check if  fast and slow pointing to same Node then its cycle else not.
    */

    public static void main(String[] args) {

        ListNode head = new ListNode(3);

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(3);
       //. head-->1-->2-->3-->4-->5-->6-->7-->4
        head.next= node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node4;

        System.out.println(isCyclePresent(head));


        
    }

    public static boolean isCyclePresent(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next;
             if(slow==fast)
                return true ;
        }
         return false ;

    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
}

public ListNode getNext(){
    return next;
}
public void setNext(ListNode next){
    this.next = next;  
}
}