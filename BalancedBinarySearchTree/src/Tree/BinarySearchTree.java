package Tree;

import Node.BinarySearchTreeNode;

public class BinarySearchTree<E> extends BinaryTree<E> {


    public BinarySearchTree(BinarySearchTreeNode<E> root) {
        super(root);
    }

    public boolean insertElement(E newElement) {
        if(contains(newElement)) {
            return false;
        }
        insertRecursively((BinarySearchTreeNode<E>)getRoot(), newElement);
        return true;
    }
    private void insertRecursively(BinarySearchTreeNode<E> targetNode, E newElement) {
        if(targetNode == null) {
           targetNode = new BinarySearchTreeNode<>(newElement);
           return;
        }
        if(targetNode.compareTo(newElement) > 0) {
            insertRecursively((BinarySearchTreeNode<E>) targetNode.getLeftChild(), newElement);
        }
        if(targetNode.compareTo(newElement) <= 0) {
            insertRecursively((BinarySearchTreeNode<E>)targetNode.getRightChild(), newElement);
        }
    }
    public boolean removeElement(BinarySearchTreeNode<E> targetElement) {
        return false;
    }
    public E findMin() {
        return masterTraversal(Traversals.inOrder).get(0);
    }
    public E findMax() {
        return masterTraversal(Traversals.inOrder).get(size()-1);
    }
    public void rebalance() {

    }
}
