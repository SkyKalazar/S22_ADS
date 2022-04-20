public class BinarySearchTreeNode<E> extends BinaryTreeNode<E> implements Comparable<E>{

    public BinarySearchTreeNode(E value) {
        super(value);
    }


    @Override
    public int compareTo(E o) {
        return (Integer)getElement() - (Integer)o;
    }
}
