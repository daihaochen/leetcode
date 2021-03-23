package com.dhc.多线程.volatile关键字;

import java.util.concurrent.TimeUnit;

/**
 * @author haochen.dai
 * @Date: 2020-10-11 21:58
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        testThread.start();
        while (true) {
            synchronized (testThread) {
                if (testThread.isFlag()) {
                    System.out.println("有点东西");
                }
            }
        }

    }


}

class TestThread extends Thread {

    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + flag);
    }
}
