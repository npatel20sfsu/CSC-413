class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // Method to insert a key in BST
    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    // A recursive function to insert a new key in BST
    private TreeNode insertRecursive(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRecursive(root.left, key);
        } else if (key > root.key) {
            root.right = insertRecursive(root.right, key);
        }
        return root;
    }

    // Method to perform inorder traversal of the tree
    public void inorderTraversal() {
        inorderRecursive(root);
        System.out.println();
    }

    // A utility function to do inorder traversal of BST
    private void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.key + " ");
            inorderRecursive(root.right);
        }
    }

    // Method to perform preorder traversal of the tree
    public void preorderTraversal() {
        preorderRecursive(root);
        System.out.println();
    }

    // A utility function to do preorder traversal of BST
    private void preorderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    // Method to perform postorder traversal of the tree
    public void postorderTraversal() {
        postorderRecursive(root);
        System.out.println();
    }

    // A utility function to do postorder traversal of BST
    private void postorderRecursive(TreeNode root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Method to search for a key in the tree
    public boolean search(int key) {
        return searchRecursive(root, key);
    }

    // A utility function to search for a key in BST
    private boolean searchRecursive(TreeNode root, int key) {
        if (root == null || root.key == key) {
            return root != null;
        }
        if (key < root.key) {
            return searchRecursive(root.left, key);
        }
        return searchRecursive(root.right, key);
    }

    // Method to delete a key from the tree
    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    // A utility function to delete a key in BST
    private TreeNode deleteRecursive(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = deleteRecursive(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRecursive(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteRecursive(root.right, root.key);
        }
        return root;
    }

    // A utility function to find the smallest node in a subtree
    private int minValue(TreeNode root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
}
