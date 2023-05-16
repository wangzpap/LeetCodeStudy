//请你设计并实现一个能够对其中的值进行跟踪的数据结构，并支持对频率相关查询进行应答。 
//
// 实现 FrequencyTracker 类： 
//
// 
// FrequencyTracker()：使用一个空数组初始化 FrequencyTracker 对象。 
// void add(int number)：添加一个 number 到数据结构中。 
// void deleteOne(int number)：从数据结构中删除一个 number 。数据结构 可能不包含 number ，在这种情况下不删除任何内
//容。 
// bool hasFrequency(int frequency): 如果数据结构中存在出现 frequency 次的数字，则返回 true，否则返回 
//false。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["FrequencyTracker", "add", "add", "hasFrequency"]
//[[], [3], [3], [2]]
//输出
//[null, null, null, true]
//
//解释
//FrequencyTracker frequencyTracker = new FrequencyTracker();
//frequencyTracker.add(3); // 数据结构现在包含 [3]
//frequencyTracker.add(3); // 数据结构现在包含 [3, 3]
//frequencyTracker.hasFrequency(2); // 返回 true ，因为 3 出现 2 次
// 
//
// 示例 2： 
//
// 
//输入
//["FrequencyTracker", "add", "deleteOne", "hasFrequency"]
//[[], [1], [1], [1]]
//输出
//[null, null, null, false]
//
//解释
//FrequencyTracker frequencyTracker = new FrequencyTracker();
//frequencyTracker.add(1); // 数据结构现在包含 [1]
//frequencyTracker.deleteOne(1); // 数据结构现在为空 []
//frequencyTracker.hasFrequency(1); // 返回 false ，因为数据结构为空
// 
//
// 示例 3： 
//
// 
//输入
//["FrequencyTracker", "hasFrequency", "add", "hasFrequency"]
//[[], [2], [3], [1]]
//输出
//[null, false, null, true]
//
//解释
//FrequencyTracker frequencyTracker = new FrequencyTracker();
//frequencyTracker.hasFrequency(2); // 返回 false ，因为数据结构为空
//frequencyTracker.add(3); // 数据结构现在包含 [3]
//frequencyTracker.hasFrequency(1); // 返回 true ，因为 3 出现 1 次
// 
//
// 
//
// 提示： 
//
// 
// 1 <= number <= 10⁵ 
// 1 <= frequency <= 10⁵ 
// 最多调用 add、deleteOne 和 hasFrequency 共计 2 * 10⁵ 次 
// 
//
// 👍 4 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 频率跟踪器
 * @author WZP
 * @date 2023-05-08 15:40:57
 */
public class P6417_FrequencyTracker{
	 public static void main(String[] args) {
	 	 //测试代码
         FrequencyTracker solution = new P6417_FrequencyTracker().new FrequencyTracker();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class FrequencyTracker {

    Map<Integer,Integer> map_int_fre;
    Map<Integer,Integer> map_fre_num;



    public FrequencyTracker() {
        map_int_fre = new HashMap<>(); // 每个数的频率
        map_fre_num = new HashMap<>(); // 每个频率的个数
    }
    
    public void add(int number) {
        // 如果这个数已经出现过
        if(map_int_fre.containsKey(number)){

            int old_fre = map_int_fre.get(number);
            // 当前这个数的频率加一
            map_int_fre.put(number,old_fre+1);
            // 之前的频率的个数减一
            if(map_fre_num.get(old_fre)-1==0){
                map_fre_num.remove(old_fre);
            }else {
                map_fre_num.put(old_fre,map_fre_num.get(old_fre)-1);
            }
            // 现在的频率的个数加一
            map_fre_num.put(old_fre+1,map_fre_num.getOrDefault(old_fre+1,0)+1);

        }
        // 如果这个数没有出现过
        else {
            map_int_fre.put(number,1); // 这个数的频率为1
            map_fre_num.put(1,map_fre_num.getOrDefault(1,0)+1); // 频率为1的个数加一
        }
    }
    
    public void deleteOne(int number) {
        // 这个数存在过
        if(map_int_fre.containsKey(number)){
            int old = map_int_fre.get(number);

            // 当前这个数的频率减一
            if(old-1==0)map_int_fre.remove(number);
            else {
                map_int_fre.put(number,old-1);
            }
            // 之前的频率的个数减一
            if(map_fre_num.get(old)-1==0){
                map_fre_num.remove(old);
            }else {
                map_fre_num.put(old,map_fre_num.get(old)-1);
            }
            // 现在的频率的个数加一
            if(old-1>0)
            {
                map_fre_num.put(old-1, map_fre_num.getOrDefault(old-1,0)+1);
            }
        }
        // 没存在过则不做任何操作

    }
    
    public boolean hasFrequency(int frequency) {
       int n = map_fre_num.getOrDefault(frequency,0);
       if(n>=1){
           return true;
       }
       return false;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
