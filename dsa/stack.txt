package StackB;
import java.util.*;

class Stack{
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX];
	
	boolean isEmpty() {
		return (top < 0);
	}
	
	Stack(){
		top = -1;
	}
	
	boolean push(int x) {
		if(top >= (MAX - 1 )) {
			System.out.println("Stack overflow");
			return false;
		}else {
			a[++top] = x;
			System.out.println(x + " Pushed into stack");
			return true;
		}
	}
	
	int pop() {
		if(top<0) {
			System.out.println("Stack underflow");
			return 0;
		}else {
			int x = a[top--];
			return x;
		}
	}
	
	int peek() {
		if(isEmpty()) {
			System.out.println("Stack underflow");
			return 0;
		}else {
			int x = a[top];
			return x;
		}
	}
	
	void print() {
		if(isEmpty()) {
			System.out.println("No element present");
		}
		for(int i=top;i>-1;i--) {
			System.out.println(" "+ a[i]);
		}
	}
}

public class Implementation {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack();
		Scanner sc = new Scanner(System.in);
		int ch , val;
		char ex;
		
		do {
			System.out.println("1)Push in stack \n2)Pop from stack \n3)Top element in stack \n4)Display stack\n5)exit\n");
			System.out.println("Enter choice : ");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1 : System.out.println("Enter value :");
					 val = sc.nextInt();
					 s.push(val);
					 break;
			case 2 : System.out.println("poped element : "+ s.pop()); break;
			case 3 : System.out.println("Top element : "+ s.peek()); break;
			case 4 : s.print(); break;
			case 5 : System.out.println("Exit"); return;
			default : System.out.println("Invalid choice");
			}
			
			 System.out.println("\nDo you want to continue (Type y or n) \n");
	         ex = sc.next().charAt(0); 
		}while(ex == 'Y'|| ex == 'y');
	}

}
