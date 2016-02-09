package graph;/* Authored by Kushagra on 2/9/2016. */

import java.util.ArrayList;

public class DepthFirstSearch {

    public static void main(String[] args) {
        Graph G = new Graph(4);
        G.addEdge(1, 3);
        G.addEdge(1, 2);
        G.addEdge(4, 1);
        G.addEdge(2, 4);
        G.addEdge(3, 4);

        G.printGraph();

        DFS(G, 1);
        DFS(G, 2);

    }

    private static void DFS(Graph G, int v) {

        boolean[] visited = new boolean[G.V + 1];

        DFSUtil(G, v, visited);
        System.out.println();
    }

    private static void DFSUtil(Graph G, int v, boolean[] visited) {

        visited[v] = true;
        System.out.print(v + " ");

        ArrayList<Integer> adjV = (ArrayList<Integer>) G.adj.get(v);
        for (int u : adjV) {
            if (!visited[u]) {
                DFSUtil(G, u, visited);
            }
        }

    }

}
