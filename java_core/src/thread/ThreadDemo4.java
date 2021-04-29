package thread;

public class ThreadDemo4 {
    //全局变量
    private static int number = 0;
    //最大值
    private static final int maxSize = 100000;

    public static void main(String[] args) throws InterruptedException {

        //创建一个锁对象
        Object lock = new Object();

        //+10w
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++){
                    //实现加锁
                    synchronized (lock){
                        number++;
                    }
                }
            }
        });
        t1.start();

        //-10w
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    synchronized (lock){
                        number--;
                    }
                }
            }
        });
        t2.start();

        t1.join();//等待其他线程执行完
        t2.join();

        System.out.println("最终结果：" + number);
    }
}
