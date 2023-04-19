//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 1008 👎 0


package leetcode.editor.cn;

import javax.xml.transform.ErrorListener;

/**
 * 67. 二进制求和
 * @author WZP
 * @date 2023-04-18 19:49:57
 */
public class P67_AddBinary{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P67_AddBinary().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
		// 先把输入的这两个二进制串反转，低位放在前面，方便处理进位
		StringBuilder ab = new StringBuilder(a).reverse();
		StringBuilder bb = new StringBuilder(b).reverse();

		if(ab.length()>bb.length()){
			while (bb.length()!=ab.length()){
				bb.append('0');
			}
		}else {
			while (ab.length()!=bb.length()){
				ab.append('0');
			}
		}
		a = ab.toString();
		b = bb.toString();

		// 存储结果
		StringBuilder sb = new StringBuilder();

		int m = a.length(), n = b.length();
		System.out.println(m);
		System.out.println(n);


		int carr = 0;

		int i = 0;
		while (i < m) {

			if(a.charAt(i)=='1' && b.charAt(i)=='1' && carr == 0){
				sb.append('0');
				carr =1;
			}
			else if(a.charAt(i)=='1' && b.charAt(i)=='1' && carr == 1){
				sb.append('1');
				carr =1;
			}
			else if(a.charAt(i)=='1' && b.charAt(i)=='0' && carr == 1){
				sb.append('0');
				carr =1;
			}
			else if(a.charAt(i)=='1' && b.charAt(i)=='0' && carr == 0){
				sb.append('1');
				carr =0;
			}
			else if(a.charAt(i)=='0' && b.charAt(i)=='1' && carr == 1){
				sb.append('0');
				carr = 1;
			}
			else if(a.charAt(i)=='0' && b.charAt(i)=='1' && carr == 0){
				sb.append('1');
				carr =0;
			}
			else if(a.charAt(i)=='0' && b.charAt(i)=='0' && carr == 1){
				sb.append('1');
				carr = 0;
			}
			else if(a.charAt(i)=='0' && b.charAt(i)=='0' && carr == 0){
				sb.append('0');
				carr = 0;
			}
			i++;


		}
		if(carr == 1){
			sb.append('1');
		}
		return sb.reverse().toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}