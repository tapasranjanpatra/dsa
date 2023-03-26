package dsa;

import java.util.*;



public class DijkstraAlgorithm {
    
    private int[] dist;
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;
    private int V;
    List<List<Node>> adj;
    
    public DijkstraAlgorithm(int V) {
        this.V = V;
        dist = new int[V];
        settled = new HashSet<>();
        pq = new PriorityQueue<>(V, new Node());
    }
    
    public void dijkstra(List<List<Node>> adj, int src) {
        this.adj = adj;
        
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        pq.add(new Node(src, 0));
        dist[src] = 0;
        
        while (settled.size() != V) {
            int u = pq.remove().node;
            settled.add(u);
            e_Neighbours(u);
        }
    }
    
    private void e_Neighbours(int u) {
        int edgeDistance = -1;
        int newDistance = -1;
        
        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);
            
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;
                
                if (newDistance < dist[v.node]) {
                    dist[v.node] = newDistance;
                }
                
                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int V = scanner.nextInt();
        
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<>();
            adj.add(item);
        }
        
        System.out.println("Enter the edges between the vertices: ");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                int edge = scanner.nextInt();
                if (edge != -1) {
                    adj.get(i).add(new Node(j, edge));
                }
            }
        }
        
        System.out.println("Enter the source vertex: ");
        int src = scanner.nextInt();
        
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(V);
        dijkstraAlgorithm.dijkstra(adj, src);
        
        System.out.println("The shortest distances from the source vertex " + src + " are: ");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + dijkstraAlgorithm.dist[i]);
        }
    }
}

class Node implements Comparator<Node> {
    public int node;
    public int cost;
    
    public Node() {
    }
    
    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    
    @Override
    public int compare(Node node1, Node node2) {
        if (node1.cost < node2.cost) {
            return -1;
        }
        
        if (node1.cost > node2.cost) {
            return 1;
        }
        
        return 0;
    }
}
