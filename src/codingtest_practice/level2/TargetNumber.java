package codingtest_practice.level2;

public class TargetNumber {
    private class TreeNode {
        public int val;
        public TreeNode minus;
        public TreeNode plus;

        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode minus, TreeNode plus) {
            this.val = val;
            this.minus = minus;
            this.plus = plus;
        }
    }

    private int[] nums;

    public int solution(int[] numbers, int target){
        TreeNode curr = new TreeNode(0);
        nums = numbers;
        return dfs(curr, 0, target);
    }
    private int dfs(TreeNode curr, int depth, int target) {
        if (depth == nums.length) {
            return curr.val == target ? 1 : 0;
        }
        curr.minus = new TreeNode(curr.val - nums[depth]);
        curr.plus = new TreeNode(curr.val + nums[depth]);
        int count = 0;
        count += dfs(curr.minus, depth + 1, target);
        count += dfs(curr.plus, depth + 1, target);
        return count;
    }
}
