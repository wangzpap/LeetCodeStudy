//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2401 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 合并 K 个升序链表
 * @author WZP
 * @date 2023-04-07 17:29:40
 */
public class P23_MergeKSortedLists{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P23_MergeKSortedLists().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

		if(lists.length==0)return null;

		// 创建一个优先队列、最小堆
		PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		// 将 k 个链表的头结点加入最小堆
		for (ListNode node : lists) {
			if(node!=null)
			queue.add(node);
		}
		ListNode newNode = new ListNode();
		ListNode curNode = newNode;
		while (queue.size()>0){
			// 获取最小节点，接到结果链表中
			ListNode node = queue.poll();
			curNode.next = node;
			if(node.next!=null){
				queue.add(node.next);
			}
			// curNode 指针不断前进
			curNode = curNode.next;
		}
		return newNode.next;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}