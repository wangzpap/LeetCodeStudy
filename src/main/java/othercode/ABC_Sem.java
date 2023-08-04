package othercode;

import java.util.concurrent.Semaphore;

/**
 * @program: LeetCodeStudy
 * @ClassName ABC_Sem
 * @description:
 * @author: wangzp
 * @create: 2023-07-27 21:26
 * @Version 1.0
 **/
import java.util.concurrent.Semaphore;
public class ABC_Sem {

    static Semaphore semaphoreA = new Semaphore(1);
    static Semaphore semaphoreB = new Semaphore(0);
    static Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

    static class ThreadA extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreA.acquire();
                    System.out.println("A");
                    semaphoreB.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreB.acquire();
                    System.out.println("B");
                    semaphoreC.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    static class ThreadC extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphoreC.acquire();
                    System.out.println("C");
                    semaphoreA.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
