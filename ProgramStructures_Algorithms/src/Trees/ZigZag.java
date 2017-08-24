package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by neha on 2/6/2017.
 */
public class ZigZag {

    public void printZigZag(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        Stack<Node> stack = new Stack<Node>();
        queue.add(root);
        queue.add(null);

        boolean flag = true;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode != null) {

                if (flag) {
                    System.out.print(currentNode.data + " ");
                } else {
                    stack.push(currentNode);
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            } else {
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
                flag = false;

                while (!stack.isEmpty()) {
                    System.out.print(stack.pop().data + " ");
                }
                System.out.println();
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }

    }


    public static void main(String[] args) {
        ZigZag z = new ZigZag();
        Tree t = new Tree();
        t.printTree();

        z.printZigZag(t.root);
    }
}
