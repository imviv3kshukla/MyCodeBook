import java.util.LinkedList;
import java.util.Queue;

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;
}

class BinaryTree {

    public void preOrder(TreeNode<Integer> node) {
        if(node == null) return;
        display(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(TreeNode<Integer> node) {
        if(node != null) {
            inOrder(node.left);
            display(node);
            inOrder(node.right);
        }
    }


    public void postOrder(TreeNode<Integer> node) {
        if(node != null) {
            inOrder(node.left);
            inOrder(node.right);
            display(node);
        }
    }

    public void levelOrder(TreeNode<Integer> node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            node = queue.poll();
            display(node);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }


    public void display(TreeNode<Integer> node) {
        System.out.println(node.data + " -> ");
    }
}