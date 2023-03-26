package linkedList;

import java.util.Scanner;

public class CircularLL {
	
	   public class Node{  
	        int data;  
	        Node next;  
	        public Node(int data) {  
	            this.data = data;  
	        }  
	    }  
	  
	    //Declaring head and tail pointer as null.  
	    public Node head = null;  
	    public Node tail = null;  
	  
	    //This function will add the new node at the end of the list.  
	    public void add(int data){  
	        //Create new node  
	        Node newNode = new Node(data);  
	        //Checks if the list is empty.  
	        if(head == null) {  
	             //If list is empty, both head and tail would point to new node.  
	            head = newNode;  
	            tail = newNode;  
	            newNode.next = head;  
	        }  
	        else {  
	            //tail will point to new node.  
	            tail.next = newNode;  
	            //New node will become new tail.  
	            tail = newNode;  
	            //Since, it is circular linked list tail will point to head.  
	            tail.next = head;  
	        }  
	    }  
	    
	    public void delete() {
	    	if(head == null) {
	    		System.out.println("Empty LinkedList");
	    		return;
	    	}
	    	
	    	int tempData = head.data;
	    	System.out.println(tempData+ " removed" );
	    	
	    	tail.next = head.next;
	    	
	    	head = head.next;
	    }
	  
	    //Displays all the nodes in the list  
	    public void display() {  
	        Node current = head;  
	        if(head == null) {  
	            System.out.println("List is empty");  
	        }  
	        else {  
	            System.out.println("Nodes of the circular linked list: ");  
	             do{  
	                //Prints each node by incrementing pointer.  
	                System.out.print(" "+ current.data);  
	                current = current.next;  
	            }while(current != head);  
	            System.out.println();  
	        }  
	    }  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		CircularLL ll = new CircularLL();
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
					ll.add(sc.nextInt());
					break;
					
			case 2 : ll.delete();
					break;
					
					
			case 3 : ll.display();
					break;
					
			case 4 : System.out.println("Exit");
					return;
					
			default : System.out.println("Invalid choice");
			
			}
		}while(ch != 4);

	}

}
