//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
// 
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
// 
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1049 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * @author WZP
 * @date 2023-04-14 10:49:54
 */
public class P144_BinaryTreePreorderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P144_BinaryTreePreorderTraversal().new Solution();
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
	List<Integer> list = new ArrayList<>(); // 存储遍历结果
	public List<Integer> preorderTraversal(TreeNode root) {
		traverse(root);
		return list;
	}

	void traverse(TreeNode root){

		if(root == null){
			return;
		}
		list.add(root.val); // 二叉树的前序遍历位置
		traverse(root.left);
		traverse(root.right);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}