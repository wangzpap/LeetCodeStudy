//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-
//tree/ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 237 👎 0


package leetcode.editor.cn;

/**
 * 二叉树的深度
 * @author WZP
 * @date 2023-04-14 14:05:52
 */
class Offer55I_ErChaShuDeShenDuLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new Offer55I_ErChaShuDeShenDuLcof().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	/**
	 * 方式一
	 */
//    public int maxDepth(TreeNode root) {
//		if(root == null){
//			return 0;
//		}
//		int i = maxDepth(root.left);
//		int l = maxDepth(root.right);
//		return Math.max(i,l)+1;
//    }
	/**
	 * 方式二
	 */

//	int max_depth = 0;
//
//    public int maxDepth(TreeNode root) {
//		traverse(root,0);
//		return max_depth;
//    }
//
//	void traverse(TreeNode root,int deepth){
//		if(root == null){
//			return;
//		}
//		deepth++;
//		max_depth = Math.max(max_depth, deepth);
//		traverse(root.left,deepth);
//		traverse(root.right,deepth);
//		deepth--;
//	}

	/**
	 * 方式三
	 */

	int max_depth = 0;
	int depth = 0;

	public int maxDepth(TreeNode root) {
		traverse(root);
		return max_depth;
	}

	void traverse(TreeNode root){
		if(root == null){
			return;
		}
		depth++;
		max_depth = Math.max(max_depth, depth);
		traverse(root.left);
		traverse(root.right);
		depth--;
	}



}
//leetcode submit region end(Prohibit modification and deletion)

}