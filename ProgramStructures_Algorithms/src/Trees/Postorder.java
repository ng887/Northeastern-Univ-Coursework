package Trees;

/**
 * Created by neha on 2/6/2017.
 */
public class Postorder {

    public void postorderRecursive(Node root){
        if(root == null) return;


        postorderRecursive( root.left );
        postorderRecursive( root.right);
        System.out.print(root.data + " ");

    }

    public static void main(String[] args) {
        Postorder p = new Postorder();
        Tree t = new Tree();
        t.printTree();

        System.out.println("Postorder Tree: ");
        p.postorderRecursive(t.root);
    }
}
