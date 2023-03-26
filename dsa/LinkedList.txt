package linkedList;

import java.util.Scanner;

public class LinkedList {

	public static class Node{
		
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public static Node head;
	public static Node tail;
	public static int size;
	
	public void addFirst(int data) {
		
		//create node
		Node newNode = new Node(data);
		size++;
		
		if(head == null) {
			head = tail = newNode;
			return;
		}
		//assign head
		newNode.next = head;
		
		head = newNode;
	}
	
	public void addLast(int data) {
		Node newNode = new Node(data);
		size++;
		if(head == null) {
			head = tail = newNode;
			return;
		}
		
		tail.next = newNode;
		tail = newNode;
	}
	
	public void print() {
		
		Node temp = head;
		
		if(head == null) {
			System.out.println("LinkedList is empty");
		}
		
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		
	}
	
	
	public void add(int idx, int data) {
		
		if(idx==0) {
			addFirst(data);
			return;
		}
		Node newNode = new Node(data);
		size++;
		Node temp = head;
		int i =0;
		
		while(i<idx-1) {
			temp = head.next;
			i++;
		}
		
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	public int itrSearch(int key) {
		Node temp = head;
		int i=0;
		
		while(temp != null) {
			if(temp.data == key) {
				return i;
			}else {
				temp = temp.next;
				i++;
			}
		}
		
		return -1;
	}
	
	public int helper(Node head, int key) {
		if(head == null) {
			return -1;
		}
		
		if(head.data == key) {
			return 0;
		}
		
		int idx = helper(head.next, key);
		if(idx == -1) {
			return -1;
		}
		
		return idx+1;
	}
	
	public int recsearch(int key) {
		return helper(head, key);
	}
	
	public int removeFirst() {
		if(size == 0) {
			System.out.println("LL is empty");
			return Integer.MIN_VALUE;
		}else if(size==1) {
			int val = head.data;
			head = tail = null;
			return val;
		}
		
		int val = head.data;
		head = head.next;
		size--;
		return val;
	}
	
	public int removeLast() {
		if(size==0) {
			System.out.println("LL is empty");
			return Integer.MIN_VALUE;
		}else if(size == 1) {
			int val = head.data;
			head = tail = null;
			size = 0;
			return val;
		}
		
		//prev : i = size-2
		Node prev = head;
		for(int i=0;i<size-2;i++) {
			prev = prev.next;
		}
		
		int val = tail.data;
		prev.next = null;
		tail = prev;
		size--;
		return val;
	}
	
	public void reverse() {
		Node prev = null;
		Node curr = tail = head;
		Node next;
		
		while(curr !=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		head = prev;
	}
	
	 static Node reverse(Node head)
	    {
	        if (head == null || head.next == null)
	            return head;
	 
	        /* reverse the rest list and put
	        the first element at the end */
	        Node rest = reverse(head.next);
	        head.next.next = head;
	 
	        /* tricky step -- see the diagram */
	        head.next = null;
	 
	        /* fix the head pointer */
	        return rest;
	    }
	
	public void deleteNthNodeFromEnd(int n) {
		
		//calculate size of linkedlist
		int size =0;
		Node temp = head;
		
		while( temp != null) {
			
			temp = temp.next;
			size++;
		}
		
		if(n == size) {
			head = head.next;
			return ;
		}
		
		int i=1;
		int idxToFind = size-n;
		Node prev = head;
		
		while(i<idxToFind) {
			prev = prev.next;
			i++;
		}
		
		prev.next = prev.next.next;
		return;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		int ch;
		
		do {
			System.out.println("\n1. add");
			System.out.println("2. Delete");
			
			System.out.println("3. display");
			System.out.println("4. Exit");
			System.out.println("Enter your choice");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1 :System.out.println("Enter element :"); 
					ll.addFirst(sc.nextInt());
					break;
					
			case 2 : System.out.println(ll.removeFirst()+" removed");
					break;
					
					
			case 3 : ll.print();
					break;
					
			case 4 : System.out.println("Exit");
					return;
					
			default : System.out.println("Invalid choice");
			
			}
		}while(ch != 4);
		
		
		}

	

}
