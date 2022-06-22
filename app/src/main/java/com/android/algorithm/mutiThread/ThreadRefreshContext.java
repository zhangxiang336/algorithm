package com.android.algorithm.mutiThread;


class ThreadRefreshContext {
    public static void main(String[] args) throws InterruptedException {
        RefreshThread t = new RefreshThread();
        t.start();
        t.thread = Thread.currentThread();
        System.out.println("start: " + t.keepRunning);
        Thread.sleep(10);
//        t.keepRunning = false;
        System.out.println("keepRunning " + t.keepRunning);
    }

    static class RefreshThread extends Thread {
        public  boolean keepRunning = true;
        Thread thread;
        @Override
        public void run() {
            try {
                int x = 1;
                while (keepRunning) {
//                    System.out.println("如果你不注释这一行，程序会正常停止！");
//                    thread.join();
                    x++;

                }
                System.out.println("finish:" + x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
