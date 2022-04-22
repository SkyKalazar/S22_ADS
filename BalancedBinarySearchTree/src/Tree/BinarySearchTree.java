package Tree;

import Node.BinarySearchTreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

        if(!contains(targetElement)) {
            return false;
        }
        removeRecursively((BinarySearchTreeNode<E>)getRoot(), targetElement);
        return true;
    }

    private void removeRecursively(BinarySearchTreeNode<E> currentNode, E targetValue) {
        //The left child is the sought after node
        if(currentNode.getLeftChild().getElement().equals(targetValue)) {
            if(currentNode.getLeftChild().getLeftChild() == null && currentNode.getLeftChild().getRightChild() == null) {
                currentNode.addLeftChild(null);
            }
            else {
                ArrayList<E> inOrder = masterTraversal(Traversals.inOrder);
                E removal = inOrder.get(inOrder.indexOf(targetValue)+1);
                removeRecursively(currentNode, removal);
                currentNode.getLeftChild().setElement(removal);
            }
        }
        //The right child is the sought after node
        if(currentNode.getRightChild().getElement().equals(targetValue)) {
            if(currentNode.getRightChild().getLeftChild() == null && currentNode.getRightChild().getRightChild() == null) {
                currentNode.addRightChild(null);
            }
            else {
                ArrayList<E> inOrder = masterTraversal(Traversals.inOrder);
                E removal = inOrder.get(inOrder.indexOf(targetValue)+1);
                removeRecursively(currentNode, removal);
                currentNode.getRightChild().setElement(removal);
            }
        }
        //Continuing the search to the left
        else if(currentNode.compareTo(targetValue) > 0) {
            if(currentNode.getLeftChild() != null) {
                removeRecursively((BinarySearchTreeNode<E>)currentNode.getLeftChild(), targetValue);
            }
        }
        //Continuing the search to the right
        else if(currentNode.compareTo(targetValue) <= 0) {
            if(currentNode.getRightChild() != null) {
                removeRecursively((BinarySearchTreeNode<E>)currentNode.getRightChild(), targetValue);
            }
        }
    }

    public E findMin() {
        return masterTraversal(Traversals.inOrder).get(0);
    }
    public E findMax() {
        return masterTraversal(Traversals.inOrder).get(size()-1);
    }
    public void rebalance() {
        ArrayList<E> inOrder = masterTraversal(Traversals.inOrder);

        E newRoot = inOrder.get(inOrder.size()/2);
        setRoot(new BinarySearchTreeNode<>(newRoot));
        inOrder.remove(newRoot);

        for (E e : inOrder) {
            insertElement(e);
        }

    }
}
