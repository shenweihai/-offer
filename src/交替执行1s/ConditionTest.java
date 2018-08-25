package 交替执行1s;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    static Lock lock = new ReentrantLock();
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + ":" + new Date());
                    sleep(1000);
                    conditionB.signalAll();
                    conditionA.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + ":" + new Date());
                    sleep(1000);
                    conditionA.signalAll();
                    conditionB.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}

