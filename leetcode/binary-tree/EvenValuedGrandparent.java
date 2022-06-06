// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/




class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int data) {this.val = data;}
    TreeNode (int data, TreeNode left, TreeNode right) {
        this.val = data;
        this.left = left;
        this.right = right;
    }
}




public class EvenValuedGrandparent {

    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root, false, false);
    }

    public int sumEvenGrandparent(TreeNode root, boolean isGrandParentEven, boolean isParentEven) {
        int selfVal = 0;
        if(root == null) return 0;
        if(isGrandParentEven) selfVal = root.val;
        int leftSum = sumEvenGrandparent(root.left, isParentEven, root.val%2 == 0);
        int rightSum = sumEvenGrandparent(root.right, isParentEven, root.val%2 == 0);
        return selfVal + leftSum + rightSum;
    }
    
    public static void main(String args[]) {
        
    }
}