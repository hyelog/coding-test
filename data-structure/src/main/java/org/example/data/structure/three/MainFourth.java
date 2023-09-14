package org.example.data.structure.three;

import org.example.data.structure.common.AssortedMethods;

import java.util.LinkedList;
import java.util.Queue;

public class MainFourth {
    public static void main(String[] args) {
        MyQueueAsStack<Integer> myQueue = new MyQueueAsStack<>();

        Queue<Integer> testQueue = new LinkedList<>();

        for (int i=0; i<100; i++) {
            int choice = AssortedMethods.randomIntInRange(0, 10);
            if (choice <= 5) {
                int element = AssortedMethods.randomIntInRange(1, 10);
                testQueue.add(element);
                myQueue.add(element);
                System.out.println("Enqueued " + element);
            } else if (testQueue.size() > 0) {
                int top1 = testQueue.remove();
                int top2 = myQueue.remove();
                if (top1 != top2) {
                    System.out.println("**** FAILURE - DIFFERENT TOPS: " + top1 + ", " + top2);
                }
                System.out.println("Dequeued " + top1);
            }
        }

        if (testQueue.size() == myQueue.size()) {
            if (testQueue.size() > 0 && testQueue.peek() != myQueue.peek()) {
                System.out.println("******* FAILURE - DIFFERENT TOPS: " + testQueue.peek() + ", " + myQueue.peek() + " ******");
            }
        } else {
            System.out.println("******* FAILURE - DIFFERENT SIZES ******");
        }
    }
}