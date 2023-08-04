package othercode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCodeStudy
 * @ClassName ABC_sync
 * @description: 面试题
 * @author: wangzp
 * @create: 2023-07-27 20:38
 * @Version 1.0
 **/
public class ABC_sync {
    public static void main(String[] args) throws InterruptedException {
            new MyThreadA().start();
            new MyThreadB().start();
            new MyThreadC().start();

    }

    static Lock lock = new ReentrantLock();
    static int state = 0;  //通过state的值来确定是否打印

    static class MyThreadA extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10;  ) {

                try {
                    lock.lock();
                    while (state % 3 ==0){ // 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        System.out.println("A,"+state);
                        state++;
                        i++;
                    }
                }finally {
                    lock.unlock(); // unlock()操作必须放在finally块中
                }
            }

        }
    }
    static class MyThreadB extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10;) {

                try {
                    lock.lock();
                    while (state % 3 ==1){
                        System.out.println("B,"+state);
                        state++;
                        i++;
                    }

                }finally {
                    lock.unlock();
                }
            }
        }
    }
    static class MyThreadC extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10;  ) {

                try {
                    lock.lock();
                    while (state % 3 ==2){
                        System.out.println("C,"+state);
                        state++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
