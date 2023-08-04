//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 2771 👎 0


package leetcode.editor.cn;

import java.util.LinkedHashMap;

/**
 * 146. LRU 缓存
 * @author WZP
 * @date 2023-07-26 20:42:04
 */
public class P146_LruCache{
	 public static void main(String[] args) {
	 	 //测试代码
         //LRUCache solution = new P146_LruCache().new LRUCache();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();

    int s;


    public LRUCache(int capacity) {
        this.s = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int x = map.get(key);
            update(key);
            return x;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.size()<=s-1){ // 至少有一个位置

            if(map.containsKey(key)){
                map.put(key,value);
                update(key);
            }else {
                map.put(key,value);
            }
        }else {
            if(map.containsKey(key)){
                map.put(key,value);
                update(key);
            }else {
                map.remove(map.keySet().iterator().next());
                map.put(key,value);
            }
        }
    }

    public void update(int key){
        int x = map.get(key);
        map.remove(key);
        map.put(key,x);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
