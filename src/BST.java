import java.util.*;

/**
 * Class for the binary search tree data structure
 * @param <T> type of element to store in the BST
 */
public class BST<T extends Comparable<T>> {

    /** the root node of the BST */
    private BSTNode root;

    /**
     * Creates an empty BST.
     */
    public BST() {
        this.root = null;
    }

    /**
     * Checks whether the BST contains <i>elem</i>
     * @param elem the elemento to check
     * @return true if present; false otherwise
     */
    public boolean contains(T elem) {
        //TODO:
        throw new UnsupportedOperationException("This method is not implemented yet.");
    }

    /**
     * Adds an element to the BST, according to its natural ordering provided by the Comparable interface.
     * If the element already exists, nothing is done.
     * @param elem element to add
     * @throws NullPointerException if an attempt to insert 'null' is made
     */
    public void add(T elem) throws NullPointerException {
        if(elem == null) throw new NullPointerException("Element cannot be null.");

        if(isEmpty()) {
            this.root = new BSTNode(elem, null, null, null);
        } else {
            insertBST(elem, this.root);
        }
    }

    /**
     * Removes an existing element from the BST.
     * @param elem element to remove
     * @throws NoSuchElementException if the element does not exist
     */
    public void remove(T elem) throws NoSuchElementException {
        BSTNode nodeWithElement = searchNodeWithElement(elem, this.root);

        if(nodeWithElement == null) throw new NoSuchElementException("The element does not exist in the BST.");

        //Remove the node based on the three possible scenarios
        BSTNode parent = nodeWithElement.parent;

        //case 1: external node (no subtrees), just remove the node from the tree
        if( nodeWithElement.left == null && nodeWithElement.right == null ) {
            if(parent == null) { //its must be the root node, because it has no parent
                this.root = null;
            } else if( parent.left == nodeWithElement ) {
                parent.left = null;
            } else { //parent.right == treeRoot
                parent.right = null;
            }
        }
        //case 3: has both sub-tree; two possible methods
        //1 - replace node contents with rightmost contents of the left sub-tree (maximum key)
        //2 - replace node contents with leftmost contents of the right sub-tree (minimum key)
        //Following code uses method #2
        else if( nodeWithElement.left != null && nodeWithElement.right != null ) {
            BSTNode minimumRight = getLeftmostNode(nodeWithElement.right);
            //the following order is critical; remove before replacing
            remove(minimumRight.elem);
            nodeWithElement.elem = minimumRight.elem;
        }
        //case 2: only has one sub-tree; replace node with sub-tree
        else {
            //which exists? left or right sub-tree?
            BSTNode subTree = (nodeWithElement.left != null) ? nodeWithElement.left : nodeWithElement.right;

            if(nodeWithElement == this.root) { //it may be the root node
                this.root = subTree;
            } else {
                if( parent.left == nodeWithElement ) {
                    parent.left = subTree;
                } else {
                    parent.right = subTree;
                }
                subTree.parent = parent;
            }
        }
    }

    /**
     * Returns all the elements present in the BST, by IN-ORDER traversal
     * @return collection with all elements
     */
    public Collection<T> elements() {
        //TODO:
        throw new UnsupportedOperationException("This method is not implemented yet.");
    }

    /**
     * Returns the elements which are stored at external nodes
     */
    public Collection<T> externalElements() {
        List<T> col = new ArrayList<>();
        for(T elem : elements()) {
            BSTNode node = searchNodeWithElement(elem, this.root);

            if( isExternal(node) ) {
                col.add(elem);
            }
        }
        return col;
    }

    /**
     * Returns the elements which are stored at internal nodes
     */
    public Collection<T> internalElements() {
        List<T> col = new ArrayList<>();
        for(T elem : elements()) {
            BSTNode node = searchNodeWithElement(elem, this.root);

            if( isInternal(node) ) {
                col.add(elem);
            }
        }
        return col;
    }

    /**
     * Returns the path (collection) to the root, starting at <i>elem</i>
     * @param elem the starting element
     * @return path to root
     */
    public Collection<T> pathToRoot(T elem) {
        //TODO:
        throw new UnsupportedOperationException("This method is not implemented yet.");
    }

    /**
     * Returns the size (number of elements stored) of the BST
     * @return the size of the BST
     */
    public int size() {
        return size(this.root);
    }

    /**
     * Returns the height of the BST
     * @return height of the BST
     */
    public int height() {
        //TODO:
        throw new UnsupportedOperationException("This method is not implemented yet.");
    }

    /**
     * Checks whether the BST is empty
     * @return true if empty; false otherwise
     */
    public boolean isEmpty() {
        //TODO:
        throw new UnsupportedOperationException("This method is not implemented yet.");
    }

    /**
     * Clears the contents of the BST, returning to an empty state
     */
    public void clear() {
        //TODO:
        throw new UnsupportedOperationException("This method is not implemented yet.");
    }

    @Override
    public String toString() {
        if(isEmpty()) return "Empty binary search tree.";

        StringBuilder sb = new StringBuilder();
        inOrderPrettyString(root, new StringBuilder(), true, sb);

        return String.format("MapBST of size = %d:", size())
                + "\n"
                + sb.toString();
    }

    /* private methods */

    private BSTNode searchNodeWithElement(T elem, BSTNode treeRoot) {
        //TODO:
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    private BSTNode getLeftmostNode(BSTNode treeRoot) {
        //TODO (iterative algorithm, not recursive):
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    private boolean isInternal(BSTNode node) {
        //TODO:
        throw new UnsupportedOperationException("This method is not implemented yet.");
    }

    private boolean isExternal(BSTNode node) {
        //TODO:
        throw new UnsupportedOperationException("This method is not implemented yet.");
    }

    private int size(BSTNode treeRoot) {
        if(treeRoot == null) return 0;
        else return 1 + size(treeRoot.left) + size(treeRoot.right);
    }

    private void insertBST(T elem, BSTNode treeRoot) {
        int comparison = elem.compareTo( treeRoot.elem );
        if( comparison == 0) {
            //element already exists, abort operation
            return;
        }
        else if( comparison < 0 ) { //insert into left sub-tree
            if( treeRoot.left == null) {
                treeRoot.left = new BSTNode(elem, treeRoot, null, null);
            }
            else
                insertBST(elem, treeRoot.left); //recursive call
        }
        else { //insert into right sub-tree
            if( treeRoot.right == null) {
                treeRoot.right = new BSTNode(elem, treeRoot, null, null);
            }
            else
                insertBST(elem, treeRoot.right); //recursive call
        }
    }

    private void inOrderPrettyString(BSTNode treeRoot, StringBuilder prefix, boolean isTail, StringBuilder sb) {

        if(treeRoot.right != null) {
            inOrderPrettyString(treeRoot.right, new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }

        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(String.format(" %s", treeRoot.elem.toString())).append("\n");

        if(treeRoot.left != null) {
            inOrderPrettyString(treeRoot.left, new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
    }

    private class BSTNode {
        private T elem;

        private BSTNode parent;
        private BSTNode left;
        private BSTNode right;

        public BSTNode(T elem, BSTNode parent, BSTNode left, BSTNode right) {
            this.elem = elem;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
}
