//3217. Delete Nodes From Linked List Present in Array

import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class Solution6 {
    public ListNode modifiedList(int[] nums, ListNode head) {

        // Set<Integer> set = new HashSet<>();
        // for(int num : nums){
        //     set.add(num);
        // }
        // while(head!=null && set.contains(head.val)){
        //     head = head.next;
        // }
        // if(head == null) return null;

        // ListNode curr = head;
        // while(curr!=null && curr.next!=null){
        //     if(set.contains(curr.next.val)){
        //         curr.next = curr.next.next;
        //     }
        //     else{
        //         curr = curr.next;
        //     }
        // }
        // return head;


        // OTHER APPROACH: 
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0,head);
        for(int num : nums){
            set.add(num);
        }
        for(ListNode curr = dummy; curr.next!=null;){
            if(set.contains(curr.next.val)){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}