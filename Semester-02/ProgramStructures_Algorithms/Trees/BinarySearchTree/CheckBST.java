package Trees.BinarySearchTree;

/**
 * Created by neha on 3/7/2017.
 */
public class CheckBST {
    public boolean isBSTRecursive (Node root, int min , int max){
        if(root == null){
            return true;
        }
        if (root.data <= min || root.data > max){
            return false;
        }
        return isBSTRecursive(root.left,min, root.data) && isBSTRecursive(root.right,root.data, max);

    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        CheckBST check = new CheckBST();

        bst.insert( 10);
        bst.insert( 9);
        bst.insert( 19);
        bst.insert( -5);
        bst.insert( 17);
        bst.insert( 21);

        System.out.println("The inorder traversal of BST: ");bst.printBST(bst.getRoot());
        System.out.println("\nIs BT a BST? " + check.isBSTRecursive(bst.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE ));

    }
}
