package queueB;

import java.util.Scanner;

public class Queue_using_LinkedList {

	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	static class Queue{
		static Node head = null;
		static Node tail = null;
		
		public static boolean isEmpty() {
			return head == null && tail == null;
		}
		
		//add
		public static void add(int data) {
			Node newNode = new Node(data);
			if(head == null) {
				head = tail = newNode;
				return;
			}
			
			tail.next = newNode;
			tail = newNode;
		}
		
		//remove
		public static int remove() {
			if(isEmpty()) {
				System.out.println("empty queue");
				return -1;
			}
			
			int front = head.data;
			
			//single element
			if(tail == head) {
				tail = head = null;
			}else {
				head = head.next;
			}
			return front;
		}
		
		//peek
		public static int peek() {
			if(isEmpty()) {
				System.out.println("empty queue");
				return -1;
			}
			
			return head.data;
		}
		
		//traverse
		public static void traverse() {
			
			if(isEmpty()) {
				System.out.println("\nQueue is empty");
				return;
			}
			Node temp = head;
			while(temp != null) {
				System.out.print(temp.data + "->");
				temp = temp.next;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue q = new Queue();
		
		char ch;
       
        do    
        {
            System.out.println("\nQueue Operations\n");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. traverse");
            System.out.println("4. peek");
            System.out.println("5. Exit");
            
            
 
            int choice = sc.nextInt();            
            switch (choice) 
            {
            case 1 : 
                System.out.println("Enter element");
                q.add(sc.nextInt());                     
                break;                          
            case 2 : 
                System.out.println(q.remove() + " removed from the queue"); 
                break;        
            case 3 : 
            	q.traverse();
            	break;
            	
            case 4 :
            	q.peek();
            	break;
            case 5 :
            	System.out.println("\nExit");
            	return;
                   
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }    
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = sc.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');
		
		}
		
	}


