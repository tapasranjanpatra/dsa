package linkedList;

import java.util.Scanner;


public class Doubly_LinkedList {

	public class Node {
		int data;
		Node next;
		Node prev;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	public static Node head;
	public static Node tail;
	public static int size;
	
	//add
	public void addFirst(int data) {
		Node newNode = new Node(data);
		size++;
		if(head == null) {
			head = tail = newNode;
			return;
		}
		
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}
	
	//addLast
	public void addLast(int data) {
		Node newNode = new Node(data);
		size++;
		if(head == null) {
			head = tail = newNode;
			return;
		}
		
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
	}
	//remove first
	public int removeFirst() {
		if(head == null) {
			System.out.println("Double linkedList is empty");
			return Integer.MIN_VALUE;
		}
		
		if(size == 1) {
			int val = head.data;
			head = tail = null;
			size--;
			return val;
		}
		
		int val = head.data;
		head = head.next;
		head.prev = null;
		size--;
		return val;
	}
	
	//remove Last
	public int removeLast() {
		if(tail == null) {
			System.out.println("Double linkedList is empty");
			return Integer.MIN_VALUE;
		}
		
		if(size == 1) {
			int val = head.data;
			head = tail = null;
			size--;
			return val;
		}
		
		//prev : i = size-2
		Node prev1 = head;
		for(int i=0;i<size-2;i++) {
			prev1 = prev1.next;
		}
		
		int val = tail.data;
		tail.prev = null;
		prev1.next = null;
		tail = prev1;
		size--;
		return val;
	}
	
	public void reverse() {
		Node curr = head;
		Node prev = null;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			curr.prev = next;
			
			prev = curr;
			curr = next;
		}
		
		head = prev;
		
	}
	
	
	//print
	 public void print() {
		 Node temp = head;
		 while(temp != null) {
			 System.out.print(temp.data+ "->");
			 temp = temp.next;
		 }
		 System.out.println("null");
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Doubly_LinkedList ll = new Doubly_LinkedList();
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
