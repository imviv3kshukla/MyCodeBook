import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int val;
    Node left;
    Node right;
    Node() {}
    Node(int val) {this.val = val;}
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class BinaryTree {
    Node root;

    public Node getRoot() {
        return root;
    }

    private int getBBTHeight(Node node) {
        if(node == null) return 0;
        int lH = getBBTHeight(node.left);
        if(lH == -1) return -1;
        int rH = getBBTHeight(node.right);
        if(rH == -1) return -1;
        if(Math.abs(lH - rH) > 1) return -1;
        return Math.max(lH, rH) + 1;
    }

    public boolean checkBalancedBinaryTree() {
        // BBT is binary tree in which height of every left subtree and right subtree < 2
        return getBBTHeight(this.root) != -1;
    }

    private int getDiameter(Node node, int[] diameter) {
        if(node == null) return 0;
        int lH = getDiameter(node.left, diameter);
        int rH = getDiameter(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lH+rH+1);
        return lH + rH + 1;
    }

    public int getDiameterOfTree() {
        // longest distance between 2 nodes
        int [] diameter = new int[1];
        getDiameter(this.root, diameter);
        return diameter[0];
    }

    private int maximumPathSum(Node node, int [] maxpath) {
        if(node == null) return 0;
        int lPathSum = maximumPathSum(node.left, maxpath);
        int rPathSum = maximumPathSum(node.right, maxpath);
        int pathSum = Math.max(0, lPathSum) + Math.max(0, rPathSum) + node.val;
        maxpath[0] = Math.max(maxpath[0], pathSum);
        return pathSum;
    }

    public int maximumPathSum() {
        int [] maxpath = new int[1]; // cannot take variable as cannot pass as reference
        maxpath[0] = Integer.MIN_VALUE;
        maximumPathSum(this.root, maxpath);
        return maxpath[0];
    }

    public static boolean identicalTree(Node root1, Node root2) {
        if(root1 == null && root2 == null) return true;
        boolean left = identicalTree(root1.left, root2.left);
        boolean right = identicalTree(root1.right, root2.right);
        if(left && right && root1 != null && root2 != null && root1.val == root2.val) {
            return true;
        }
        return false;
    }

    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            while(size-- > 0) {
                Node node = queue.poll();
                currLevel.add(node.val);
                if(leftToRight) {
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
                else {
                    if(node.right != null) queue.add(node.right);
                    if(node.left != null) queue.add(node.left);
                }
            }
            leftToRight = !leftToRight;
            result.add(currLevel);
        }
        return result;
    }

    private boolean isLeaf(Node node) {
        if(node == null) return false;
        if(node.left == null && node.right == null) return true;
        return false;
    }

    private void addLeftBoundary(Node node, List<Integer> result) {
        Node curr = node.left;
        while(curr != null) {
            if(isLeaf(curr) == false) result.add(curr.val);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    private void addLeaves(Node node, List<Integer> result) {
        if(node == null) return;
        if(isLeaf(node)) result.add(node.val);
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    private void addRightBoundary(Node node, List<Integer> result) {
        Node curr = node.right;
        while(curr != null) {
            if(isLeaf(curr) == false) result.add(curr.val);
            if(node.right != null) curr = curr.right;
            else curr = curr.left;
        }
    }

    public List<Integer> printBoundary() {
        List<Integer> result = new ArrayList<>();
        if(isLeaf(this.root) == false) result.add(this.root.val);
        addLeftBoundary(this.root, result);
        addLeaves(this.root, result);
        addRightBoundary(this.root, result);
        return result;
    }

}


public class BinaryTreeImpl {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
    }
}