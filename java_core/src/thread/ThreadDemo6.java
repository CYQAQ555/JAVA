package thread;

public class ThreadDemo6 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：进入线程方法");
                synchronized (lock) {
                    try {
                        lock.wait();//线程休眠
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程1：执行完成");
            }
        },"t1");
        t1.start();

        Thread.sleep(1000);
        System.out.println("主线程唤醒线程1");
        synchronized (lock) {
            lock.notify();
        }

    }
}
