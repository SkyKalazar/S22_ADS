package Tree;

import Node.BinaryTreeNode;

import java.util.ArrayList;

public class BinaryTree<E> {

    private BinaryTreeNode<E> root;
    private ArrayList<E> intermediateResult;

    public BinaryTree(BinaryTreeNode<E> root) {
        intermediateResult = new ArrayList<>();
        this.root = root;
    }
    public BinaryTreeNode<E> getRoot() {
        return root;
    }
    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public int size() {
        return masterTraversal(Traversals.inOrder).size();
    }
    public boolean contains(E element) {
        return masterTraversal(Traversals.inOrder).contains(element);
    }

    public ArrayList<E> masterTraversal(Traversals t) {
        ArrayList<E> finalResult = new ArrayList<>();

        if(root != null) {
            switch (t) {
                case preOrder -> finalResult.addAll(preOrder(root));
                case inOrder -> finalResult.addAll(inOrder(root));
                case postOrder -> finalResult.addAll(postOrder(root));
                case levelOrder -> finalResult.addAll(levelOrder(root));

            }
            intermediateResult.clear();
        }
        return finalResult;
    }

    private ArrayList<E> preOrder(BinaryTreeNode<E> currentNode) {
        if(currentNode != null) {
            intermediateResult.add(currentNode.getElement());
            preOrder(currentNode.getLeftChild());
            preOrder(currentNode.getRightChild());
        }
        return intermediateResult;
    }
    private ArrayList<E> inOrder(BinaryTreeNode<E> currentNode) {
        if(currentNode != null) {
            inOrder(currentNode.getLeftChild());
            intermediateResult.add(currentNode.getElement());
            inOrder(currentNode.getRightChild());
        }
        return intermediateResult;
    }
    private ArrayList<E> postOrder(BinaryTreeNode<E> currentNode) {
        if(currentNode != null) {
            postOrder(currentNode.getLeftChild());
            postOrder(currentNode.getRightChild());
            intermediateResult.add(currentNode.getElement());
        }
        return intermediateResult;
    }
    private ArrayList<E> levelOrder(BinaryTreeNode<E> currentNode) {

        int h = height(currentNode);
        int i;
        for(i = 0; i<= h; i++) {
            printCurrentLevel(currentNode, i);
        }
            return intermediateResult;

    }
    private void printCurrentLevel(BinaryTreeNode<E> currentNode, int level) {
        if(currentNode == null)
            return;
        if(level == 0) {
            intermediateResult.add(currentNode.getElement());
        }
        else if (level > 0) {
            printCurrentLevel(currentNode.getLeftChild(), level-1);
            printCurrentLevel(currentNode.getRightChild(), level-1);
        }
    }

    public int height(BinaryTreeNode<E> currentNode) {
        if(currentNode == null) {
            return -1;
        }
        else {
            int leftHeight = height(currentNode.getLeftChild());
            int rightHeight = height(currentNode.getRightChild());

            return leftHeight >= rightHeight ? leftHeight + 1 : rightHeight + 1;
        }
        }
    }

