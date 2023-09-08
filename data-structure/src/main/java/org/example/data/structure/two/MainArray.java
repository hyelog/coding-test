package org.example.data.structure.two;

public class MainArray {

    public static void main(String[] args) {
        LinkedListProblem linkedListProblem = new LinkedListProblem();

        int[] data = {1, 2, 3, 2, 3, 4, 5, 1};
        LinkedListNode first, head, second = null;
        first = new LinkedListNode(data[0], null, null);
        head = first;
        second = first;
        for (int i=1; i<data.length; i++) {
            second = new LinkedListNode(data[i], null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }

        LinkedListNode cloneA = head.clone();
        LinkedListNode cloneB = head.clone();
        linkedListProblem.deleteDup(cloneA);

        System.out.println(linkedListProblem.getKthData(cloneB, 5));
        System.out.println(linkedListProblem.nthToLast(cloneB, 5).data);

        LinkedListNode cloneC = head.clone();
        LinkedListProblem.deleteMidNode(cloneC.next.next.next.next);

        int[] dataB = {3, 5, 8, 5, 10, 2, 1};
        LinkedListNode firstB, headB, secondB = null;
        firstB = new LinkedListNode(dataB[0], null, null);
        headB = firstB;
        secondB = firstB;
        for (int i=1; i<dataB.length; i++) {
            secondB = new LinkedListNode(dataB[i], null, null);
            firstB.setNext(secondB);
            secondB.setPrevious(firstB);
            firstB = secondB;
        }

        LinkedListProblem.partition(headB, 5);
        LinkedListNode newHead = LinkedListProblem.partitionB(headB, 5);
        System.out.println("2. 4 new head : ");
        while (newHead != null) {
            System.out.println(newHead.data);
            newHead = newHead.next;
        }

        int[] data5_1 = {7, 1, 6};
        int[] data5_2 = {5, 9, 2};

        LinkedListNode first5_1, head5_1, second5_1 = null;
        first5_1 = new LinkedListNode(data5_1[0], null, null);
        head5_1 = first5_1;
        second5_1 = first5_1;
        for (int i=1; i<data5_1.length; i++) {
            second5_1 = new LinkedListNode(data5_1[i], null, null);
            first5_1.setNext(second5_1);
            second5_1.setPrevious(first5_1);
            first5_1 = second5_1;
        }
        LinkedListNode first5_2, head5_2, second5_2 = null;
        first5_2 = new LinkedListNode(data5_2[0], null, null);
        head5_2 = first5_2;
        second5_2 = first5_2;
        for (int i=1; i<data5_2.length; i++) {
            second5_2 = new LinkedListNode(data5_2[i], null, null);
            first5_2.setNext(second5_2);
            second5_2.setPrevious(first5_2);
            first5_2 = second5_2;
        }

        LinkedListNode head5_1_2 = head5_1.clone();
        LinkedListNode head5_2_2 = head5_2.clone();

        LinkedListNode sumAnswer = LinkedListProblem.summation(head5_1, head5_2);

        System.out.println("2.5 Answer: ");
        while (sumAnswer != null) {
            System.out.println(sumAnswer.data);
            sumAnswer = sumAnswer.prev;
        }

        sumAnswer = LinkedListProblem.summationFromAnswer(head5_1_2, head5_2_2, 0);

        System.out.println("2.5 Answer: ");
        while (sumAnswer != null) {
            System.out.println(sumAnswer.data);
            sumAnswer = sumAnswer.next;
        }

        System.out.println("2.5.2 Answer: ");

        LinkedListNode first5_3_1, head5_3_1, second5_3_1 = null;
        first5_3_1 = new LinkedListNode(data5_1[data5_1.length-1], null, null);
        head5_3_1 = first5_3_1;
        second5_3_1 = first5_3_1;
        for (int i=1; i<data5_1.length; i++) {
            second5_3_1 = new LinkedListNode(data5_1[data5_1.length-i-1], null, null);
            first5_3_1.setNext(second5_3_1);
            second5_3_1.setPrevious(first5_3_1);
            first5_3_1 = second5_3_1;
        }

        LinkedListNode first5_3_2, head5_3_2, second5_3_2 = null;
        first5_3_2 = new LinkedListNode(data5_2[data5_2.length-1], null, null);
        head5_3_2 = first5_3_2;
        second5_3_2 = first5_3_2;
        for (int i=1; i<data5_2.length; i++) {
            second5_3_2 = new LinkedListNode(data5_2[data5_2.length-i-1], null, null);
            first5_3_2.setNext(second5_3_2);
            second5_3_2.setPrevious(first5_3_2);
            first5_3_2 = second5_3_2;
        }

        LinkedListNode partialSum = LinkedListProblem.addList(head5_3_1, head5_3_2);

        while (partialSum != null) {
            System.out.println(partialSum.data);
            partialSum = partialSum.next;
        }

        System.out.println("#2.6 palindrome");

        int[] data2_7 = {1, 2, 3, 4, 5, 4, 3, 2, 1};

        LinkedListNode first2_7, head2_7, second2_7 = null;
        first2_7 = new LinkedListNode(data2_7[0], null, null);
        head2_7 = first2_7;
        second2_7 = first2_7;
        for (int i=1; i<data2_7.length; i++) {
            second2_7 = new LinkedListNode(data2_7[i], null, null);
            first2_7.setNext(second2_7);
            second2_7.setPrevious(first2_7);
            first2_7 = second2_7;
        }

        LinkedListNode head2_7_2 = head2_7.clone();
        LinkedListNode head2_7_3 = head2_7.clone();

        System.out.println("Is it palindrome?" + (LinkedListProblem.isPalindrome(head2_7)?"true":"false"));
        System.out.println("Is it palindrome?" + (LinkedListProblem.isPalindromeWithRunner(head2_7_2)?"true":"false"));
        System.out.println("Is it palindrome?" + (LinkedListProblem.isPalindromeWithRecursive(head2_7_2)?"true":"false"));

        System.out.println("# 2.7");

        int[] data2_8 = {3, 1, 5, 9, 7, 2, 1};

        LinkedListNode current2_8, head2_8 = null;
        head2_8 = new LinkedListNode(data2_8[0], null, null);
        current2_8 = head2_8;
        for (int i=1; i<data2_8.length; i++) {
            current2_8 = new LinkedListNode(data2_8[i], null, current2_8);
        }

        LinkedListNode current2_8_2, head2_8_2 = null;
        head2_8_2 = new LinkedListNode(4, null, null);
        current2_8_2 = head2_8_2;
        current2_8_2 = new LinkedListNode(6, null, current2_8_2);

        head2_8_2.next.next = head2_8.next.next.next.next;
        System.out.println("2.7 answer");

        LinkedListNode head2_8_answer = LinkedListProblem.findIntersection(head2_8, head2_8_2);

        while (head2_8_answer != null) {
            System.out.println(head2_8_answer.data);
            head2_8_answer = head2_8_answer.next;
        }

        System.out.println("# 2.8");
        int list_length = 100;
        int k = 10;

        // Create linked list
        LinkedListNode[] nodes = new LinkedListNode[list_length];
        for (int i = 0; i < list_length; i++) {
            nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
        }

        // Create loop;
        nodes[list_length - 1].next = nodes[list_length - k];

        LinkedListNode answer2_10 = LinkedListProblem.findBeginning(nodes[0]);

        System.out.println(answer2_10.data);
    }

}