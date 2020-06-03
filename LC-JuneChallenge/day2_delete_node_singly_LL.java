/**Problem - 

Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Given linked list -- 

	head = [4,5,1,9], which looks like following:

	4 -> 5 -> 1 -> 9
	
	node = 5
**/	


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
         
        // 4 -> 5 -> 1 -> 9 , node = 5
        //copy value of next node 4 -> 1 -> 1 -> 9
        node.val = node.next.val;
        //change next of the node
        //4 -> 1 -> 9
        node.next = node.next.next;
            
    }
}