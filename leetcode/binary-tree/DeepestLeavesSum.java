import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/deepest-leaves-sum/


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DeepestLeavesSum {


    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<Integer, List<TreeNode>> levelMap = new HashMap<>();
        q.add(root);
        int level = 1;
        int nextLevelNodeCount = 0;
        levelMap.put(level, Arrays.asList(root));
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            levelMap.get(level).add(curr);
            nextLevelNodeCount--;
            if(nextLevelNodeCount == 0) {
                level++;
                levelMap.put(level, new ArrayList<>());
            }
            if(curr.left != null) {
                q.add(curr.left);
                nextLevelNodeCount++;
            }
            if(curr.right != null) {
                q.add(curr.right);
                nextLevelNodeCount++;
            }
        }
        int lastLevel = level-1;
        int result = levelMap.get(lastLevel)
                        .stream()
                        .mapToInt(x -> x.val)
                        .sum();
        return result;
    }   

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
    }
}