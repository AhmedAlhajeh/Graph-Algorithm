import java.util.*; 

public class Graph {

    private HashMap<Node, LinkedList<Node>> adjacencyMap;
    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    public void addEdgeHelper(Node a, Node b) {
        LinkedList<Node> tmp = adjacencyMap.get(a);

        if (tmp != null) {
            tmp.remove(b);
        }
        else tmp = new LinkedList<>();
        tmp.add(b);
        adjacencyMap.put(a,tmp);
    }

    public void addEdge(Node source, Node destination) {

        if (!adjacencyMap.keySet().contains(source))
            adjacencyMap.put(source, null);

        if (!adjacencyMap.keySet().contains(destination))
            adjacencyMap.put(destination, null);

        addEdgeHelper(source, destination);
        addEdgeHelper(destination, source);
        
    }
    public boolean hasEdge(Node source, Node destination) {
        return adjacencyMap.containsKey(source) && adjacencyMap.get(source).contains(destination);
    }
    
    public void resetNodesVisited()
    {
    	 for (Node n : adjacencyMap.keySet()) {
             n.unvisit();
         }
    
    }
    
    void BFS(Node node) {
    //implement the BFS code
    	    	
        if (node == null)
            return;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currentFirst = queue.removeFirst();

            if (currentFirst.isVisited())
                continue;

            currentFirst.visit();
            System.out.print(currentFirst.name + " ");

            LinkedList<Node> allNeighbors = adjacencyMap.get(currentFirst);

            if (allNeighbors == null)
                continue;

            for (Node neighbor : allNeighbors) {
                if (!neighbor.isVisited()) {
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    
    }
    
   
   public void DFS(Node node) {
    //Implement DFS
	   	
	   	node.visit();
	   	System.out.print(node.name + " ");
	   
	    LinkedList<Node> allNeighbors = adjacencyMap.get(node);
	    if (allNeighbors == null)
	    {
	    	return;
	    }
	    
	    for(Node neighbor : allNeighbors)
	    {
	    	if(!neighbor.isVisited())
	    	{
	    		DFS(neighbor);
	    	}
	    }
	   
   }
   
   public void printEdges() {
    //implement printEdges
	   
	   for (Node node : adjacencyMap.keySet()) {
	        System.out.print("The " + node.name + " has an edge towards: ");
	        for (Node neighbor : adjacencyMap.get(node)) {
	            System.out.print(neighbor.name + " ");
	        }
	        System.out.println();
	    }
   }
}