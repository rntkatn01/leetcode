import java.math.BigInteger;
/*
	You are given two non-empty linked lists representing two non-negative integers. 
	The digits are stored in reverse order, and each of their nodes contains a single digit.
	Add the two numbers and return the sum as a linked list.

	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	Example 1:
		
		Input: l1 = [2,4,3], l2 = [5,6,4]
		Output: [7,0,8]
		Explanation: 342 + 465 = 807.
		
	Example 2:
	
		Input: l1 = [0], l2 = [0]
		Output: [0]
		
	Example 3:
	
		Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
		Output: [8,9,9,9,0,0,0,1]
		
	Constraints:
	
	The number of nodes in each linked list is in the range [1, 100].
	0 <= Node.val <= 9
	It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers_02 {
	
	 public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	 
	public static class Solution {
	    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	
	    	String l1_string = "";
	    	String l2_string = "";
	    	
	    	// combine digits by following next instance for l1
	    	ListNode tempNode = l1;
	    	boolean go = true;
	    	
	    	while(go) {
	    		l1_string = Integer.toString(tempNode.val) + l1_string;
	    		
	    		if(tempNode.next == null) {
	    			go = false;
	    		}else {
	    			tempNode = tempNode.next;
	    		}
	    	}

	    	// combine digits by following next instance for l2
	    	tempNode = l2;
	    	go = true;
	    	
	    	while(go) {
	    		
	    		l2_string = Integer.toString(tempNode.val) + l2_string;
	    		
	    		if(tempNode.next == null) {
	    			go = false;
	    		}else {
	    			tempNode = tempNode.next;
	    		}
	    		
	    	}
	    	

	    	BigInteger l1_bigint = new BigInteger(l1_string);
	    	BigInteger l2_bigint = new BigInteger(l2_string);
	    	
	    	// add numbers	    	
	    	BigInteger calcResult = l1_bigint.add(l2_bigint);
	    	String tempString = calcResult.toString();
	    	
	    	
	    	// separate added number into digits
	    	ListNode resultNode = null;
	    	
	    	for(int i = 0; i < tempString.length(); i++) {
	    		if(i == 0) {
	    			resultNode = new ListNode(Character.getNumericValue(tempString.charAt(i)));
	    		}else {
	    			resultNode = new ListNode(Character.getNumericValue(tempString.charAt(i)), resultNode);
	    		}
	    	}
	    	
	    	return resultNode;
	    }
	}

	
	public static void main(String[] args) {
		
		ListNode l1_temp1 = new ListNode(9);
		ListNode l1_temp2 = new ListNode(4, l1_temp1);
		ListNode l1_temp3 = new ListNode(2, l1_temp2);
		
		ListNode l2_temp1 = new ListNode(9);
		ListNode l2_temp2 = new ListNode(4, l2_temp1);
		ListNode l2_temp3 = new ListNode(6, l2_temp2);
		ListNode l2_temp4 = new ListNode(5, l2_temp3);
		
		ListNode result = Solution.addTwoNumbers(l1_temp3, l2_temp4);
		
		boolean go = true;
		
		System.out.println("result : ");
		
		while(go) {
			
    		System.out.println(result.val);
    		
    		if(result.next == null) {
    			go = false;
    		}else {
    			result = result.next;
    		}
			
		}
		
	}
	
}
