public class DriverProgram {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert some keys into the binary search tree
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Perform In-order traversal
        System.out.println("In-order traversal:");
        bst.inorderTraversal();

        // Perform Pre-order traversal
        System.out.println("Pre-order traversal:");
        bst.preorderTraversal();

        // Perform Post-order traversal
        System.out.println("Post-order traversal:");
        bst.postorderTraversal();

        // Search for an element from the binary search tree
        System.out.println("Searching for key 40: " + bst.search(40));
        System.out.println("Searching for key 90: " + bst.search(90));

        // Delete some keys from the binary search tree
        bst.delete(20);
        bst.delete(30);

        // Print the tree after deletion
        System.out.println("In-order traversal after deletion:");
        bst.inorderTraversal();
    }
}
