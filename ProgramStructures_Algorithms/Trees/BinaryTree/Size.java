package Trees.BinaryTree;

/**
 * Created by neha on 2/6/2017.
 */
public class Size {


    public int getSize(Node node){
        if (node == null){
            return 0;
        }
        else{
            return getSize(node.left) + 1 + getSize(node.right);
        }

    }

    public static void main(String[] args) {
        Size s = new Size();
        BinaryTree t = new BinaryTree();
        t.printTree();

        System.out.println("Size of tree is " + s.getSize(t.root));

    }
}
