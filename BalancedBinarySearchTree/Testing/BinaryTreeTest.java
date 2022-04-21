import Node.BinaryTreeNode;
import Tree.BinaryTree;
import Tree.BinaryTreePrint;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTreeNode<Integer> root;
    private BinaryTreeNode<Integer> node1;
    private BinaryTreeNode<Integer> node2;
    private BinaryTreeNode<Integer> node3;
    private BinaryTreeNode<Integer> node4;
    private BinaryTreeNode<Integer> node5;
    private BinaryTreeNode<Integer> node6;
    private BinaryTreeNode<Integer> node7;
    private BinaryTreeNode<Integer> node8;
    private BinaryTreeNode<Integer> node9;
    private BinaryTreeNode<Integer> node10;

    private BinaryTree<Integer> tree;

    @BeforeEach
    void setUp() {
        root = new BinaryTreeNode<>(10);
        node1 = new BinaryTreeNode<>(11);
        node2 = new BinaryTreeNode<>(12);
        node3 = new BinaryTreeNode<>(13);
        node4 = new BinaryTreeNode<>(14);
        node5 = new BinaryTreeNode<>(15);
        node6 = new BinaryTreeNode<>(16);
        node7 = new BinaryTreeNode<>(17);
        node8 = new BinaryTreeNode<>(18);
        node9 = new BinaryTreeNode<>(19);
        node10 = new BinaryTreeNode<>(20);

        root.addLeftChild(node1);
        root.addRightChild(node2);

        node1.addLeftChild(node10);
        node1.addRightChild(node9);

        node2.addRightChild(node3);

        node3.addLeftChild(node4);
        node3.addRightChild(node5);

        node9.addLeftChild(node6);
        node9.addRightChild(node7);

        node7.addRightChild(node8);

        tree = new BinaryTree<>(root);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRoot() {
        assertEquals(10, tree.getRoot().getElement());
    }

    @Test
    void setRoot() {
        tree.getRoot().setElement(27);
        assertEquals(27, tree.getRoot().getElement());
        BinaryTreePrint print = new BinaryTreePrint();
        print.printTree(root);
    }

    @Test
    void isEmpty() {
    }

    @Test
    void size() {
    }

    @Test
    void contains() {
    }

    @Test
    void preOrderTraversal() {
    }

    @Test
    void inOrderTraversal() {
    }

    @Test
    void postOrderTraversal() {
    }

    @Test
    void levelOrderTraversal() {
    }

    @Test
    void height() {
    }
}