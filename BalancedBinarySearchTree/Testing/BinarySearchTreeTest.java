import Node.BinarySearchTreeNode;
import Tree.BinarySearchTree;
import Tree.BinaryTreePrint;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTreeNode<Integer> node1;
    private BinarySearchTree<Integer> tree;

    @BeforeEach
    void setUp() {
        node1 = new BinarySearchTreeNode<>(10);

        tree = new BinarySearchTree<>(node1);


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insertElement() {
        tree.insertElement(15);
        BinaryTreePrint print = new BinaryTreePrint();
        print.printTree(tree.getRoot());
    }

    @Test
    void removeElement() {
    }

    @Test
    void findMin() {
    }

    @Test
    void findMax() {
    }

    @Test
    void rebalance() {
    }
}