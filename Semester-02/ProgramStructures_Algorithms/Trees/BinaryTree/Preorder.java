package Trees.BinaryTree;

/**
 * Created by neha on 2/6/2017.
 */
public class Preorder {

    public void preorderRecursive(Node root){
        if(root == null) return;

        System.out.print(root.data + ",");
        preorderRecursive( root.left );
        preorderRecursive( root.right);

    }

    public static void main(String[] args) {
        Preorder p = new Preorder();
        BinaryTree t = new BinaryTree();
        t.printTree();

        System.out.println("Preorder BinaryTree: ");
        p.preorderRecursive(t.root);
    }
}
