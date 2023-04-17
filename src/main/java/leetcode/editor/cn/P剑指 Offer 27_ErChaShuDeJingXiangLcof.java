//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
// 4 / \ 2 7 / \ / \ 1 3 6 9 镜像输出： 
//
// 4 / \ 7 2 / \ / \ 9 6 3 1 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 350 👎 0


package leetcode.editor.cn;

/**
 * 二叉树的镜像
 * @author WZP
 * @date 2023-04-16 15:30:30
 */
class POffer27_ErChaShuDeJingXiangLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new POffer27_ErChaShuDeJingXiangLcof().new Solution();
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
	public TreeNode mirrorTree(TreeNode root) {
		traverse(root);
		return root;

	}
	// DFS递归遍历法
	void traverse(TreeNode root){
		if(root==null)return;

		// 前序位置，翻转
		TreeNode r = root.left;
		root.left = root.right;
		root.right = r;

		// 递归遍历左右节点
		traverse(root.left);
		traverse(root.right);


	}
}
//leetcode submit region end(Prohibit modification and deletion)

}