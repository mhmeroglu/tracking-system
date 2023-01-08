public class BST {
    //Node Class
    static class Node {
        int ID;
        String name;
        int piece;
        Node left, right;

        public Node(int ID, String name, int piece) {
            this.ID = ID;
            this.name = name;
            this.piece = piece;
        }
    }

    // BST root node
    Node root;

    //BST constructor
    public BST() {
        root = null;
    }

    //for calling the method
    void createProduct(Node node) {
        root = createProductHelper(root, node);
    }

    Node createProductHelper(Node root, Node node) {
//--------------------------------------------------------
// Summary:In this function we create product and
// store it in binary search tree.
// Precondition: node and root is a Node.
// Postcondition: Values are recursively defined to nodes.
//--------------------------------------------------------
        int data = node.ID;
        if (root == null) {
            root = node;
            return root;
        } else if (data < root.ID) {
            root.left = createProductHelper(root.left, node);
        } else {
            root.right = createProductHelper(root.right, node);
        }
        return root;
    }

    //for calling the method
    void printProduct(int ID) {
        printProductHelper(root, ID);
    }

    void printProductHelper(Node root, int ID) {
//--------------------------------------------------------
// Summary:In this function we print product information's
// Precondition: root is a Node and ID is integer.
// Postcondition: Values are printed recursively.
//--------------------------------------------------------
        if (root == null) {
            System.out.println("Couldn't find any captain with ID number " + ID);
        } else if (root.ID == ID) {
            System.out.println();
            System.out.println("                      ID: " + root.ID);
            System.out.println("                      Name: " + root.name);
            System.out.println("                      Piece: " + root.piece);
        } else if (root.ID > ID) {
            printProductHelper(root.left, ID);
        } else {
            printProductHelper(root.right, ID);
        }
    }

    //for calling the method
    void isAvailable(int ID) {
        isAvailableHelper(root, ID);
    }

    void isAvailableHelper(Node node, int ID) {
//--------------------------------------------------------
// Summary: This method shows if the product is in stock.
// Precondition: root is a Node and ID is integer.
// Postcondition: Printed by recursively checking to see if it is in stock.
//--------------------------------------------------------
        if (node == null) {
            System.out.println("The product is out of stock!!! \n");
        } else if (node.ID == ID) {
            if (node.piece == 0)
                System.out.println("The product is out of stock!!! \n");

            else
                System.out.println("There are " + node.piece + " products \n");
        } else if (node.ID > ID) {
            isAvailableHelper(node.left, ID);
        } else {
            isAvailableHelper(node.right, ID);
        }
    }
}
