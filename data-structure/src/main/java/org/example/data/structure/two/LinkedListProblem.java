package org.example.data.structure.two;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class LinkedListProblem {
    public void deleteDup(LinkedListNode n) {
        HashSet set = new HashSet();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    public int getKthData(LinkedListNode n, int k) {
        int data;

        ArrayList<Integer> list = new ArrayList<>();
        while (n != null) {
            list.add(n.data);
            n = n.next;
        }
        return list.get(list.size() - k);
    }

    public static LinkedListNode nthToLast(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        /* Move p1 k nodes into the list.*/
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null; // Out of bounds
            p1 = p1.next;
        }

        /* Move them at the same pace. When p1 hits the end,
         * p2 will be at the right element. */
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static LinkedListNode deleteMidNode(LinkedListNode n) {
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return n;
    }

    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while (node != null) {
            LinkedListNode next = node.next;
            node.next = null;
            if (node.data < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public static LinkedListNode partitionB(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }

    public static LinkedListNode summation(LinkedListNode node1, LinkedListNode node2) {
        LinkedListNode head = null, second = null;

        int data = node1.data + node2.data;
        if (data >= 10) {
            data -= 10;
            node1.next.data += 1;
        }
        head = new LinkedListNode(data, null, null);
        node1 = node1.next;
        node2 = node2.next;
        while (node1 != null && node2 != null) {
            data = node1.data + node2.data;
            if (data >= 10) {
                if (node1.next != null) {
                    node1.next.data += 1;
                    data -= 10;
                }
            }
            second = new LinkedListNode(data, null, null);
            head.setNext(second);
            second.setPrevious(head);
            head = second;
            node1 = node1.next;
            node2 = node2.next;
        }
        return head;
    }

    public static LinkedListNode summationFromAnswer(LinkedListNode node1, LinkedListNode node2, int carry) {
        if (node1 == null && node2 == null && carry == 0) {
            return null;
        }
        LinkedListNode result = new LinkedListNode();
        int value = carry;
        if (node1 != null) {
            value += node1.data;
        }
        if (node2 != null) {
            value += node2.data;
        }
        result.data = value % 10;

        if (node1 != null || node2 != null) {
            LinkedListNode more = summationFromAnswer(node1 == null?null:node1.next,
                    node2 == null?null:node2.next, value >= 10?1:0);
            result.setNext(more);
        }
        return result;
    }

    private static int length(LinkedListNode node) {
        int size = 0;
        while (node != null) {
            size+=1;
            node = node.next;
        }
        return size;
    }

    private static LinkedListNode insertBefore(LinkedListNode list, int value) {
        LinkedListNode node = new LinkedListNode(value);
        if (list != null) {
            node.next = list;
        }
        return node;
    }
    private static LinkedListNode paddList(LinkedListNode node, int gap) {
        LinkedListNode head = node;
        for (int i=0; i< gap; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    public static PartialSum addListHelper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }
        PartialSum sum = addListHelper(l1.next, l2.next);
        int val = sum.carry + l1.data + l2.data;
        LinkedListNode full_result = insertBefore(sum.sum, val % 10);

        sum.sum = full_result;
        sum.carry = val / 10;
        return sum;
    }
    public static LinkedListNode addList(LinkedListNode l1, LinkedListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        if (len1 < len2) {
            l1 = paddList(l1, len2-len1);
        } else {
            l2 = paddList(l2, len1-len2);
        }

        PartialSum sum = addListHelper(l1, l2);

        if (sum.carry == 0) {
            return sum.sum;
        } else {
            LinkedListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    private static LinkedListNode rearNode(LinkedListNode node) {
        LinkedListNode last = null;
        LinkedListNode currentode = null;
        while (node != null) {
            last = currentode;
            currentode = new LinkedListNode(node.data, null, null);
            currentode.setNext(last);
            if (currentode.prev != null) {
                currentode.prev.setPrevious(currentode);
            }
            node = node.next;
        }
        return currentode;
    }
    public static boolean isPalindrome(LinkedListNode node) {
        LinkedListNode reverseNode = rearNode(node);

        while (reverseNode != null) {
            if (node.data != reverseNode.data) {
                return false;
            }

            node = node.next;
            reverseNode = reverseNode.next;
        }
        return true;
    }

    public static boolean isPalindromeWithRunner(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack stack = new Stack();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            int top = (int) stack.pop();
            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    private static int lengthOfList(LinkedListNode head) {
        int size=0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public static boolean isPalindromeWithRecursive(LinkedListNode head) {
        int length = lengthOfList(head);
        Result p = isPalindromeRecursive(head, length);
        return p.result;
    }

    private static Result isPalindromeRecursive(LinkedListNode head, int length) {
        if (head == null || length <=0) {
            return new Result(head, true);
        } else if (length == 1) {
            return new Result(head.next, true);
        }

        Result res = isPalindromeRecursive(head.next, length-2);

        if (!res.result || res.node == null) {
            return res;
        }

        res.result = (head.data == res.node.data);
        res.node = res.node.next;
        return res;
    }

    static LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    public static LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null || list2 == null) return null;
        ResultWithTail result1 = ResultWithTail.getTailAndSize(list1);
        ResultWithTail result2 = ResultWithTail.getTailAndSize(list2);

        if (result1.tail != result2.tail) {
            return null;
        }

        LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
        LinkedListNode longer = result1.size > result2.size ? list1 : list2;

        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;
    }

    public static LinkedListNode findBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}