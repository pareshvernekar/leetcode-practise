package test.leetcode;

public class ReverseNodesInKGroup {

	static ListNode buildLinkedList(int n) {
		ListNode head = null;
		ListNode temp = null;
		for (int i=0;i<n;i++) {
			if (head == null) {
				head = new ListNode(i+1);
				temp = head;
				continue;
			} 
			temp.next = new ListNode(i+1);
			temp = temp.next;
		}
		return head;
	}
	
	 public static ListNode  reverseKGroup(ListNode head, int k) {
	 
		 ListNode temp = null;
		 ListNode[] nodeArr = new ListNode[k];
		 ListNode start = head;
		 while (start != null) {
			 int tempVal = 0;
			 int count = 0;
			 
			 for (int i=0;(i<k && start != null);i++) {
				 nodeArr[i]=start;
				 start=start.next;
				 count+=1;
			 }
		 
			 int startIndex=0, endIndex=k-1;
			 while (count==k && startIndex < endIndex) {
				 tempVal=nodeArr[startIndex].val;
				 nodeArr[startIndex].val=nodeArr[endIndex].val;
				 nodeArr[endIndex].val=tempVal;
				 startIndex+=1;
				 endIndex-=1;
			 }
		 }
		 return head;
	 }
	 static void traverse(ListNode head) {
		 while (head != null) {
			 System.out.print(head.val+"-->");
			 head = head.next;
		 }
		 System.out.println();
	 }
	
	public static void main(String[] argv) {
		ListNode head = buildLinkedList(5);
		ListNode temp = head;
		traverse(temp);
		head=reverseKGroup(head, 4);
		temp = head;
		traverse(temp);
	}
}

class ListNode {
   int val;
 ListNode next;
 ListNode(int x) { val = x; }
}
