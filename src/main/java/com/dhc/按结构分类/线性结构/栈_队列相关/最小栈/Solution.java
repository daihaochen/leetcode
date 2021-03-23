package com.dhc.按结构分类.线性结构.栈_队列相关.最小栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author haochen.dai
 * @Date: 2020-09-24 15:47
 * @Description:
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */
public class Solution {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        System.out.println(minStack.getMin());

    }
}


/**
 * 用辅助栈实现
 */
class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(x, getMin()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();

    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * 一个栈中同时存储数据和当前最小值
 */
class MinStack1 {
    Deque<ValueAndMin> stack;

    /** initialize your data structure here. */
    public MinStack1() {
        stack = new LinkedList<>();

    }

    public void push(int x) {
        stack.push(new ValueAndMin(x, Math.min(x, getMin())));

    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;

    }

    public int getMin() {
        return stack.isEmpty() ? Integer.MAX_VALUE : stack.peek().min;
    }

    class ValueAndMin {
        public int value;
        public int min;

        public ValueAndMin(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
