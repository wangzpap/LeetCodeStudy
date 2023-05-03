//给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建: 
//
// 
// 创建一个根节点，其值为 nums 中的最大值。 
// 递归地在最大值 左边 的 子数组前缀上 构建左子树。 
// 递归地在最大值 右边 的 子数组后缀上 构建右子树。 
// 
//
// 返回 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
// 
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 栈 树 数组 分治 二叉树 单调栈 👍 677 👎 0


package leetcode.editor.cn;

/**
 * 654. 最大二叉树
 * @author WZP
 * @date 2023-05-03 10:22:32
 * https://labuladong.gitee.io/algo/di-yi-zhan-da78c/shou-ba-sh-66994/dong-ge-da-172f0/#构造最大二叉树
 */
public class P654_MaximumBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P654_MaximumBinaryTree().new Solution();
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
		return BuildMaxTree(nums,0,nums.length-1); // 注意此处，为nums.length-1
    }

	/**
	 * 注意此函数构建的参数 添加start和end，而不是只有nums
	 * @param nums
	 * @param start
	 * @param end
	 * @return
	 */
	public TreeNode BuildMaxTree(int[] nums,int start,int end) {
		if(nums.length==0)return null;
		if(start>end)return null;

		// 寻找[start,end]区间最大值及索引
		int maxindex = -1;
		int maxNum = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) { // 注意此处i <= end
			int x = nums[i];
			if(x>maxNum){
				maxindex = i;
				maxNum = x;
			}
		}
		TreeNode treeNode = new TreeNode(maxNum);
		// 左右子树递归
		TreeNode left = BuildMaxTree(nums,start,maxindex-1);
		TreeNode right = BuildMaxTree(nums,maxindex+1,end);
		treeNode.left = left;
		treeNode.right = right;
		return treeNode;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
   }
}
}