//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
//
// 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-
//pointer/ 
//
// 
//
// Related Topics 哈希表 链表 👍 717 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 * @author WZP
 * @date 2023-04-17 16:15:57
 */
class POffer35_FuZaLianBiaoDeFuZhiLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new POffer35_FuZaLianBiaoDeFuZhiLcof().new Solution();
	 }
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

// Definition for a Node.



	class Solution {
		public Node copyRandomList(Node head) {
			// 1) 将1->2->3  ==>  1->1'->2->2'-3->3'
			/**
			 * 遍历cur
			 */
			if(head == null) return head;
			Node cur = head;
			while(cur != null){
				// 插入新节点的必要三步
				Node newNode = new Node(cur.val);
				newNode.next = cur.next;
				cur.next = newNode;
				// END
				cur = newNode.next;
			}
			// 2）将 1，2，3的random 的给 1',2'.3' 例如：1 random 3 则 1' random 3'
			cur = head;
			while(cur!=null){
				if(cur.random == null){
					cur.next.random = null;
				}else{
					cur.next.random = cur.random.next;
				}
				cur = cur.next.next;
			}
			// 3） 将2）得到的链表拆分成两个，一个是 1，2，3 另一个是 1',2',3'
			Node head2 = head.next;
			cur = head;
			while(cur.next!=null){
				Node temp = cur.next;
				cur.next = cur.next.next;
				cur = temp;
			}
			// 4）输出 1',2',3'
			return head2;
		}
	}

//leetcode submit region end(Prohibit modification and deletion)

}