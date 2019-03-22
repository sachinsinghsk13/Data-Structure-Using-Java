package trees;

public class BinarySearchTree {

    public static Node insert(Node loc, int key) {
        if (loc == null)
            return new Node(key);
        else if (key < loc.key)
            loc.left = insert(loc.left, key);
        else if (key > loc.key)
            loc.right = insert(loc.right, key);
        else
            System.out.println("Duplicate Key");
        return loc;
    }

    public static Node getNode(Node loc, int key) {
        if (loc == null)
            return null;
        else if (key == loc.key)
            return loc;
        else if (key < loc.key)
            return getNode(loc.left, key);
        else
            return getNode(loc.right, key);
    }

    public static Node removeNode(Node loc, int key) {
        if (loc == null) {
            System.out.println("Key Not Found");
            return loc;
        } else if (key == loc.key) {
            if (loc.left == null && loc.right == null) { // External BinaryTreeNode
                return null;

            } else if (loc.left == null || loc.right != null) { // BinaryTreeNode has only right child
                return loc.right;

            } else if (loc.left != null || loc.right == null) { // BinaryTreeNode has only left child
                return loc.left;
            } else { // BinaryTreeNode has both childs
                Node largestKeyNode = getLargestKeyNode(loc.left);
                loc.key = largestKeyNode.key;
                loc.left = removeNode(loc.left, loc.key);
                return loc;
            }
        } else if (key < loc.key) {
            loc.left = removeNode(loc.left, key);
            return loc;
        } else {
            loc.right = removeNode(loc.right, key);
            return loc;
        }
    }

    public static int getHeight(Node node) {
        if (node == null)
            return 0;
        else
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static int totalNode(Node loc) {
        if (loc == null)
            return 0;
        else return totalNode(loc.left) + totalNode(loc.right) + 1;
    }

    private static Node getLargestKeyNode(Node node) {
        if (node == null || node.right == null)
            return node;
        else
            return getLargestKeyNode(node.right);
    }

}