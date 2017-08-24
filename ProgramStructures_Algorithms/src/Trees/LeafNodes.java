package Trees;

/**
 * Created by neha on 2/7/2017.
 */
public class LeafNodes {
    public void printLeafNodes(Node root){
        printLeafNodesHelper(root);
    }

    private void printLeafNodesHelper(Node node){
        if(node !=  null){
            printLeafNodesHelper(node.left);
            printLeafNodesHelper(node.right);

            if(node.left == null && node.right == null) {
                System.out.print(node.data + " ");
            }
        }

    }

    public static void main(String[] args) {
       LeafNodes l = new LeafNodes();
        Tree t = new Tree();
        t.printTree();

        l.printLeafNodes(t.root);
    }
}
