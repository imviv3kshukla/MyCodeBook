import java.util.Queue;

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;
}

class BinaryTree {

    public void preOrder(TreeNode node) {
        if(node == null) return;
        display(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(TreeNode node) {
        if(root != null) {
            inOrder(node.left);
            display(node);
            inOrder(node.right);
        }
    }


    public void postOrder(TreeNode node) {
        if(root != null) {
            inOrder(node.left);
            inOrder(node.right);
            display(node);
        }
    }

    public void levelOrder(TreeNode node) {
        Queue<TreeNode> queue;
        queue.add(node);
        while(!q.isEmpty()) {
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


    display(TreeNode node) {
        System.out.println(node.data + " -> ");
    }
}