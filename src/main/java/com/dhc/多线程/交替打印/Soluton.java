package com.dhc.多线程.交替打印;

/**
 * @author haochen.dai
 * @Date: 2020-10-22 10:40
 * @Description:
 *
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 */
public class Soluton {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(5);
        new Thread(()-> {
            try {
                fooBar.foo(()-> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                fooBar.bar(()-> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}

class FooBar {

    private int n;
    private  boolean isFoo = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!isFoo) {
            }
            printFoo.run();
            isFoo = false;
        }
    }

    public void bar(Runnable printBar)  throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (isFoo) {
            }
            printBar.run();
            isFoo = true;
        }
    }
}
