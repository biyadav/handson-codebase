package com.leetcodeblind75;

public class MergeTwoSortedLists {
    public static void main(String[] args) {


        
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
 
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
 
        cur.next = list1 != null ? list1 : list2;
 
        return dummy.next;
    }
      
      

    
}

class ListNode {

    public ListNode(int data){
        this.data=data;
    }
public int data ;
public ListNode next;

public ListNode getNext(){
    return next;
}
public void setNext(ListNode next ){
    this.next= next ;
}


}
