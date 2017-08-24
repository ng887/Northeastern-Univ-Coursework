package Trees;

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
        Tree t = new Tree();
        t.printTree();

        System.out.println("Inorder Tree: ");
        i.inorderRecursive(t.root);
    }
}
