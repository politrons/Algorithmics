import org.junit.Test;

import java.util.LinkedList;

import static jdk.nashorn.internal.objects.Global.print;

public class LinkedListTest {


    class Node {
        int data;
        Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    @Test
    public void addLinedListBottom() {
        Node insert = Insert(null, 3);
        Node insert1 = Insert(insert, 247);
        Node insert2 = Insert(insert1, 678);
        Node insert3 = Insert(insert2, 159);
        Node insert4 = Insert(insert3, 17);
        System.out.println(insert4);
    }

    Node Insert(Node head, int data) {
        if (head == null) {
            head = new Node();
            head.data = data;
        } else {
            head.next = Insert(head.next, data);
        }
        return head;
    }

    @Test
    public void addLinedLisHead() {
        Node insert = InsertHead(null, 1);
        Node insert1 = InsertHead(insert, 2);
        Node insert2 = InsertHead(insert1, 3);
        Node insert3 = InsertHead(insert2, 4);
        Node insert4 = InsertHead(insert3, 5);
        System.out.println(insert4);
    }

    Node InsertHead(Node head, int data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        return node;
    }

    @Test
    public void reverse() {
        Node insert = Insert(null, 5);
        Node insert1 = Insert(insert, 4);
        Node insert2 = Insert(insert1, 3);
        Node insert3 = Insert(insert2, 2);
        Node insert4 = Insert(insert3, 1);
        Node reverse = Reverse(insert4);
        System.out.println(reverse.toString());
    }

    /**
     * We need to move by recursion to the end of the llist and then start from inside out.
     * we save our current node in the two links to the right since the [next] is the one that is moving to the left
     * so my current position.
     */
    Node Reverse(Node head) {
        if (head.next != null) {
            Node remaining = Reverse(head.next);
            head.next.next = head;//I move my node two positions to the right.
            head.next = null;//I remove my next node link since is not that one anymore.
            return remaining;// continue the backwards
        }
        return head;
    }

    @Test
    public void CompareLists() {
        Node nodeA = Insert(null, 1);
        Node node1A = Insert(nodeA, 2);
        Node node2A = Insert(node1A, 3);
        Node node4A = Insert(node2A, 4);

        Node nodeB = Insert(null, 1);
        Node node1B = Insert(nodeB, 2);
        Node node2B = Insert(node1B, 3);
        Node node4B = Insert(node2B, 4);

        System.out.println(CompareLists(node4A, node4B));
    }

    /**
     * The comparison just need to go through all nodes so in case both are equals, we just need to go to the next
     * level, asuming that since if they dont at some point we will execute the else which it will return 0, and it
     * will be the end of the recursion. And since we cannot reach the end of recursion where both A and B are null
     * we can assume is false.
     */
    int CompareLists(Node headA, Node headB) {
        if (headA == null && headB == null) return 1;
        if (headA == null || headB == null) return 0;
        if (headA.next == null && headB.next != null) return 0;
        if (headA.next != null && headB.next == null) return 0;
        if (headA.data == headB.data) {
            return CompareLists(headA.next, headB.next);
        } else {
            return 0;
        }
    }

    @Test
    public void mergeLists() {
        Node nodeA = Insert(null, 1);
        Node node1A = Insert(nodeA, 4);
        Node node2A = Insert(node1A, 5);
        Node nodeB = Insert(null, 2);
        Node node1B = Insert(nodeB, 3);
        Node node2B = Insert(node1B, 6);
        System.out.println(MergeLists(node2A, node2B));
    }

    /**
     * Since we have a two linkedList to merge where one is lower than the other, the only thing we have to do
     * is determine which element is coming after the one we detect is the lower one.
     * So in case A < B we set A1 as the node and we set the next with the recursion call of a.next which is the
     * next candidate against the current B element.
     */
    Node MergeLists(Node a, Node b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }
        if (a.data < b.data) {
            a.next = MergeLists(a.next, b);
            return a;
        } else {
            b.next = MergeLists(a, b.next);
            return b;
        }
    }

}
