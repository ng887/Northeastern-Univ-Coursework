package Trees.BinaryTree;

/**
 * Created by neha on 2/6/2017.
 */
public class Inorder {

    public void inorderRecursive(Node root){
        if(root == null) return;


        inorderRecursive( root.left );
        System.out.print(root.data + " ");
        inorderRecursive( root.right);

    }

    public static void main(String[] args) {
        Inorder i = new Inorder();
        BinaryTree t = new BinaryTree();
        t.printTree();

        System.out.println("Inorder BinaryTree: ");
        i.inorderRecursive(t.root);
    }
}
