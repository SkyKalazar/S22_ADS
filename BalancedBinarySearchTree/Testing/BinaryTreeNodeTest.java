import Node.BinaryTreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {

    private BinaryTreeNode<Integer> node1;

    @BeforeEach
    void setUp() {
        node1 = new BinaryTreeNode<>(10);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void gettingAnElement() {
        assertEquals(10, node1.getElement());
    }
    @Test
    void settingAnElement() {
        node1.setElement(15);
        assertEquals(15, node1.getElement());
    }
    @Test
    void gettingUnInitializedLeftChild() {
        assertNull(node1.getLeftChild());
    }
    @Test
    void gettingUnInitializedRightChild() {
        assertNull(node1.getRightChild());
    }
    @Test
    void gettingInitializedLeftChild() {
        node1.addLeftChild(new BinaryTreeNode<>(25));
        assertEquals(25, node1.getLeftChild().getElement());
    }
    @Test
    void gettingInitializedRightChild() {
        node1.addRightChild(new BinaryTreeNode<>(30));
        assertEquals(30, node1.getRightChild().getElement());
    }
}