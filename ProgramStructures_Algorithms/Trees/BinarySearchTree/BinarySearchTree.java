package Trees.BinarySearchTree;

import Trees.BinaryTree.BinaryTree;

/**
 * Created by neha on 2/14/2017.
 */
public class BinarySearchTree {

    public Node getRoot() {
        return root;
    }

    private Node root;
    BinarySearchTree(){
        root = null;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public void insert01(int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            return;
        }

        Node parent = null;
        Node current = root;

        while (current != null) {
            parent = current;
            if (current.data > data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
            if(parent.data > data){
                parent.left = newNode;
            }else{
                parent.right = newNode;
            }

    }

    public void printBST(Node node){
        if (node != null){
            printBST(node.left);
            System.out.print(node.data + " ");
            printBST(node.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert01(10);
        bst.insert01(7);
        bst.insert01(5);
        bst.insert01(8);
        bst.insert01(17);

        bst.printBST(bst.getRoot());
    }
}
