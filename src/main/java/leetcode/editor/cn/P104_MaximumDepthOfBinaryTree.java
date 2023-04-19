//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1574 👎 0


package leetcode.editor.cn;

/**
 * 二叉树的最大深度
 * @author WZP
 * @date 2023-04-14 10:29:32
 */
public class P104_MaximumDepthOfBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
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
//    public int maxDepth(TreeNode root) {
//		if(root == null) return 0;
//
//		return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
//    }

	int maxDepth = 0;
	int depth = 1;
	public int maxDepth(TreeNode root) {
		traverse(root);
		System.out.println(depth);
		return maxDepth;
	}

	public void traverse(TreeNode root){
		depth++;
		if(root == null) {
			maxDepth = Math.max(maxDepth,depth);
			System.out.println(depth);
			return;
		}

		traverse(root.left);
		traverse(root.right);
		depth--;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}