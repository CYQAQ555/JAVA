package thread;

public class ThreadDemo1 {
    public static void main(String[] args) {
        // 创建线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
//                // 业务代码
//                try {
//                    // 让程序等待一定的时间
//                    Thread.sleep(60 * 60 * 1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("线程名："+Thread.currentThread().getName());
            }
        });
        // 启动线程
        thread.start();
    }
}