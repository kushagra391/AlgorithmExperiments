package graph;/* Authored by Kushagra on 2/9/2016. */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    int V;
    Map<Integer, List<Integer>> adj;

    Graph(int V) {
        this.V = V;
        this.adj = new HashMap<>();
    }

    void addEdge(int u, int v) {
        if (adj.keySet().contains(u)) {
            ArrayList<Integer> adj_u = (ArrayList<Integer>) adj.get(u);
            adj_u.add(v);
        }
        else {
            List<Integer> adj_u = new ArrayList<>();
            adj.put(u, adj_u);
            adj_u.add(v);
        }
    }

    void printGraph() {

        for (int v : adj.keySet()) {
            System.out.print(v + " ->");
            ArrayList<Integer> adjV = (ArrayList<Integer>) adj.get(v);

            for (int u : adjV) {
                System.out.print(" " + u);
            }

            System.out.println();
        }

    }



}
