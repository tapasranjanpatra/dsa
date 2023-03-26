package queueB;

import java.util.Scanner;

import queueB.Queue_using_LinkedList.Queue;

public class QueueB {

	static class Queue{
		static int arr[];
		static int size;
		static int rear;
		static int front;
		
		Queue(int n){
			arr = new int[n];
			size = n;
			rear = -1;
			front = -1;
		}
		
		public static boolean isEmpty() {
			return rear == -1 && front == -1;
		}
		
		//full
		public static boolean isFull() {
			return (rear + 1)%size == front;
		}
		
		//add
		public static void add(int data) {
			if(isFull()) {
				System.out.println("queue is full");
				return;
			}
			// add first element
			if(front == -1) {
				front = 0;
			}
			
			rear = (rear + 1)%size ;
			arr[rear] = data;
		}
		
		//remove
		public static void remove() {
			if(isEmpty()) {
				System.out.println("empty queue");
				return;
			}
			
 			int result = arr[front];
			
			System.out.println(result + " removed");
			//last element
			if(rear == front) {
				rear = front = -1;
			}else {
				front = (front + 1)%size;
			}
			
		}
		
		//peek
		public static int peek() {
			if(isEmpty()) {
				System.out.println("empty queue");
				return -1;
			}
			
			return arr[front];
		}
		
		//traverse
		public static void traverse() {
			if(isEmpty()) {
				System.out.println("Empty Queue");
			}
			
			for(int idx =0; idx<size ; idx++) {
				System.out.print(arr[idx]+" ");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of the queue");
    	Queue q = new Queue(sc.nextInt());
		
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
                q.remove(); 
                break;        
            case 3 : 
            	q.traverse();
            	break;
            	
            case 4 :
            	System.out.println(q.peek());
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
