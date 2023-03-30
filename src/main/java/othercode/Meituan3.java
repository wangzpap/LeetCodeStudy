package othercode;

import java.util.Scanner;

public class Meituan3 {

    static int[] capacity; // 背包容量
    static int result_sum;
    static int num = 5; // 物品数量
    static int[] weight;// （下标1开始）前5件物品的重量
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        num =  scanner.nextInt();
        result_sum =  scanner.nextInt();
        weight = new int[num+1];
        capacity = new int[result_sum+1];
        // 输入第二行
        for(int i=1;i<num+1;i++){
            weight[i] = scanner.nextInt();
        }
        // 输出第三行
        for(int i=1;i<result_sum+1;i++){
            capacity[i] = scanner.nextInt();
        }
        // 平方
        for (int i = 1; i < num+1; i++){
            weight[i] = weight[i]*weight[i];
        }
        // 输出答案
        for(int i=1; i < result_sum+1; i++){
            System.out.print(getMax(num,capacity[i])+" ");
        }
    }
    public static int getMax(int i,int w){
        if(i==0||w==0) return 0;// 装入前0件物品/容量为0时的最大价值肯定为0
        if(w<weight[i]) return getMax(i-1,w);// 剩余容量装不下第i件物品
        else {
            // 如果能装入，则判断装入后价值大，还是不装入价值大
            return Math.max( getMax(i-1,w-weight[i])+1,getMax(i-1,w) );
        }
    }
}
