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
        insertRecursively((BinarySearchTreeNode<E>)getRoot() , newElement);
        return true;
    }
    private void insertRecursively(BinarySearchTreeNode<E> currentNode, E newElement) {
        if(currentNode.compareTo(newElement) > 0) {
            if(currentNode.getLeftChild() == null) {
                currentNode.addLeftChild(new BinarySearchTreeNode<>(newElement));
            }
            else {
                insertRecursively((BinarySearchTreeNode<E>)currentNode.getLeftChild(), newElement);
            }
        }
        else if(currentNode.compareTo(newElement) <= 0) {
            if(currentNode.getRightChild() == null) {
                currentNode.addRightChild(new BinarySearchTreeNode<>(newElement));
            }
            else {
                insertRecursively((BinarySearchTreeNode<E>)currentNode.getRightChild(), newElement);
            }
        }
    }
    public boolean removeElement(E targetElement) {
        return false;
    }

    private void removeRecursively(BinarySearchTreeNode<E> currentNode, E targetValue) {

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
