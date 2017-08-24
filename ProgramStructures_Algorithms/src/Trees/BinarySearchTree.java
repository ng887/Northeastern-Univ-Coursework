package Trees;

/**
 * Created by neha on 2/14/2017.
 */
public class BinarySearchTree {

    public boolean isBSTRecursive (Node root, int min ,int max){
        if(root == null){
            return true;
        }
        if (root.data <= min || root.data > max){
            return false;
        }
        return isBSTRecursive(root.left,min, root.data) && isBSTRecursive(root.right,root.data, max);

    }

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();

        BinaryTree bt = new BinaryTree();
        bt.root = bt.insert(bt.root, 10);
        bt.root = bt.insert(bt.root, 9);
        bt.root = bt.insert(bt.root, 19);
        bt.root = bt.insert(bt.root, -5);
        bt.root = bt.insert(bt.root, 17);
        bt.root = bt.insert(bt.root, 21);

        Inorder inOrder = new Inorder();
        System.out.println("Inorder traversal of tree :");
        inOrder.inorderRecursive(bt.root);
        System.out.println("");

        System.out.println("Is BT a BST? " + b.isBSTRecursive(bt.root, Integer.MIN_VALUE, Integer.MAX_VALUE ));

    }
}
