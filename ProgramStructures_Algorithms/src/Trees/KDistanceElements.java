package Trees;

/**
 * Created by neha on 2/7/2017.
 */
public class KDistanceElements {

    public void printNodesKDistance(Node root,int k){
        printNodesKDistanceHelper(root,k);
    }

    private void printNodesKDistanceHelper(Node node, int k) {
        if (node == null)
            return;

        if(k==0){
            System.out.print(node.data + " ");
            return;
        }
        printNodesKDistanceHelper(node.left,k-1);
        printNodesKDistance(node.right, k-1);
    }

    public static void main(String[] args) {
        KDistanceElements k = new KDistanceElements();
        Tree t = new Tree();
        t.printTree();

        k.printNodesKDistance(t.root,2);
    }
}
