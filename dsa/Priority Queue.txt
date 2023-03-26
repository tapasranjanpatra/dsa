package priorityQueue_;
import java.util.*;
import java.util.Iterator;

class Task{
	String job;
	int priority;
	
	Task(String job, int priority){
		this.job = job;
		this.priority = priority;
	}
	
	public String toString() {
		return "Job name : " + job + "\tPriority : "+ priority;
	}
}

class PriorityQueue{
	private Task[] heap;
	private int heapSize, capacity;
	
	PriorityQueue(int capacity) {
		this.capacity = capacity;
		heap  = new Task[this.capacity];
		heapSize = 0;
	}
	
	public void clear() {
		heap = new Task[capacity];
		heapSize = 0;
	}
	
	public boolean isEmpty() {
		return heapSize == 0; 
	}
	
	public boolean isFull() {
		return heapSize == capacity;
		//return heapSize == capacity-1;
	}
	
	public int size() {
		return heapSize;
	}
	
	public void insert(String job , int priority) {
		Task newJob = new Task(job , priority);
		heap[++heapSize] = newJob;
		int pos = heapSize;
		while(pos!=1 && newJob.priority > heap[pos/2].priority) {
			heap[pos] = heap[pos/2];
			pos /= 2 ;
		}
		
		heap[pos] = newJob;
	}
	
	public Task remove() {
		int parent, child;
		Task item , temp;
		if(isEmpty()) {
			System.out.println("Heap is empty");
			return null;
		}
		item = heap[1];
		temp = heap[heapSize--];
		
		parent = 1;
		child = 2;
		
		while(child <= heapSize) {
			if((child < heapSize) && (heap[child].priority <heap[child+1].priority)) {
				child++;
			}
			
			if(temp.priority >= heap[child].priority) {
				break;
			}
			
			heap[parent] = heap[child];
			parent = child;
			child *= 2;
		}
		heap[parent] = temp;
		return item;
	}
	
	public void display() {
		for(int i=0;i<size()+1;i++) {
			System.out.println(heap[i]);
		}
		
	}

	
}
public class ImplementationPriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of Priority Queue :");
		PriorityQueue pq = new PriorityQueue(sc.nextInt());
		
		char ch;
        /* Perform Priority Queue operations */
        do    
        {
            System.out.println("\nPriority Queue Operations\n");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. traverse");
            
            
 
            int choice = sc.nextInt();            
            switch (choice) 
            {
            case 1 : 
                System.out.println("Enter job name and priority");
                pq.insert(sc.next(), sc.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("\nJob removed : \n\n"+ pq.remove()); 
                break;        
            case 3 : 
            	pq.display();
            	break;
                   
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }    
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = sc.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');
	}

}
