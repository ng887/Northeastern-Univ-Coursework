package Trees.BinarySearchTree;

/**
 * Created by neha on 3/14/2017.
 */

/*
Once the node for which is found in the tree the
successor will be the left most node in right sub­tree
predecessor will be the right most node in left sub­tree */

public class PredecessorSuccessor {
    static int successor, predecessor;

    public void findPredecessorSuccessor(Node root, int val){

        if(root != null) {
            if (root.data == val) {

                if (root.left != null) {
                    Node temp = root.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    predecessor = temp.data;
                }
                if (root.right != null) {
                    Node temp = root.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    successor = temp.data;
                }

            } else if (root.data > val) {
                successor = root.data;
                findPredecessorSuccessor(root.left, val);

            } else if (root.data < val) {
                predecessor = root.data;
                findPredecessorSuccessor(root.right, val);
            }
        }
    }

    public static void main(String[] args) {
        PredecessorSuccessor tree = new PredecessorSuccessor();
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        bst.insert(8);
        bst.insert(4);
        bst.insert(12);
        bst.insert(22);

        int nodeVal = 12;
        tree.findPredecessorSuccessor(bst.getRoot(),nodeVal);
        System.out.println("The predecessor of " + nodeVal + " is: " + predecessor + " and successor is: " + successor );

    }

}
