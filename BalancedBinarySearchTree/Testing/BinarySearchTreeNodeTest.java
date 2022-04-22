import Node.BinarySearchTreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeNodeTest {

    private BinarySearchTreeNode<Integer> node1;
    private BinarySearchTreeNode<Integer> node2;

    @BeforeEach
    void setUp() {
        node1 = new BinarySearchTreeNode<>(10);
        node2 = new BinarySearchTreeNode<>(30);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void firstLessThanSecond() {
        assertEquals(-20, node1.compareTo(node2.getElement()));
    }
    @Test
    void secondLessThanFirst() {
        node2.setElement(3);
        assertEquals(7, node1.compareTo(node2.getElement()));
    }
}