class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return findTargetHelper(root, k, set);
    }
    
    private boolean findTargetHelper(TreeNode node, int k, HashSet<Integer> set) {
        if (node == null) {
            return false;
        }
        
        int complement = k - node.val;
        
        if (set.contains(complement)) {
            return true;
        }
        
        set.add(node.val);
        
        return findTargetHelper(node.left, k, set) || findTargetHelper(node.right, k, set);
    }
}
