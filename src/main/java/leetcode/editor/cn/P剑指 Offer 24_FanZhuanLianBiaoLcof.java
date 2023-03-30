//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
//
// Related Topics 递归 链表 👍 565 👎 0


package leetcode.editor.cn;

/**
 * 反转链表
 * @author WZP
 * @date 2023-03-29 16:18:19
 */
class Offer24_FanZhuanLianBiaoLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new Offer24_FanZhuanLianBiaoLcof().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while(curr!=null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}