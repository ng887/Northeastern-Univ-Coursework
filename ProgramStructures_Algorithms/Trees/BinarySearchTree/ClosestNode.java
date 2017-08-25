package Trees.BinarySearchTree;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.Inorder;
import Trees.BinarySearchTree.Node;

/**
 * Created by neha on 2/14/2017.
 */
public class ClosestNode {
    int min = Integer.MAX_VALUE;
    int result;

    public int GetClosestValue(Node root, int target){

        GCVHelper(root,target);
        return result;
    }

    private void GCVHelper(Node root, int target) {

        if (root == null)
            return;
        if (Math.abs(root.data - target) < min){
            min = Math.abs(root.data - target);
            result = root.data;
        }

        if (target < result){
            GCVHelper(root.left,target);
        }
        else{
            GCVHelper(root.right,target);

        }

    }
    public static void main(String[] args) {
        ClosestNode cn = new ClosestNode();

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(9);
        bst.insert(19);
        bst.insert(-5);
        bst.insert(17);
        bst.insert(21);

        int target = 6;
        System.out.println("The inorder traversal of BST: ");bst.printBST(bst.getRoot());
        System.out.println("\nNode closest to "+ target + " is " + cn.GetClosestValue(bst.getRoot(),target));


    }
}
