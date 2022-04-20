import java.util.ArrayList;

public class BinaryTree<E> {

    private BinaryTreeNode<E> root;
    private int size;
    private ArrayList<BinaryTreeNode<E>> tree;
    private ArrayList<E> intermediateResult;

    public BinaryTree(ArrayList<BinaryTreeNode<E>> tree) {
        intermediateResult = new ArrayList<>();

        this.tree = tree;
        size = tree.size();
        mapTheTree();
    }

    private void mapTheTree() {
        if(size != 0) {
            root = tree.get(0);
            for(int i = 0; i < size; i++) {
                try {
                    if(tree.get(i) != null) {
                        tree.get(i).addLeftChild(tree.get(2 * i + 1));
                        tree.get(i).addRightChild(tree.get(2 * (i + 1)));
                    }
                }
                catch (IndexOutOfBoundsException ignored) {

                }
            }
        }
        else {
            root = null;
        }
    }

    public BinaryTreeNode<E> getRoot() {
        return root;
    }
    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public boolean contains(E element) {
        for(int i = 0; i < size; i++) {
            if(tree.get(i).getElement().equals(element)) {
                return true;
            }
        }
        return false;
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
        for (BinaryTreeNode<E> eBinaryTreeNode : tree) {
            intermediateResult.add(eBinaryTreeNode.getElement());
        }
        return intermediateResult;
    }
    public int height() {
        if(size == 0) {
            return -1;
        }
        return (int)(Math.log((size-1))/Math.log(2));
    }


}
