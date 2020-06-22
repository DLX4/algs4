package pers.dlx.draft.printabc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序，开启三个线程，
 * 这三个线程的 ID 分别是 A、B 和 C，每个线程把自己的 ID 在屏幕上打印 10 遍，
 * 要求输出结果必须按 ABC 的顺序显示，如 ABCABCABC... 依次递推
 */
public class PrintABC {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        // 使用ReentrantLock的newCondition()方法创建三个Condition
        // 分别对应A、B、C三个线程
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        // A线程
        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print(Thread.currentThread().getName());
                    // 叫醒B线程
                    conditionB.signal();
                    // 本线程阻塞
                    conditionA.await();
                }
                // 这里有个坑，要记得在循环之后调用signal()，否则线程可能会一直处于
                // wait状态，导致程序无法结束
                conditionB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 在finally代码块调用unlock方法
                lock.unlock();
            }
        }, "A").start();
        // B线程
        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print(Thread.currentThread().getName());
                    conditionC.signal();
                    conditionB.await();
                }
                conditionC.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "B").start();
        // C线程
        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print(Thread.currentThread().getName());
                    conditionA.signal();
                    conditionC.await();
                }
                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "C").start();
    }
}
