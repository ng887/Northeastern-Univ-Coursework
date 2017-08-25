package Trees.BinarySearchTree;

/**
 * Created by neha on 3/13/2017.
 */
public class FixBST {

    Node pre;
    Node first;
    Node second;

    private void inorder(Node root){

        if (root == null){
            return;
        }

        inorder(root.left);

        if(pre == null){
            pre = root;
        }else{
            if(root.data < pre.data){
                if(first == null){
                    first = pre;
                }
                 second = root;
            }
            pre = root;
        }

        inorder(root.right);
    }

    public void fixBstTwoNodesSwap(Node root){
        if (root == null){
            return;
        }

        inorder(root);
        if(second == null && first == null)
        {
            return;
        }
        int temp = second.data;
        second.data = first.data;
        first.data = temp;

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        FixBST tree = new FixBST();
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(20);
        root.right = new Node(8);

        System.out.println("BST before 2 nodes fixed:");
        bst.printBST(root);
        tree.fixBstTwoNodesSwap(root);
        System.out.println("\nBST after 2 nodes fixed:");
        bst.printBST(root);


    }
}
