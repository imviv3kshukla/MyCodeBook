

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int x) {val = x;}
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int val) {this.val = val;}
    TreeNode (int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public static void main(String args[]) {
        Solution solution = new Solution();

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            }
            else {
                current.next = list2;
                list2 = list2.next;
            }  
            current = current.next;
        }
        if (list1 != null) current.next = list1;
        else current.next = list2;

        return dummyHead.next;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode current = dummyHead;

        while(current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            second.next = first;
            current.next = second;
            current = current.next.next;
        }
        return dummyHead.next;

    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()) {
            root = queue.poll();
            if(root.right != null) queue.offer(root.right);
            if(root.left != null) queue.offer(root.left);
        }
        return root.val;
    }

    public int rangeSumBST(TreeNode root, int l, int r) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            if(root.val >= l && root.val <= r) {
                sum += root.val;
            }

            if(root.val >= l && root.left != null) {
                stack.push(root.left);
            }
            if(root.val <= r && root.right != null) {
                stack.push(root.right);
            }
        }
        return sum;

//        RECURSIVE SOLUTION 

//        int sum = 0;
//        if(root == null) return sum;
//        if(root.val >= l && root.val <= r) sum += root.val;
//        if (root.val >= l) sum += rangeSumBST(root.left, l, r);         
//        if (root.val <= r) sum += rangeSumBST(root.right, l, r);
//        return sum;

    }




}