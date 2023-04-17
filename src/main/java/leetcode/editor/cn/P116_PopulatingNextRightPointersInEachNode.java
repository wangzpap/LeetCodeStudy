//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 
//next 指针连接，'#' 标志着每一层的结束。
// 
//
// 
// 
//
// 示例 2: 
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
// 树中节点的数量在
// [0, 2¹² - 1] 范围内 
// -1000 <= node.val <= 1000 
// 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 983 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 * @author WZP
 * @date 2023-04-16 16:20:36
 */
public class P116_PopulatingNextRightPointersInEachNode{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P116_PopulatingNextRightPointersInEachNode().new Solution();
	 }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

	class Solution {
		public Node connect(Node root) {
			Queue<Node> queue = new LinkedList<>();
			if(root==null){  // 注意此处
				return null;
			}
			queue.offer(root);
			while (queue.size() > 0) {
				int s = queue.size();
				Node curx =  queue.peek();;
				for(int i =0;i<s;i++){

					Node cur = queue.poll();

					// 左右点链接
					if(i>0&&i<s-1){
						curx.next = cur;
						curx = cur;
					}else if(s==1){
						cur.next = null;
					}else if(i==s-1){
						curx.next = cur;
						cur.next = null;
					}
					// 链接结束
					if(cur.left!=null){
						queue.offer(cur.left);
					}
					if(cur.right!=null){
						queue.offer(cur.right);
					}
				}
			}
			return root;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)
class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}
}