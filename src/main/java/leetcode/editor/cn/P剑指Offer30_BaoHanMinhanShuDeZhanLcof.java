//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
//
// Related Topics 栈 设计 👍 477 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 包含min函数的栈
 * @author WZP
 * @date 2023-03-29 15:27:48
 */
class Offer30_BaoHanMinhanShuDeZhanLcof{
	 public static void main(String[] args) {
	 	 //测试代码
         MinStack solution = new Offer30_BaoHanMinhanShuDeZhanLcof().new MinStack();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    List<Integer> list;

    /** initialize your data structure here. */
    public MinStack() {
        list = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        list.add(x);
    }
    
    public void pop() {
        list.remove(list.size() - 1);
    }
    
    public int top() {
        int re = list.get(list.size() - 1);
        return re;
    }
    
    public int min() {
        int result = list.get(list.size() - 1);
        for(int i = 0; i < list.size();i++){
            if (result>list.get(i)){
                result = list.get(i);
            }
        }
        return result;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}