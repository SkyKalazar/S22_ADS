package Tree;

import Node.BinaryTreeNode;

import java.util.ArrayList;

public class BinaryTree<E> {

    private BinaryTreeNode<E> root;
    private int size;
    private ArrayList<E> intermediateResult;

    public BinaryTree(BinaryTreeNode<E> root) {
        intermediateResult = new ArrayList<>();
        this.root = root;
        size = 1;
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
                case levelOrder -> finalResult.addAll(levelOrder());
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
    private ArrayList<E> levelOrder() {
      return null;
    }
    public int height() {
        return 0;
    }


}
