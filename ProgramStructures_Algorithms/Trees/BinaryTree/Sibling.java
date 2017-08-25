package Trees.BinaryTree;

/**
 * Created by neha on 2/8/2017.
 */
public class Sibling {

    public boolean isSibling(Node node, Node a, Node b) {
        if(node == null){
            return false;
        }
        else{
            return(node.left == a && node.right == b ||
                    node.left == b && node.right == a  ||
                    isSibling(node.left,a,b) ||
                    isSibling(node.right,a,b));
        }
    }

    public static void main(String[] args) {
        Sibling s = new Sibling();
        BinaryTree t = new BinaryTree();
        t.printTree();

        System.out.println( s.isSibling(t.root.left,t.root.left.left,t.root.left.right));
    }
}
