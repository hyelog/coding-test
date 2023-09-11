package org.example.data.structure.three;

import org.example.data.structure.common.AssortedMethods;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackTester {

    public static void main(String[] args) {
        int[] array = AssortedMethods.randomArray(100, -100, 100);
        MyStack<Integer> stack1 = new MyStack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        for (int a : array) {
            if (a < 0) {
                int top1, top2;
                try {
                    top1 = stack1.pop();
                } catch (EmptyStackException ex) {
                    top1 = Integer.MIN_VALUE;
                }

                try {
                    top2 = stack2.pop();
                } catch (EmptyStackException ex) {
                    top2 = Integer.MIN_VALUE;
                }

                if (top1 != top2) {
                    System.out.println("Error");
                } else {
                    System.out.println("Success");
                }
            } else {
                stack1.push(a);
                stack2.push(a);
            }
        }

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int top1, top2;
            try {
                top1 = stack1.pop();
            } catch (EmptyStackException ex) {
                top1 = Integer.MIN_VALUE;
            }

            try {
                top2 = stack2.pop();
            } catch (EmptyStackException ex) {
                top2 = Integer.MIN_VALUE;
            }

            if (top1 != top2) {
                System.out.println("Error");
            } else {
                System.out.println("Success");
            }
        }
    }
}
