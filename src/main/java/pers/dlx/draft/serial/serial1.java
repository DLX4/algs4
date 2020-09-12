package pers.dlx.draft.serial;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: algs4
 * @description: 多线程执行
 * @author: dlx
 * @created: 2020/08/27 22:05
 */
public class serial1 {

    private static Lock lock = new ReentrantLock();
    private static int count = 0;
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    static class ThreadA extends Thread {

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 0)
                        A.await(1, TimeUnit.SECONDS); // 会释放lock锁
                    System.out.print("A");
                    count++;
                    B.signal(); // 唤醒相应线程
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    static class ThreadB extends Thread {

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 1)
                        B.await(1, TimeUnit.SECONDS);
                    System.out.print("B");
                    count++;
                    C.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    static class ThreadC extends Thread {

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 2)
                        C.await(1, TimeUnit.SECONDS);
                    System.out.println("C");
                    count++;
                    A.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new ThreadA().start();
        new ThreadB().start();
        ThreadC threadC = new ThreadC();
        threadC.start();

        threadC.join();
        System.out.println(count);
    }

}