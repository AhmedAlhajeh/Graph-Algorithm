import java.util.*; 
public class Test {
    public static void main(String[] args) {

        Graph graph = new Graph();
        Node a = new Node(0, "Jack");
        Node b = new Node(1, "James");
        Node c = new Node(2, "Nadia");
        Node d = new Node(3, "Jessica");
        Node e = new Node(4, "Leo");

        graph.addEdge(a,d);
        graph.addEdge(a,b);
        graph.addEdge(a,c);
        graph.addEdge(c,d);
        graph.printEdges();
        graph.BFS(b);
        graph.resetNodesVisited();
        graph.DFS(a);

    }
}