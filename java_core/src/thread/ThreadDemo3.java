package thread;

import java.util.Random;

public class ThreadDemo3 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("开始起跑：" + Thread.currentThread().getName());
                try {
                    int num = 1 + new Random().nextInt(5);
                    Thread.sleep(num * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("到终点了：" + Thread.currentThread().getName());
            }
        };

        ThreadGroup group = new ThreadGroup("百米赛跑一组");

        Thread t1 = new Thread(group, runnable, "张三");
        Thread t2 = new Thread(group, runnable, "李四");
        t1.start();
        t2.start();

        group.list();

        // 等待所有人员到达终点
        while (group.activeCount() != 0) {
        }

        System.out.println("宣布成绩");
    }
}
