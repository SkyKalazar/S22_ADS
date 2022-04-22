import Node.BinaryTreeNode;
import Tree.BinaryTree;
import Tree.BinaryTreePrint;
import Tree.Traversals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
        BinaryTreePrint print = new BinaryTreePrint();
        print.printTree(root);
    }

    @Test
    void getRoot() {
        assertEquals(10, tree.getRoot().getElement());
    }

    @Test
    void setRoot() {
        tree.getRoot().setElement(27);
        assertEquals(27, tree.getRoot().getElement());
    }

    @Test
    void isNotEmpty() {
        assertFalse(tree.isEmpty());
    }
    @Test
    void isEmpty() {
        BinaryTree<Double> tree2 = new BinaryTree<>(new BinaryTreeNode<>(200.0));
        tree2.setRoot(null);
        assertTrue(tree2.isEmpty());
    }
    @Test
    void size() {
        assertEquals(11, tree.size());
    }

    @Test
    void contains() {
        assertFalse(tree.contains(5));
        assertTrue(tree.contains(10));
    }

    @Test
    void preOrderTraversal() {
        ArrayList<Integer> preOrder = new ArrayList<>(Arrays.asList(10, 11, 20, 19, 16, 17, 18, 12, 13, 14, 15));

        assertEquals(preOrder, tree.masterTraversal(Traversals.preOrder));
    }

    @Test
    void inOrderTraversal() {
        ArrayList<Integer> inOrder = new ArrayList<>(Arrays.asList(20, 11, 16, 19, 17, 18, 10, 12, 14, 13, 15));

        assertEquals(inOrder, tree.masterTraversal(Traversals.inOrder));
    }

    @Test
    void postOrderTraversal() {
        ArrayList<Integer> postOrder = new ArrayList<>(Arrays.asList(20, 16, 18, 17, 19, 11, 14, 15, 13, 12, 10));

        assertEquals(postOrder, tree.masterTraversal(Traversals.postOrder));
    }

    @Test
    void levelOrderTraversal() {
        ArrayList<Integer> levelOrder = new ArrayList<>(Arrays.asList(10, 11, 12, 20, 19, 13, 16, 17, 14, 15, 18));

        assertEquals(levelOrder, tree.masterTraversal(Traversals.levelOrder));
    }

    @Test
    void height() {
        assertEquals(4, tree.height(root));
    }
}