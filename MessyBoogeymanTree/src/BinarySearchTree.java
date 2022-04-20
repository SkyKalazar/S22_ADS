import java.util.ArrayList;

public class BinarySearchTree<E> extends BinaryTree<E> {

    private BinarySearchTreeNode<E> root;
    private ArrayList<BinarySearchTreeNode<E>> searchTree;

    public BinarySearchTree(ArrayList<BinaryTreeNode<E>> tree) {
        super(tree);
        if(!super.isEmpty()) {
            searchTree = new ArrayList<>();
            for (int i = 0; i < tree.size(); i++) {
                searchTree.add(new BinarySearchTreeNode<>(tree.get(i).getElement()));
            }
            setRoot(searchTree.get(0));
            mapBinarySearchTree();
        }
    }

    private void mapBinarySearchTree() {
        for(int i = 0; i < searchTree.size(); i++) {
            insertElement(searchTree.get(i).getElement());
        }
    }

    public void insertElement(E element) {
        if (super.contains(element)) {
            return;
        }
        insertElementRecursively(root, element);
        searchTree.add(new BinarySearchTreeNode<>(element));
    }
    private void insertElementRecursively(BinarySearchTreeNode<E> visited, E element) {
        if(visited == null) {
            visited = new BinarySearchTreeNode<>(element);
        }
        else if(visited.compareTo(element) > 0) {
            insertElementRecursively((BinarySearchTreeNode<E>)visited.getLeftChild(), element);
        }
        else if(visited.compareTo(element) < 0) {
            insertElementRecursively((BinarySearchTreeNode<E>)visited.getRightChild(), element);
        }

    }

    public boolean removeElement(E element) {
        return true;
    }
    public E findMin() {
        return null;
    }
    public E findMax() {
        return null;
    }
    public void rebalance() {
    }
}
