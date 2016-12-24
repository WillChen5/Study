package will.study.thread;


import sun.jvm.hotspot.utilities.RBNode;

/**
 * Created by will on 2016/11/26.
 */
public class BRTree<T extends Comparable<T>> {

    private BRNode<T> mRoot;
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    private void lefRotate(BRNode<T> x) {
        BRNode<T> y = x.right;

        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        y.parent = x.parent;
        if (x.parent == null) {
            this.mRoot = y;
        } else {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }

        y.left = x;
        x.parent = y;
    }

    private void rightRotate(BRNode<T> y) {
        BRNode<T> x = y.left;

        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }

        x.parent = y.parent;
        if (y.parent == null) {
            this.mRoot = x;
        } else {
            if (y == y.parent.right) {
                y.parent.right = x;
            } else {
                y.parent.left = x;
            }
        }

        x.right = y;
        y.parent = x;
    }

    private void insert(BRNode<T> node) {
        int cmp;
        BRNode<T> x = null;
        BRNode<T> y = null;

        while (x != null) {
            y = x;
            cmp = node.key.compareTo(y.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y != null) {
            cmp = node.key.compareTo(y.key);
            if (cmp < 0) {
                y.left = node;
            } else {
                y.right = node;
            }
        } else {
            this.mRoot = node;
        }

        node.color = RED;
        insertFixUp(node);
    }

    private void insertFixUp(BRNode<T> node) {
        BRNode<T> parent, gparent;

        while (((parent = parentOf(node)) != null) && isRed(parent)) {
            gparent = parentOf(parent);

            if (parent == gparent.left) {

            }
        }
    }

    private BRNode<T> parentOf(BRNode<T> node) {
        return node.parent;
    }

    private boolean isRed(BRNode<T> node) {
        return !node.color;
    }

    public class BRNode<T extends Comparable<T>> {
        boolean color;
        T key;
        BRNode<T> left;
        BRNode<T> right;
        BRNode<T> parent;

        public BRNode(boolean color, T key, BRNode<T> left, BRNode<T> right, BRNode<T> parent) {
            this.color = color;
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
