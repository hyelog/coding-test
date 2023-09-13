package org.example.data.structure.three;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    public int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack() {
        synchronized (stacks) {
            if (stacks.size() == 0) return null;
            return (Stack) stacks.get(stacks.size() - 1);
        }
    }
    public void push(int v) {
        synchronized (stacks) {
            Stack last = getLastStack();
            if (last != null && !last.isFull()) {
                last.push(v);
            } else {
                Stack stack = new Stack(capacity);
                stack.push(v);
                stacks.add(stack);
            }
        }
    }

    public int pop() {
        synchronized (stacks) {
            Stack last = getLastStack();
            if (last == null) throw new EmptyStackException();
            int v = last.pop();
            if (last.size == 0) stacks.remove(stacks.size() - 1);
            return v;
        }
    }

    public boolean isEmpty() {
        Stack last = getLastStack();
        return last == null || last.isEmpty();
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop) {
        synchronized (stacks) {
            Stack stack = stacks.get(index);
            int removedItem;
            if (removeTop) removedItem = stack.pop();
            else removedItem = stack.removeBottom();
            if (stack.isEmpty()) {
                stacks.remove(index);
            } else if (stacks.size() > index + 1) {
                int v = leftShift(index + 1, false);
                stack.push(v);
            }
            return removedItem;
        }
    }
}
