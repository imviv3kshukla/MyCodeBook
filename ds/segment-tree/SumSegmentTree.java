import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

class Node {
    int value;
    int l;
    int r;
    Node leftNode;
    Node rightNode;
    Node (int l, int r, int value) {
        this.leftNode = null;
        this.rightNode = null;
        this.l = l;
        this.r = r;
        this.value = value;
    }
}

class SegmentTree {

    Node root;

    SegmentTree(int s, int e, List<Integer> data) {
        this.root = build(s, e, data);
    }

    public Node getRootNode() {
        return this.root;
    }

    private Node build(int s, int e, List<Integer> data) {
        if (s == e) {
            Node node = new Node(s, e, data.get(s));
            return node;
        }
        int mid = (s + e) >> 1;
        Node left = build(s, mid, data);
        Node right = build(mid+1, e, data);
        int value = left.value + right.value;
        Node node = new Node(s, e, value);
        node.leftNode = left;
        node.rightNode = right;
        return node;
    }

    public int query (Node node, int l, int r) {
        if (node.l > r || node.r < l ) {
            return 0;
        }
        if (node.l >= l && node.r <= r) {
            return node.value;
        }
        int leftValue = query(node.leftNode, l, r);
        int rightValue = query(node.rightNode, l, r);
        return leftValue + rightValue;
    }

    public void update (Node node, int x, int val) {
        if (node.l == node.r ) {
            node.value = val;
            return;
        }
        int mid = (node.l + node.r) >> 1;
        if (x >= node.l && x <= mid ) update(node.leftNode, x, val);
        else update(node.rightNode, x, val);
        node.value = node.leftNode.value + node.rightNode.value;
    }

}

public class SumSegmentTree {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayList<Integer> data = Arrays.asList(input.split(" ")).stream()
                                        .map(x -> Integer.parseInt(x))
                                        // .collect(Collectors.toList());
                                        .collect(Collectors.toCollection(ArrayList::new));

        SegmentTree tree = new SegmentTree(0, data.size() - 1, data);
        String input2 = br.readLine();
        int q = Integer.parseInt(input2);
        while (q-- > 0) {
            input = br.readLine();
            String [] queryParams = input.split(" ");
            if(queryParams[0].equals("u")) {
                int x = Integer.parseInt(queryParams[1]);
                int val = Integer.parseInt(queryParams[2]);
                tree.update(tree.getRootNode(), x-1, val);
            }
            else {
                int l = Integer.parseInt(queryParams[1]);
                int r = Integer.parseInt(queryParams[2]);
                System.out.println(tree.query(tree.getRootNode(), l-1, r-1)); 
            }
        }


    }
}
