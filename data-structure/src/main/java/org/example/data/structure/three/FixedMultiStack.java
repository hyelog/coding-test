package org.example.data.structure.three;

import org.example.data.structure.common.AssortedMethods;

import java.util.EmptyStackException;

public class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    private int minValue;
    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
        minValue = 0;
    }

    public void push(int stackNum, int value) throws FullStackException {
        if (isFull(stackNum)) {
            throw new FullStackException();
        }

        if (minValue > value) {
            minValue = value;
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    public int[] getValues() {
        return values;
    }

    public int[] getStackValues(int stackNum) {
        int[] items = new int[sizes[stackNum]];
        for (int i=0; i<items.length; i++) {
            items[i] = values[stackNum * stackCapacity + i];
        }
        return items;
    }

    public String stackToString(int stackNum) {
        int[] items = getStackValues(stackNum);
        return stackNum + ": " + AssortedMethods.arrayToString(items);
    }
}
