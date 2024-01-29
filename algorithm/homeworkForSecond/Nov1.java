package homeworkForSecond;

import java.util.Arrays;

public class Nov1 {
    public static void main(String[] args) throws Exception {
        bst<Integer> bst = new bst<>();
        bst.add(3);
        bst.add(4);
        for (int i = 0; i < 6; i++) {
            bst.add(i);
        }
        System.out.println(bst.remove(4));
    }
}

class TreeNode<E> {
    TreeNode<E> left;
    TreeNode<E> right;
    TreeNode<E> par;
    E val;

    public TreeNode(E val) {
        this.val = val;
        left = null;
        right = null;
        par = null;
    }

    public String toString() {
        return val.toString();
    }
}

class bst<E> {
    private TreeNode<E> root;

    public bst() {
        this.root = null;
    }

    public bst(TreeNode<E> root) {
        this.root = root;
    }

    public bst(E[] pre, E[] in) throws Exception {
        if (pre.length != in.length)
            throw new Exception("Arrays' length should be equal");
        this.root = buildTree(pre, in);
    }

    private TreeNode<E> buildTree(E[] pre, E[] in) {
        if (pre.length == 0)
            return null;
        E rootVal = pre[0];
        TreeNode<E> root = new TreeNode<E>(rootVal);
        int inRootIdx = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i].equals(rootVal)) {
                inRootIdx = i;
                break;
            }
        }
        E[] preL = Arrays.copyOf(pre, 0);
        E[] inL = Arrays.copyOf(in, 0);
        E[] preR = Arrays.copyOf(pre, 0);
        E[] inR = Arrays.copyOf(in, 0);
        if (inRootIdx > 0) {
            preL = Arrays.copyOfRange(pre, 1, inRootIdx + 1);
            inL = Arrays.copyOfRange(in, 0, inRootIdx);
        }
        if (inRootIdx < in.length) {
            preR = Arrays.copyOfRange(pre, inRootIdx + 1, pre.length);
            inR = Arrays.copyOfRange(in, inRootIdx + 1, in.length);
        }

        root.left = buildTree(preL, inL);
        root.right = buildTree(preR, inR);
        return root;
    }

    public TreeNode<E> search(E val) {
        TreeNode<E> node = root;
        while (node != null && node.val != val) {
            if (compare(val, node.val) < 0)
                node = node.left;
            else
                node = node.right;
        }
        return node;
    }

    public void add(E element) {
        TreeNode<E> node = new TreeNode<E>(element);
        if (root == null) {
            root = node;
            return;
        }
        TreeNode<E> cur = root;
        TreeNode<E> par = root;
        int comp = 0;
        while (cur != null) {
            comp = compare(element, cur.val);
            par = cur;
            if (comp > 0) {
                cur = cur.right;
            } else if (comp < 0) {
                cur = cur.left;
            } else {
                return;
            }
        }
        node.par = par;
        if (comp > 0)
            par.right = node;
        else
            par.left = node;

    }

    public void transplant(TreeNode<E> node1, TreeNode<E> node2) {
        if (node1.par == null)
            root = node2;
        else if (node1.par.left == node1) {
            node1.left = node2;
        } else {
            node1.right = node2;
        }
        node2.par = node1.par;
    }

    // public TreeNode<E> remove1(E val) throws Exception {
    //     return remove1(root, val);
    // }

    // private TreeNode<E> remove1(TreeNode<E> root, E val) {
    //     TreeNode<E> node = search(val);
    //     if (node.left == null)
    //         transplant(node, node.right);
    //     else if (node.right == null)
    //         transplant(node, node.left);
    //     else {
    //         TreeNode<E> y = Minimum(node);
    //     }
    // }

    public TreeNode<E> remove(E val) throws Exception {
        return remove(root, val);
    }

    private TreeNode<E> remove(TreeNode<E> root, E val) {
        if (root == null)
            return null;
        if (compare(val, root.val) < 0)
            root.left = remove(root.left, val);
        else if (compare(val, root.val) > 0)
            root.right = remove(root.right, val);
        else {
            if (root.right == null)
                return root.left;
            if (root.left == null)
                return root.right;
            TreeNode<E> successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.right = remove(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
        return root;
    }

    public TreeNode<E> successor(TreeNode<E> node) {
        if (node != null && node.right != null)
            return Minimum(root.right);
        TreeNode<E> par = node.par;
        while (par != null && compare(node.val, par.val) > 0) {
            par = par.par;
        }
        return par;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode<E> root) {
        if (root == null)
            return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);

    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode<E> root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode<E> root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode<E> root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public TreeNode<E> Maximum() {
        return Maximum(root);
    }

    private TreeNode<E> Maximum(TreeNode<E> root) {
        if (root == null || root.right == null)
            return root;
        return Maximum(root.right);
    }

    public TreeNode<E> Minimum() {
        return Minimum(root);
    }

    private TreeNode<E> Minimum(TreeNode<E> root) {
        if (root == null || root.left == null)
            return root;
        return Minimum(root.left);
    }

    @SuppressWarnings("unchecked")
    private int compare(E e1, E e2) {
        return ((Comparable<E>) e1).compareTo(e2);
    }
}