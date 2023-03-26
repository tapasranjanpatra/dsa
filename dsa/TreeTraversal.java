package dsa;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class TreeTraversal {

	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		
	}
	
	
	
	static class BinaryTree{
		//static int idx =-1;
		/*public static Node buildTree(ArrayList nodes) {
			idx++;
			if(nodes.get(idx) == -1) {
				return null;
			}
			
			Node newNode = new Node(nodes.get(idx));
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);
			
			return newNode;
		}*/
		
		Node root;
		BinaryTree(){
			root = null;
		}
		
		/*Node insertLeft(Node root, int data) {
			root.left = new Node(data);
			return root.left;
		}
		
		Node insertRight(Node root, int data) {
			root.right = new Node(data);
			return root.right;
		}*/
		
		public Node insertNode(Node root, int val) {
		     if(root == null)  
		         
		  
		     if(root.data < val)  
		         root.right = insertNode(root.right,val);  
		  
		     if(root.data > val)  
		         root.left = insertNode(root.left,val);  
		  
		     return root;  
			
		}
		
		public static void preorder(Node root) {
			if(root == null) {
				return;
			}
			
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
		
		public static void inorder(Node root) {
			if(root == null) {
				return;
			}
			
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
		
		public static void postorder(Node root) {
			if(root == null) {
				return;
			}
			
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.data+" ");
			
		}
		
		//level order traversal
		public static void levelOrder(Node root) {
			if(root == null) {
			 	 return;
			}
			
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			q.add(null);
			
			while(!q.isEmpty()) {
				Node currNode = q.remove();
				if(currNode == null) {
					System.out.println();
					if(q.isEmpty()) {
						break;
					}else {
						q.add(null);
					}
				}else {
					System.out.print(currNode.data+" ");
					if(currNode.left != null) {
						q.add(currNode.left);
					}
					
					if(currNode.right != null) {
						q.add(currNode.right);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		BinaryTree tree = new BinaryTree();
	
		/*System.out.println("Press the specific button to perform action :");
		int act = 0;
		do {
			System.out.println("1) Enter element at left");
			System.out.println("2) Preorder traversal");
			System.out.println("3) Postorder traversal");
			System.out.println("4) Level order traversal");
			
			act = sc.nextInt();
			switch(act) {
			case 1 :
				
			case 2 : tree.preorder(null)
			}
		}while(act != 5);*/
		
		
		 
	       
	        System.out.print("Enter data for root node: ");
	        tree.root = new Node(sc.nextInt());
	        System.out.println("Enter data for the left child of " + tree.root.data + ": ");
	        tree.root.left = new Node(sc.nextInt());
	        System.out.println("Enter data for the right child of " + tree.root.data + ": ");
	        tree.root.right = new Node(sc.nextInt());
	        System.out.println("Choose a tree traversal technique: ");
	        System.out.println("1. In-order Traversal");
	        System.out.println("2. Pre-order Traversal");
	        System.out.println("3. Post-order Traversal");
	        System.out.println("4. Level-order Traversal");
	        System.out.println("5. Exit");
	        int choice = sc.nextInt();
	        
	        do {
	        switch (choice) {
	        case 1:
	            System.out.println("In-order Traversal: ");
	            tree.inorder(tree.root);
	            break;
	        case 2:
	            System.out.println("Pre-order Traversal: ");
	            tree.preorder(tree.root);
	            break;
	            
	        case 3:
	        	System.out.println("Post-order Traversal: ");
	        	tree.postorder(tree.root);
	        	break;
	        	
	        case 4:
	        	System.out.println("Level-order Traversal: ");
	        	tree.levelOrder(tree.root);
	        	break;
	        	
	        case 5:
	        	return;

	        }
		
	        }while(choice !=5 );
			
	        
	}
	
}


