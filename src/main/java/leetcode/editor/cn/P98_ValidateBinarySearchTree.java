//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1995 👎 0


package leetcode.editor.cn;

/**
 * 98. 验证二叉搜索树
 * @author WZP
 * @date 2023-04-26 15:07:39
 */
public class P98_ValidateBinarySearchTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P98_ValidateBinarySearchTree().new Solution();
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

	boolean flag = false;

	public boolean isValidBST(TreeNode root) {
		/**
		 * 注意此题，左子树的所有节点均小于当前节点，右子树同
		 */
		return DFS(root,null,null);
	}

	/**
	 *
	 * @param root
	 * @param min 最小值节点
	 * @param max 最大值节点
	 * @return
	 */
	public boolean DFS(TreeNode root,TreeNode min,TreeNode max){
		if(root == null){
			return true;
		}

		if(min!=null && !(root.val>min.val))return false;
		if(max!=null && !(root.val<max.val))return false;


		boolean lef = DFS(root.left,min,root);
		boolean rig = DFS(root.right,root,max);

		if(lef && rig){
			return true;
		}
		return false;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}