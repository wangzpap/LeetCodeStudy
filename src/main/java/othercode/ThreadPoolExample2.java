package othercode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample2 {
    public static void main(String[] args) {
        // 创建线程池，其中参数为线程池大小
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 创建Runnable任务
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName() + " is running.");
            }
        };

        // 提交任务到线程池中执行
        for (int i = 0; i < 5; i++) {
            executorService.submit(task);
        }

        // 关闭线程池
        executorService.shutdown();
    }
}