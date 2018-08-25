package 交替执行1s;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Solution {
    //public static volatile int flag = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread a = new Thread(new ThreadWait(lock));
        Thread b = new Thread(new ThreadNotify(lock));
        a.start();
        b.start();
    }

    static class ThreadWait implements Runnable {
        Lock lock;

        ThreadWait(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                if (StaticFlag.flag == 0) {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + " " + new Date());
                        try {
                            sleep(1000);
                            StaticFlag.flag = 1;
                            lock.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }
        }
    }

    static class ThreadNotify implements Runnable {
        Lock lock;

        ThreadNotify(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                //System.out.println(flag);
                if (StaticFlag.flag == 1) {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + " " + new Date());
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lock.notify();
                        StaticFlag.flag = 0;
                    }
                }
            }
        }
    }
}

