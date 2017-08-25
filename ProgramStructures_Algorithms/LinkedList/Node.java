package LinkedList;

/**
 * Created by neha on 2/28/2017.
 */
public class Node {

    public int data;
    public Node next;

    private Node(){}

    public Node(int data){
        this.data=data;
        this.next=null;

    }

    public int getElement(){
        return data;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node n){
        next = n;
    }


}
