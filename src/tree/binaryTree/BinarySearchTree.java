package tree.binaryTree;

import tree.binaryTree.BinaryNode;

public class BinarySearchTree<T extends Comparable<? super T>> {
    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty () {
        return root == null;
    }

    public boolean contains (T x) {
        return contains(x, root);
    }

    public T findMin() {
        if (isEmpty()) throw new NullPointerException();
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty()) throw new NullPointerException();
        return findMax(root).element;
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public void remove (T x) {
        root = remove(x, root);
    }

    public void print() {
        if (root != null) {
            print(root);
        }
    }

    private boolean contains (T x, BinaryNode<T> root) {
        if (root == null) {
            return false;
        }
        int compareResult = x.compareTo(root.element);
        if (compareResult < 0) {
            return contains(x, root.left);
        }
        else if (compareResult > 0) {
            return contains(x, root.right);
        } else {
            return true;
        }
    }

    /**
     * 递归方式findMin
     * @param t
     * @return
     */
    private BinaryNode<T> findMin (BinaryNode<T> t) {
        if (t == null) {
            return null;
        }
        else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    /**
     * 迭代方式findMax
     * @param t
     * @return
     */
    private BinaryNode<T> findMax (BinaryNode<T> t) {
        if (t != null) {
            while(t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    /**
     * 递归方式插入
     * @param x
     * @param t
     * @return
     */
    private BinaryNode<T> insert(T x, BinaryNode<T> t) {
        if (t == null) {
            return new BinaryNode<>(x, null, null);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        }
        return t;
    }

    /**
     * 递归方式删除
     * @param x
     * @param t
     * @return
     */
    private BinaryNode<T> remove(T x, BinaryNode <T> t) {
        if(t == null) return t;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        }
        //存在左右子树时, 使用右子树的最小值作为新的值, 然后删除右子树中最小值
        else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left: t.right;
        }
        return t;
    }

    private void print(BinaryNode<T> t) {
        if (t != null) {
            print(t.left);
            System.out.println(t.element);
            print(t.right);
        }
    }
}