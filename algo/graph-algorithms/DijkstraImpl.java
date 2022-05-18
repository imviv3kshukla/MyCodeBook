
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;



class Node {
    int id;
    HashMap<Node, Integer> adjlist;
    Node(int nodeId) {
        this.id = nodeId;
        adjlist = new HashMap<>();
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return id == node.id;
    }
}

class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Graph {
    HashMap<Integer, Node> graph;

    static int maxVal = (int)1e9;

    Graph() {
        graph = new HashMap<>();
    }

    public void addNode(int nodeId) {
        graph.put(nodeId, new Node(nodeId));
    }

    public void addEdge(int u, int v, int w) {
        graph.get(u).adjlist.put(graph.get(v), w);
        graph.get(v).adjlist.put(graph.get(u), w);
    }

    public HashMap<Integer, Integer> dijkstra(int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.second - p2.second);
        HashMap<Integer, Integer> distance = new HashMap<>();
        pq.add(new Pair(src, 0));
        distance.put(src, 0);
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            int u = pair.first;
            for(Map.Entry entry : graph.get(u).adjlist.entrySet()) {
                Node child = (Node)entry.getKey();
                int v = child.id;
                int w = (int) entry.getValue();
                if(!distance.containsKey(v)) distance.put(v, maxVal);
                if(distance.get(v) > distance.get(u) + w) {
                    distance.put(v, distance.get(u) + w);
                    pq.add(new Pair(v, distance.get(v)));
                }
            }

        }
        return distance;
    }

}



public class DijkstraImpl {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int nodes = Integer.parseInt(input);
        input = br.readLine();
        int edges = Integer.parseInt(input);

        Graph graph = new Graph();
        for(int i=0;i<=nodes;i++) {
            graph.addNode(i);
        }
        for(int i=0;i<edges;i++) {
            input = br.readLine();
            int u = Integer.parseInt(input.split(" ")[0]);
            int v = Integer.parseInt(input.split(" ")[1]);
            int w = Integer.parseInt(input.split(" ")[2]);
            graph.addEdge(u, v, w);
        }

        input = br.readLine();
        int src = Integer.parseInt(input);

        HashMap<Integer, Integer> distanceMap = graph.dijkstra(src);
        
        distanceMap.forEach((nodeId, distance) -> {
            System.out.println(nodeId + " : " + distance);
        });

    }
}