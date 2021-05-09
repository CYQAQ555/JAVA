package thread;
//死锁
public class ThreadDemo5 {
    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    System.out.println("线程1：得到了锁A");
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1：等待获取锁B");
                    synchronized (lockB) {
                        System.out.println("线程1：得到了锁B");
                    }
                }
            }
        },"t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB){
                    System.out.println("线程2：获取到了锁B");
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2：等待获取锁A");
                    synchronized (lockA) {
                        System.out.println("线程2：获取到锁B");
                    }
                }
            }
        },"t2");
        t2.start();
    }
}
