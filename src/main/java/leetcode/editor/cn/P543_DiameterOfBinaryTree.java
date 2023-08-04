//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
//
//
// 示例 : 给定二叉树
//
//           1
//         / \
//        2   3
//       / \
//      4   5
//
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
//
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。
//
// Related Topics 树 深度优先搜索 二叉树 👍 1302 👎 0


package leetcode.editor.cn;

/**
 * 二叉树的直径
 * @author WZP
 * @date 2023-04-14 14:02:58
 */
public class P543_DiameterOfBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P543_DiameterOfBinaryTree().new Solution();
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
	int finalRes = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		int r = maxDepth(root);
		return finalRes;
	}

	int maxDepth(TreeNode root){
		if(root ==null){
			return 0;
		}

		int l = maxDepth(root.left); // 返回左节点的最大深度
		int r = maxDepth(root.right);// 返回右节点的最大深度

		// 后续遍历位置，计算当前左右节点最大深度之和
		int oneRes = l+r;// 当前节点的左右节点深度之和（直径）
		finalRes = Math.max(finalRes,oneRes); // 更新整棵树的最大直径

		return Math.max(l,r)+1;// 返回当前节点的最大深度

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}