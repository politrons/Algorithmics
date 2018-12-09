import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTest {


    static class Node {
        int data;
        Node left;
        Node right;

        public Node() {

        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    @Test
    public void preOrder() {
        Node node4 = new Node(4, null, null);
        Node node6 = new Node(6, null, null);
        Node node3 = new Node(3, null, node4);
        Node node5 = new Node(5, node3, node6);
        Node node2 = new Node(2, null, node5);
        Node node1 = new Node(1, null, node2);
        preOrder(node1);
    }

    /**
     * To get the values from the tree in a preorder we just need to print the data of the leaf before make
     * the recursion of the left and right leaf
     */
    void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

    }

    @Test
    public void postOrder() {
        Node node4 = new Node(4, null, null);
        Node node6 = new Node(6, null, null);
        Node node3 = new Node(3, null, node4);
        Node node5 = new Node(5, node3, node6);
        Node node2 = new Node(2, null, node5);
        Node node1 = new Node(1, null, node2);
        postOrder(node1);
    }

    /**
     * To get the values from the tree in a postorder we just need to print the data of the leaf after make
     * the recursion of the left and right leaf
     */
    void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    @Test
    public void inOrder() {
        Node node4 = new Node(4, null, null);
        Node node6 = new Node(6, null, null);
        Node node3 = new Node(3, null, node4);
        Node node5 = new Node(5, node3, node6);
        Node node2 = new Node(2, null, node5);
        Node node1 = new Node(1, null, node2);
        inOrder(node1);
    }

    /**
     * To get the values from the tree in a inOrder traversal we just need to print the data of the leaf after the left
     * recursion and before the recursion of the right leaf
     */
    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }


    @Test
    public void height() {
        Node node4 = new Node(4, null, null);
        Node node6 = new Node(6, null, null);
        Node node3 = new Node(3, null, node4);
        Node node5 = new Node(5, node3, node6);
        Node node2 = new Node(2, null, node5);
        Node node1 = new Node(1, null, node2);
        System.out.println(height(node1));
    }

    /**
     * Using recursive calls per tree combination we can calc the max height between both.
     */
    int height(Node root) {
        if (root == null) {
            return -1;
        } else {
            int left = 1 + height(root.left);
            int right = 1 + height(root.right);
            return left > right ? left : right;
//            return 1 + Math.max(height(root.left), height(root.right)); Sugar!
        }
    }

    @Test
    public void topView() {
        Node node4 = new Node(4, null, null);
        Node node6 = new Node(6, null, null);
        Node node3 = new Node(3, null, node4);
        Node node5 = new Node(5, node3, node6);
        Node node2 = new Node(2, null, node5);
        Node node1 = new Node(1, null, node2);
        topView(node1);
    }

    /**
     * Top view algorithm force us to separate in two method for left and right since we need to use recursion in left
     * and right side separate. Since we need to print from the left bottom to right bottom, we start in the left and
     * print after all recursion to do it from inside out, and then print center and go to right from top to bottom
     * printing before every recursion.
     *
     * @param root
     */
    void topView(Node root) {
        if (root.left != null) {
            travLeft(root.left);
        }
        System.out.printf("%d ", root.data);
        if (root.right != null) {
            travRight(root.right);
        }
    }

    void travLeft(Node root) {
        if (root.left != null) {
            travLeft(root.left);
        }
        System.out.printf("%d ", root.data);
    }

    void travRight(Node root) {
        System.out.printf("%d ", root.data);
        if (root.right != null) {
            travRight(root.right);
        }
    }

    @Test
    public void levelOrder() {
        Node node4 = new Node(4, null, null);
        Node node6 = new Node(6, null, null);
        Node node3 = new Node(3, null, node4);
        Node node5 = new Node(5, node3, node6);
        Node node2 = new Node(2, null, node5);
        Node node1 = new Node(1, null, node2);
        levelOrder(node1);

    }

    /**
     * This algorithm print from top to bottom level by level left to right.
     * In order to can run through all levels without use reflection we can just add
     * in a Queue our nodes and iterate over them from left to right every level.
     */
    void levelOrder(Node root) {
        if (root != null) {
            Queue<Node> queue = new LinkedList();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node tempNode = queue.poll();
                System.out.print(tempNode.data + " ");
                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
            }
        }

    }

    @Test
    public void binarySearchTree() {
        Node node1 = new Node(1, null, null);
        Node node3 = new Node(3, null, null);
        Node node2 = new Node(2, node1, node3);
        Node node7 = new Node(7, null, null);
        Node node0 = new Node(4, node2, node7);
        System.out.println(Insert(node0, 6).toString());
    }

    /**
     * Binary search tree has the rule that the left children nodes are lower than the father and right nodes are higher.
     * Here with recursion we iterate over the left or right nodes until we reach the end of the tree where we put our value.
     */
    static Node Insert(Node root, int value) {
        if (root == null) {
            Node node = new Node();
            node.data = value;
            root = node;
        } else if (root.data > value) {
            root.left = Insert(root.left, value);
        } else {
            root.right = Insert(root.right, value);
        }
        return root;
    }


    @Test
    public void findNodesSum() {
        Node node4 = new Node(4, null, null);
        Node node6 = new Node(6, null, null);
        Node node3 = new Node(3, null, node4);
        Node node5 = new Node(5, node3, node6);
        Node node2 = new Node(2, null, node5);
        Node node1 = new Node(1, null, node2);
        findNodesSum(node1, 7);
    }

    /**
     * Find nodes that together sum a specific number
     */
    void findNodesSum(Node root, int k) {
        if (root != null) {
            List<Integer> nodes = new ArrayList<>();
            Queue<Node> queue = new LinkedList();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.left != null) queue.add(node.left);
                nodes.add(node.data);
                if (node.right != null) queue.add(node.right);
            }
            for (int i = 0; i < nodes.size() - 1; i++) {
                for (int j = 0; j < nodes.size() - 1; j++) {
                    if (nodes.get(i) + nodes.get(j) == k) {
                        System.out.println(nodes.get(i) + " " + nodes.get(j));
                    }
                }
            }
        }
    }

    @Test
    public void lowestCommonAncestors() {
        Node node7 = new Node(7, null, null);
        Node node4 = new Node(4, null, null);
        Node node6 = new Node(6, null, node7);
        Node node3 = new Node(3, null, node4);
        Node node5 = new Node(5, node3, node6);
        Node node2 = new Node(2, null, node5);
        Node node1 = new Node(1, null, node2);
        System.out.println(lowestCommonAncestors(node1, node4, node7).toString());
    }

    /**
     * For this algorithm we just go deep into level all way down to left and then all way down to right per level.
     * Once that I found the left we return this node, and since we check if is root=left, it will continue  going up
     * until we fill the leftSide. At that moment we start with the rightSide until we found it.
     * Then in the level where leftSide and rightSide are not null, we can return that node since is the lowest commond
     * ancestor.
     */
    Node lowestCommonAncestors(Node root, Node left, Node right) {
        if (root == null) {
            return null;
        }
        if (root == left || root == right) {
            return root;
        }
        Node leftSide = lowestCommonAncestors(root.left, left, right);
        Node rightSide = lowestCommonAncestors(root.right, left, right);
        if (leftSide != null && rightSide != null) {
            return root;
        }
        if (leftSide == null && rightSide == null) {
            return null;
        }
        return leftSide != null ? leftSide : rightSide;
    }

}
