package com.dhc.多线程.按顺序打印;

/**
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 * public void one() { print("one"); }
 * public void two() { print("two"); }
 * public void three() { print("three"); }
 * }
 * <p>
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * <p>
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 * <p>
 * <p>
 * <p>
 * 注意:
 * <p>
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * <p>
 * 你看到的输入格式主要是为了确保测试的全面性。
 */
public class Solution {
    //TODO
    public static void main(String[] args) throws InterruptedException {
        Integer[] order = {2, 1, 3};
        new Solution().solution(order);
    }

    public void solution(Integer[] order) throws InterruptedException {
        Foo foo = new Foo();
        for (int i : order) {
            new Thread(() -> {
                try {
                    System.out.println(i);
                    switch (i) {
                        case 1:
                            foo.first(new Thread(() -> System.out.println("1")));
                            break;
                        case 2:
                            foo.second(new Thread(() -> System.out.println("2")));
                            break;
                        case 3:
                            foo.third(new Thread(() -> System.out.println("3")));
                            break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    class Foo {

        private boolean firstFinished;
        private boolean secondFinished;
        private Object lock = new Object();

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            synchronized (lock) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                firstFinished = true;
                lock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {

            synchronized (lock) {
                while (!firstFinished) {
                    lock.wait();
                }

                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                secondFinished = true;
                lock.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {

            synchronized (lock) {
                while (!secondFinished) {
                    lock.wait();
                }

                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
            }
        }
    }
}
