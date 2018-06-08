
// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.

import java.util.Iterator;
import java.util.LinkedList;

// This class represents a directed graph using adjacency list
// representation
class GraphTest {
    private int V;   // No. of vertices
    private LinkedList<Integer> vertex[]; //Adjacency Lists

    // Constructor
    GraphTest(int v) {
        V = v;
        vertex = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            vertex[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        vertex[v].add(w);
    }

    // prints BFS traversal from a given source s
    void BFS(int initVertex) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[initVertex] = true;
        queue.add(initVertex);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            initVertex = queue.poll();
            System.out.print(initVertex + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Integer node : vertex[initVertex]) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
        // Recur for all the vertices adjacent to this vertex
        for (Integer node : vertex[v]) {
            if (!visited[node])
                DFSUtil(node, visited);
        }
    }

    // Driver method to
    public static void main(String args[]) {
        GraphTest g = new GraphTest(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

//        g.BFS(2);
        g.DFS(2);
    }
}