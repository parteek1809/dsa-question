/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        if(root == null) return zigzag;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            // List<Integer> ans = new ArrayList<>();
            LinkedList<Integer> ans = new LinkedList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.remove();
                if(flag){
                    ans.addLast(node.val);
                } else {
                    ans.addFirst(node.val);
                }
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            zigzag.add(ans);
            flag = !flag;
        }
        return zigzag;
    }
}