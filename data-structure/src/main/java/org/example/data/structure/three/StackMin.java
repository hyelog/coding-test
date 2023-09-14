package org.example.data.structure.three;

import java.util.Stack;
public class StackMin {

    Stack<Integer> originalStack = new Stack<Integer>();
    Stack<Integer> tempStack = new Stack<Integer>();

    int size = 0;
    public int minData = Integer.MAX_VALUE;
    public void push(int v) {
        if (!updateMinData(v)) {
            originalStack.push(v);
        }
        size++;
    }

    private boolean updateMinData(int v) {
        if (minData > v) {
            if (size != 0) {
                originalStack.push(minData);
            }
            minData = v;
            return true;
        } else {
            return false;
        }
    }
    private int getMinData() {
        return minData;
    }
    public int pop() {
        int minData = getMinData();

        tempStack.clear();
        int checkMinData = Integer.MAX_VALUE;
        boolean isFirstData = true;
        while (!originalStack.isEmpty()) {
            int top = originalStack.pop();
            if (checkMinData > top) {
                if (isFirstData) {
                    isFirstData = false;
                } else {
                    tempStack.push(checkMinData);
                }
                checkMinData = top;
            } else {
                tempStack.push(top);
            }
        }
        this.minData = checkMinData;
        originalStack = (Stack<Integer>) tempStack.clone();
        size--;
        return minData;
    }

    public int peek() {
        return minData;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
