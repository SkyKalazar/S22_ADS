package Node;

public class BinaryTreeNode<E> {

    private E element;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;

    public BinaryTreeNode(E value) {
        element = value;
        leftChild = null;
        rightChild = null;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void addLeftChild(BinaryTreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void addRightChild(BinaryTreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode<E> getRightChild() {
        return rightChild;
    }
}
