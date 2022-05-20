import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;



public class GraphTraversalImpl {

    private int [] level;
    private ArrayList<ArrayList<Integer>> graph;

    public void setGraph(ArrayList<ArrayList<Integer>> graph) {
        this.graph = graph;
    }

    public int[] getLevel() {
        return level;
    }

    public void bfsOnGraph(int s) {
        int nodes = graph.size();
        Queue<Integer> queue = new LinkedList<>();
        boolean [] vis = new boolean[nodes];
        level = new int[nodes];
        Arrays.fill(vis, false);
        Arrays.fill(level, 0);
        queue.add(s);
        vis[s] = true;
        while(!queue.isEmpty()) {
            Integer u = queue.poll();
            for(Integer v : graph.get(u)) {
                if(vis[v] == false) {
                    queue.add(v);
                    level[v] = level[u] + 1;
                    vis[v] = true;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        GraphTraversalImpl solution = new GraphTraversalImpl();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int nodes = Integer.parseInt(input);
        input = br.readLine();
        int edges = Integer.parseInt(input);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= nodes; i++) adj.add(new ArrayList<>());
        solution.setGraph(adj);
        for(int i=0; i<edges; i++) {
            input = br.readLine();
            int u = Integer.parseInt(input.split(" ")[0]);
            int v = Integer.parseInt(input.split(" ")[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        solution.bfsOnGraph(1);

        for (int i=1;i<solution.getLevel().length;i++) {
            System.out.println(i + " : " + solution.getLevel()[i]);;
        }
        // Arrays.asList(solution.getLevel()).forEach(x -> System.out.println(x));

    }
}