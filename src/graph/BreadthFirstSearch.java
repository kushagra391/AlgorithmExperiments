package graph;/* Authored by Kushagra on 2/9/2016. */

public class BreadthFirstSearch {

    public static void main(String[] args) {
        Graph G = new Graph(4);
        G.addEdge(1, 3);
        G.addEdge(1, 2);
        G.addEdge(4, 1);
        G.addEdge(2, 4);
        G.addEdge(3, 4);

        G.printGraph();

        
    }

}
