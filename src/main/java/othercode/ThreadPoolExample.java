package othercode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {

    public static void main(String[] args) {
        // 创建一个线程池，其中包含5个线程
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i =0; i<3;i++)
        // 提交一个任务给线程池执行
        executorService.submit(() -> {
            System.out.println("线程开始执行");
            // TODO: 执行需要执行的代码
            System.out.println("线程执行结束");

        });

        // 关闭线程池
        executorService.shutdown();
    }
}

