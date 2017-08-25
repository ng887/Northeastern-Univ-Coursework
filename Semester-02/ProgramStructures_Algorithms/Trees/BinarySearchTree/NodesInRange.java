package Trees.BinarySearchTree;

/**
 * Created by neha on 3/9/2017.
 */
public class NodesInRange {

    public int countNodesInRange(Node node, int low, int high){
        if(node == null){
            return 0;
        }
        if(node.data >= low && node.data <= high){
            System.out.print(node.data+ " ");
            return 1 + countNodesInRange(node.left,low,high) + countNodesInRange(node.right,low,high);
        }
        else if(node.data < low){
            return countNodesInRange(node.right,low,high);
        }else{
            return countNodesInRange(node.left,low,high);
        }
    }

    public static void main(String[] args) {
        NodesInRange nodes = new NodesInRange();
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(9);
        bst.insert(19);
        bst.insert(-5);
        bst.insert(17);
        bst.insert(21);
        System.out.println("Nodes in Range" );
        System.out.println("\nCount is:" + nodes.countNodesInRange(bst.getRoot(),9,19));

    }
}
