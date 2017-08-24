package Trees;

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
        Inorder inOrder = new Inorder();

        BinarySearchTree b = new BinarySearchTree();

        BinaryTree bt = new BinaryTree();
        bt.root = bt.insert(bt.root, 10);
        bt.root = bt.insert(bt.root, 9);
        bt.root = bt.insert(bt.root, 19);
        bt.root = bt.insert(bt.root, -5);
        bt.root = bt.insert(bt.root, 17);
        bt.root = bt.insert(bt.root, 21);


        System.out.println("Inorder traversal of tree :");
        inOrder.inorderRecursive(bt.root);
        System.out.println("");

        int target = 6;
        System.out.println("Node closest to "+ target + " is " + cn.GetClosestValue(bt.root,target));
        System.out.println("");

    }
}
