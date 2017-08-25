package Assignments.Quiz;
/**
 * Created by neha on 3/22/2017.
 */
public class Node {


    public int data;
    public Node left;
    public Node right;
    public Node parent;

    Node(){
        left = null;
        right = null;
        parent = null;
        this.data = 0;
    }

    Node(int data){
        left = null;
        right = null;
        parent = null;
        this.data = data;
    }

}
