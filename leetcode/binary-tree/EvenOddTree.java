
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left =left;
        this.right = right;
    }
}




public class EvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {
        boolean answer = true;
        List<List<Integer>> levels = getLevelOrder(root);

        for(int i=0;i < levels.size();i++) {
            if(i % 2 == 0) {
                for(int j = 0; j < levels.get(i).size();j++) {
                    if(levels.get(i).get(j) % 2  != 1) {
                        answer = false;
                        break;
                    }
                    if(j > 0 && levels.get(i).get(j) <= levels.get(i).get(j-1)) {
                        answer = false;
                        break;
                    }
                }
            } else {
                for(int j = 0; j < levels.get(i).size();j++) {
                    if(levels.get(i).get(j) % 2  == 1) {
                        answer = false;
                        break;
                    }
                    if(j > 0 && levels.get(i).get(j) >= levels.get(i).get(j-1)) {
                        answer = false;
                        break;
                    }
                }
            }
            if(!answer) return false;
        }
        return answer;
    }

    public List<List<Integer>> getLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if(root == null) return levels;
        int level = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            levels.add(new ArrayList<>());
            while(size-- > 0) {
                TreeNode s = queue.poll();
                levels.get(level).add(s.val);
                if(s.left != null) queue.add(s.left);
                if(s.right != null) queue.add(s.right);
            }
        }
        return levels;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        
    }
}