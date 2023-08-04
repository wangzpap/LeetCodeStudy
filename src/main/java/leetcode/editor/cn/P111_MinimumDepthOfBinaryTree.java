//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1027 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度
 * @author WZP
 * @date 2023-07-06 10:38:08
 */
public class P111_MinimumDepthOfBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P111_MinimumDepthOfBinaryTree().new Solution();
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
	/**
	 * 函数 minDepth 接受一个二叉树的根节点 root 作为参数，并返回树的最小深度。
	 * @param root
	 * @return
	 */
    public int minDepth(TreeNode root) {
		// 边界条件：根节点为空直接返回
		if(root==null)return 0;

		int deep = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		deep++;

		while (!queue.isEmpty()){
			int qsize = queue.size();
			for (int i = 0; i < qsize; i++) {// 遍历下一层的每个节点
				TreeNode cur = queue.poll();
				// 找到第一个叶子节点，其深度即为答案
				if(cur.left==null&&cur.right==null){// 判断是否为叶子节点
					return deep;
				}

				if(cur.left!=null){
					queue.add(cur.left);
				}
				if(cur.right!=null){
					queue.add(cur.right);
				}
			}
			deep++; // 每一层的深度 + 1
		}
		return deep;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
