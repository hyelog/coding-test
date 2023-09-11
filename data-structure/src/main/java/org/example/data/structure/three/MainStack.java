package org.example.data.structure.three;

import org.example.data.structure.common.AssortedMethods;

import java.util.Enumeration;

public class MainStack {

    public static void printStacks(FixedMultiStack stacks) {
        System.out.println("array: " + AssortedMethods.arrayToString(stacks.getValues()));
    }

    public static void printStacks(StackWithMin stacks) {

        Enumeration<Integer> integerEnumeration = stacks.elements();
        while (integerEnumeration.hasMoreElements())
            System.out.print(integerEnumeration.nextElement() + " ");
        System.out.println("min: " + stacks.min());

    }
    public static void main(String[] args) throws Exception {
        FixedMultiStack stacks = new FixedMultiStack(4);
        printStacks(stacks);

        stacks.push(0, 10);
        printStacks(stacks);
        stacks.push(1, 20);
        printStacks(stacks);
        stacks.push(2, 30);
        printStacks(stacks);
        stacks.push(1, 21);
        printStacks(stacks);
        stacks.push(0, 11);
        printStacks(stacks);
        stacks.push(0, 12);
        printStacks(stacks);

        stacks.pop(0);
        printStacks(stacks);

        stacks.push(2, 31);
        printStacks(stacks);
        stacks.push(0, 13);
        printStacks(stacks);
        stacks.push(1, 22);
        printStacks(stacks);

        stacks.push(2, 31);
        printStacks(stacks);

        stacks.push(2, 32);
        printStacks(stacks);

        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(5);
        printStacks(stackWithMin);
        stackWithMin.push(6);
        printStacks(stackWithMin);
        stackWithMin.push(3);
        printStacks(stackWithMin);
        stackWithMin.push(7);
        printStacks(stackWithMin);
        stackWithMin.pop();
        printStacks(stackWithMin);
        stackWithMin.pop();
        printStacks(stackWithMin);

    }
}
