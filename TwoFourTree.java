public class TwoFourTree {
    private class TwoFourTreeItem {
        int values = 1;
        int value1 = 0;                             // always exists.
        int value2 = 0;                             // exists iff the node is a 3-node or 4-node.
        int value3 = 0;                             // exists iff the node is a 4-node.
        boolean isLeaf = true;
        
        TwoFourTreeItem parent = null;              // parent exists iff the node is not root.
        TwoFourTreeItem leftChild = null;           // left and right child exist iff the note is a non-leaf.
        TwoFourTreeItem rightChild = null;          
        TwoFourTreeItem centerChild = null;         // center child exists iff the node is a non-leaf 3-node.
        TwoFourTreeItem centerLeftChild = null;     // center-left and center-right children exist iff the node is a non-leaf 4-node.
        TwoFourTreeItem centerRightChild = null;

        // Check if the node is a 2-node
        public boolean isTwoNode() {
            return values == 1 && leftChild != null && rightChild != null && centerLeftChild == null && centerChild == null && centerRightChild == null;
        }

        // Check if the node is a 3-node
        public boolean isThreeNode() {
            return values == 2 && leftChild != null && rightChild != null && centerLeftChild == null && centerChild == null && centerRightChild == null;
        }

        // Check if the node is a 4-node
        public boolean isFourNode() {
            return values == 1 && leftChild != null && rightChild != null && centerChild != null && centerChild != null&& centerLeftChild != null  && centerRightChild == null;
        }

        // Check if the node is the root
        public boolean isRoot() {
            return parent == null;
        }

        // Constructor for a 2-node
        public TwoFourTreeItem(int value1) {
            this.value1 = value1;
            values = 1;

            leftChild = null;
            rightChild = null;
            centerChild = null;
            centerRightChild = null;
            centerLeftChild = null;
            isLeaf = true;
        }

        // Constructor for a 3-node
        public TwoFourTreeItem(int value1, int value2) {
            this.value1 = value1;
            this.value2 = value2;
            values = 2;

            leftChild = null;
            rightChild = null;
            centerChild = null;
            centerRightChild = null;
            centerLeftChild = null;
            isLeaf = true;
        }

        // Constructor for a 4-node
        public TwoFourTreeItem(int value1, int value2, int value3) {
            this.value1 = value1;
            this.value2 = value2;
            this.value3 = value3;
            values = 3;

            leftChild = null;
            rightChild = null;
            centerChild = null;
            centerRightChild = null;
            centerLeftChild = null;
            isLeaf = true;
        }

        // Print indents for formatting
        private void printIndents(int indent) {
            for(int i = 0; i < indent; i++) System.out.printf("  ");
        }

        // Print the tree in order with indentation
        public void printInOrder(int indent) {
            if(!isLeaf) leftChild.printInOrder(indent + 1);
            printIndents(indent);
            System.out.printf("%d\n", value1);
            if(isThreeNode()) {
                if(!isLeaf) centerChild.printInOrder(indent + 1);
                printIndents(indent);
                System.out.printf("%d\n", value2);
            } else if(isFourNode()) {
                if(!isLeaf) centerLeftChild.printInOrder(indent + 1);
                printIndents(indent);
                System.out.printf("%d\n", value2);
                if(!isLeaf) centerRightChild.printInOrder(indent + 1);
                printIndents(indent);
                System.out.printf("%d\n", value3);
            }
            if(!isLeaf) rightChild.printInOrder(indent + 1);
        }
    }

    TwoFourTreeItem root = null;

    // Add a value to the tree
    public boolean addValue(int value) {
        return false;
    }

    // Check if the tree contains a value
    public boolean hasValue(int value) {
        return false;
    }

    // Delete a value from the tree
    public boolean deleteValue(int value) {
        return false;
    }

    // Print the tree in order
    public void printInOrder() {
        if(root != null) root.printInOrder(0);
    }

    // Constructor for the TwoFourTree
    public TwoFourTree() {
        root = null;
    }
}