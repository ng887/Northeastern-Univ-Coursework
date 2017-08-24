package Trees;

/**
 * Created by neha on 2/6/2017.
 */
public class Perimeter {


    public void printPerimeter(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data + " ");
        printPerimeter(root, 0, 0);
    }

    private void printPerimeter(Node node, int left, int right) {
        if(node == null){
            return;
        }

        int l = left;
        int r= right;

        if(l != 0 && r == 0 ){
            System.out.print(node.data + " ");
        }
        else if( l == 0 && r != 0){
            System.out.print(node.data + " ");
        }
        else if( node.left == null && node.right == null) {
            System.out.print(node.data + " ");
        }
        printPerimeter(node.left,l+1,r);
        printPerimeter(node.right,l, r+1);
    }

    public static void main(String[] args) {
        Perimeter p = new Perimeter();
        Tree t = new Tree();
        t.printTree();

        p.printPerimeter(t.root);
    }
}
