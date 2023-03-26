package dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;





public class GraphTraversal {
	

	static class Edge{
		int src;
		int dest;
		int wt;
		
		public Edge(int s, int d, int w) {
			this.src = s;
			this.dest = d;
			this.wt = w;
		}
	}
	
	static void createGraph(ArrayList<Edge> graph[]) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
			
		}
		
		for(int i=0;i<graph.length;i++) {
			System.out.println("Enter number of edges for "+i);
			int e = sc.nextInt();
			for(int j =0;j<e;j++) {
				System.out.println("Enter source , destination , weight");
				int src = sc.nextInt();
				int dest = sc.nextInt();
				int wt = sc.nextInt();
				graph[i].add(new Edge(src, dest, wt));
			}
		}
		
		
		
	}
	
	
	public static void bfs(ArrayList<Edge>[] graph, int start) { //O(V+E)
		Queue<Integer> q = new LinkedList<>();
		boolean vis[] = new boolean[graph.length+1];
		q.add(start); // source = 0
		try {
		while(!q.isEmpty()) {
			int curr = q.remove();
			
			if(!vis[curr]) {  // visit curr
				System.out.print(curr+" ");
				vis[curr] = true;
				for(int i =start; i<graph[curr].size(); i++) {
					Edge e = graph[curr].get(i);
					q.add(e.dest);
				}
			}
		}
		
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println ("Array Index is Out Of Bounds");
		}
	}
	
	
	public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
		//visit
		System.out.print(curr+" ");
		vis[curr] = true;
		
		for(int i =0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if(!vis[e.dest]) {
				dfs(graph, e.dest, vis);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices :");
		int v = sc.nextInt();
		
		ArrayList<Edge> graph[] = new ArrayList[v];
		createGraph(graph);

		int choice;
		System.out.println("1. Breadth first search (bfs)");
		System.out.println("2. Depth first search (dfs)");
		System.out.println("3. Exit");
		
		do {
			System.out.println("\nEnter your choice:");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1 : 
				System.out.println("Enter starting point:");
				bfs(graph, sc.nextInt());
					 break;
					 
			case 2 : dfs(graph, 0 , new boolean[v+1]);
					 break;
					 
			case 3 : return;
			
			default : System.out.println("Invalid input");
			}
			
		}while(choice != 3);
		
	}

}
