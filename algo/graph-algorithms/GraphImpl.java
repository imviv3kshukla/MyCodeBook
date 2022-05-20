import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// traversal  | know if is there a path from one node to another






class Node {
    int id;
    // LinkedList<Node> children;
    Node(int nodeId) {
        this.id = nodeId;
        // children = new LinkedList<>();
    }

}

class Graph {
    private HashMap<Integer, List<Integer>> graph;
    // private HashMap<Integer, Node> graph;
    Graph() {
        graph = new HashMap<>();
    }

    public void addNode(int nodeId) {
        graph.put(nodeId, new LinkedList<>());
    }

    public void addEdge(int u, int v) {
        graph.get(u).add(v);
    }

    public boolean hasPathBfs(int s, int d) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(s);
        visited.add(s);
        while(!queue.isEmpty()) {
            s = queue.poll();
            for(int child : graph.get(s)) {
                if(!visited.contains(child)) {
                    visited.add(child);
                    queue.add(child);
                }
            }
        }
        return visited.contains(d);
    }

    public boolean hashPathDfs(int s, int d) {
        HashSet<Integer> visited = new HashSet<>();
        dfs(s, visited);
        return visited.contains(d);
    }

    private void dfs(int u, HashSet<Integer> visited) {
        visited.add(u);
        for(int v : graph.get(u)) {
            if(!visited.contains(v)) {
                dfs(v, visited);
            }
        }
    }

}


public class GraphImpl {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int nodes = Integer.parseInt(input);
        Graph graph = new Graph();
        for(int i=0;i<=nodes;i++) {
            graph.addNode(i);
        }
        input = br.readLine();
        int edges = Integer.parseInt(input);
        for(int i=0; i<edges; i++) {
            input = br.readLine();
            int u = Integer.parseInt(input.split(" ")[0]);
            int v = Integer.parseInt(input.split(" ")[1]);
            graph.addEdge(u, v);
        }

        input = br.readLine();
        int src = Integer.parseInt(input.split(" ")[0]);
        int dest = Integer.parseInt(input.split(" ")[1]);
        
        boolean answerBFS = graph.hasPathBfs(src, dest);
        boolean answerDFS = graph.hashPathDfs(src, dest);
        System.out.println("has path between " + src + " and  " + dest + " : " + answerBFS);
        System.out.println("has path between " + src + " and  " + dest + " : " + answerDFS);
    }
}