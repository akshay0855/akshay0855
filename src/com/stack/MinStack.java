package com.stack;

import java.util.Stack;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 */
class MinStack {
	Stack<Integer> allData;
	Stack<Integer> minData;

	public MinStack() {
		allData = new Stack<>();
		minData = new Stack<>();
	}

	public void push(int val) {
		if (minData.size() == 0) {
			minData.push(val);
			allData.push(val);
		} else {
			if (val <= minData.peek()) // imp point
			{
				minData.push(val);
			}
			allData.push(val);
		}
	}

	public void pop() {
		if (allData.size() == 0) {
			System.out.println("Stack underflow");
			// return -1;
		} else {
			int val = allData.pop();
			if (val == minData.peek()) {
				minData.pop();
			}
			// return val;

		}
	}

	public int top() {
		if (allData.size() == 0) {
			System.out.println("Stack underflow");
			return -1;
		} else {
			return allData.peek();
		}
	}

	public int getMin() {
		if (minData.size() == 0) {
			System.out.println("Stack underflow");
			return -1;
		} else
			return minData.peek();
	}
}