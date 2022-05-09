import java.io.BufferedReader;

class UnionFind {
    private int [] parent;
    private int [] size;
    int groups;

    UnionFind(int n) {
        initialize(n);
    }

    private void initialize(int n) {
        parent = new int[n+1];
        groups = 0;
        for(int i=1;i<=n;i++) {
            parent[i] = i;
            size[i] = 1;
            groups++;
        }
    }

    public void union1(int x, int y) {
        int rootX = root(x);
        int rootY = root(y);
        if(rootX == rootY) return;

        if(size[rootX] >= size[rootY]) {
            parent[rootY] = parent[rootX];
            size[rootX] += size[rootY];
        }
        else {
            parent[rootX] = parent[rootY];
            size[rootY] += size[rootX];
        }
        groups--;

    }

    public int root(int x) {
        while(parent[x] != x) {
            x = parent[parent[x]];
        }
        return x;
    }

    public boolean find(int x, int y) {
        int rootX = root(x);
        int rootY = root(y);
        if(rootX == rootY) return true;
        return false;
    }

    public int groups() {
        return groups;
    }

}



public class DSUImpl {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        UnionFind dsu = new UnionFind(n);
        input = br.readLine();
    }
}