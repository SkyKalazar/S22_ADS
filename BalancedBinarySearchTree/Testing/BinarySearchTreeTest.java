import Node.BinarySearchTreeNode;
import Tree.BinarySearchTree;
import Tree.BinaryTreePrint;
import Tree.Traversals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTreeNode<Integer> node1;
    private BinarySearchTree<Integer> tree;
    private BinaryTreePrint print;

    @BeforeEach
    void setUp() {
        print = new BinaryTreePrint();
        node1 = new BinarySearchTreeNode<>(10);

        tree = new BinarySearchTree<>(node1);

        tree.insertElement(15);
        tree.insertElement(11);
        tree.insertElement(7);
        tree.insertElement(20);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insertElement() {
        print.printTree(tree.getRoot());

        ArrayList<Integer> levelOrder = new ArrayList<>(Arrays.asList(10, 7, 15, 11, 20));

        assertEquals(levelOrder, tree.masterTraversal(Traversals.levelOrder));
    }

    @Test
    void removeElement1() {
        tree.removeElement(7);
        print.printTree(tree.getRoot());
    }
    @Test
    void removeElement2() {
        print.printTree(tree.getRoot());
        tree.removeElement(10);
        print.printTree(tree.getRoot());
    }

    @Test
    void findMin() {
        assertEquals(7, tree.findMin());
    }

    @Test
    void findMax() {
        assertEquals(20, tree.findMax());
    }

    @Test
    void rebalance() {
        tree.insertElement(1);
        tree.insertElement(2);
        tree.insertElement(3);
        tree.insertElement(4);
        tree.insertElement(5);
        tree.insertElement(6);

        print.printTree(tree.getRoot());

        tree.rebalance();

        print.printTree(tree.getRoot());



    }
}