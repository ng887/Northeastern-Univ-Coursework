package Assignments.Assignment_01_Trees;

/**
 * Created by neha on 3/7/2017.
 */
public class Node{

    int data;
    Node left,right;

    public Node(){
        left = null;
        right = null;
        this.data = 0;
    }

    public Node(int data){
        left = null;
        right = null;
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

}
