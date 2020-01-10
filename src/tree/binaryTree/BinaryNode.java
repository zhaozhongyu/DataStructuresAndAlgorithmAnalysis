package tree.binaryTree;

public class BinaryNode<T> {
    BinaryNode(T element) {
        this(element, null, null);
    }

    BinaryNode(T element, BinaryNode left, BinaryNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    T element;
    BinaryNode<T> left;
    BinaryNode<T> right;
}