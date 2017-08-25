package Trees.BinarySearchTree;

/**
 * Created by neha on 3/9/2017.
 */
class Sum{
    int sum = 0;
}

public class GreaterNodes {
    Sum s = new Sum();
    public Node addGreaterNodes(Node node){
        addGreaterNodesHelper(node,s);
        return node;
    }

    void addGreaterNodesHelper(Node node , Sum totalSum){
        if(node == null){
            return;
        }
        addGreaterNodesHelper(node.getRight(),totalSum);
        totalSum.sum = totalSum.sum + node.data;
        node.data = totalSum.sum;
        addGreaterNodesHelper(node.getLeft(),totalSum);

    }

    public static void main(String[] args) {
        GreaterNodes greaterNode = new GreaterNodes();
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        System.out.println("Original BST: ");
        bst.printBST(bst.getRoot());
        System.out.println("\nSum of all greater values of a node in BST: ");
        bst.printBST(greaterNode.addGreaterNodes(bst.getRoot()));


    }
}

