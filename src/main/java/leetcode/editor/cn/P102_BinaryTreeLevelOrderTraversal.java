//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1649 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉树的层序遍历
 * @author WZP
 * @date 2023-04-14 14:58:03
 */
public class P102_BinaryTreeLevelOrderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P102_BinaryTreeLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> final_list = new ArrayList<>(); // 存放每一层的list
		if(root == null){
			return final_list;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int queuesize = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			for(int i =0; i < queuesize;i++){

				TreeNode node = queue.poll();
				list.add(node.val);

				if(node.left!=null){
					queue.offer(node.left);
				}
				if(node.right!=null){
					queue.offer(node.right);
				}
			}
			final_list.add(new ArrayList<Integer>(list));// 将每一层的结果放入最终结果中
		}
		return  final_list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}