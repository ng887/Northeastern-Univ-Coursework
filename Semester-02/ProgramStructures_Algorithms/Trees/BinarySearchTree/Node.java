package Trees.BinarySearchTree;

/**
 * Created by neha on 2/6/2017.
 */
public class Node {



    public int data;
    public Node left;
    public Node right;
    public Node parent;

    public Node(){
        left = null;
        right = null;
        parent = null;
        this.data = 0;
    }

    public Node(int data){
        left = null;
        right = null;
        parent = null;
        this.data = data;
    }


    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {    return parent;  }

    public void setParent(Node parent) { this.parent = parent;     }

}
