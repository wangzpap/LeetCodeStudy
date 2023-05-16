//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
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
// Related Topics 树 广度优先搜索 二叉树 👍 682 👎 0


package leetcode.editor.cn;
import java.util.*;
/**
 * 二叉树的层序遍历 II
 * @author WZP
 * @date 2023-05-11 15:12:24
 */
public class P107_BinaryTreeLevelOrderTraversalIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P107_BinaryTreeLevelOrderTraversalIi().new Solution();
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if(root == null) return result;

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);
		System.out.println(queue.size());
		while(queue.size()>0){
			int s = queue.size();
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < s; i++){
				TreeNode curNode = queue.poll();
				list.add(curNode.val);
				if(curNode.left!=null)queue.add(curNode.left);
				if(curNode.right!=null)queue.add(curNode.right);

			}
			result.add(list);
		}
		Collections.reverse(result);

		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
