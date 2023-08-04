package WrittenTest;

import leetcode.editor.cn.ListNode;

/**
 * @program: LeetCodeStudy
 * @ClassName Main2023080302
 * @description:
 * @author: wangzp
 * @create: 2023-08-03 21:08
 * @Version 1.0
 **/
public class Main2023080302 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        head1.next = head2;head2.next = head3;

        ListNode head11 = new ListNode(4);
        ListNode head21 = new ListNode(5);
        ListNode head31 = new ListNode(6);
        head11.next = head21;head21.next = head31;
        ListNode cha = cha(head1, head11);
        System.out.println(cha.val);
        System.out.println(cha.next.val);
        System.out.println(cha.next.next.val);

    }

    static ListNode cha(ListNode head1, ListNode head2){
        StringBuilder h1 = new StringBuilder();
        StringBuilder h2 = new StringBuilder();
        if(head1!=null){
            while (head1!=null){
                h1.append(head1.val);
                head1 = head1.next;
            }
        }
        if(head2!=null){
            while (head2!=null){
                h2.append(head2.val);
                head2 = head2.next;
            }
        }
        int x = Math.abs(Integer.valueOf(h1.toString()) - Integer.valueOf(h2.toString()));
        String s = String.valueOf(x);
        ListNode newNode = new ListNode();
        ListNode cur = newNode;
        for (char c : s.toCharArray()) {
            cur.val = Integer.valueOf(String.valueOf(c));
            cur.next = new ListNode();
            cur = cur.next;
        }
        return newNode;
    }

}





