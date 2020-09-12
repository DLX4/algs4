package pers.dlx.draft.serial;

/**
 * @program: algs4
 * @description: 多线程执行
 * @author: dlx
 * @created: 2020/08/27 22:05
 */
public class serial3 {

    private static Object shit = new Object();
    private static int count = 0;

    static class ThreadA extends Thread {

        @Override
        public void run() {
            synchronized (shit) {
                try {
                    for (int i = 0; i < 100; i++) {
                        while (count % 2 != 0)
                            shit.wait(0); // 会释放lock锁
                        System.out.print("A");
                        count++;
                        shit.notify(); // 唤醒相应线程
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    static class ThreadB extends Thread {

        @Override
        public void run() {
            synchronized (shit) {
                try {
                    for (int i = 0; i < 100; i++) {
                        while (count % 2 != 1)
                            shit.wait(0); // 会释放lock锁
                        System.out.print("B");
                        count++;
                        shit.notify(); // 唤醒相应线程
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        ThreadA a = new ThreadA();
        a.start();
        new ThreadB().start();

        a.join();
        // System.out.println(count);
    }

}