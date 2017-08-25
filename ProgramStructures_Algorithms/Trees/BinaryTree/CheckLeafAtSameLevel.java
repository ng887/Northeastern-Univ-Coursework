package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by neha on 3/7/2017.
 */
public class CheckLeafAtSameLevel {


     public void checkLevelByLevel(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        int leafLevel = 0;
        int level = 0;

        while(!queue.isEmpty()){
            Node currentNode =  queue.poll();

            if(currentNode != null){
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                if(currentNode.left == null && currentNode.right == null && leafLevel == 0){
                    leafLevel = level;
                }else if(currentNode.left == null && currentNode.right == null && leafLevel != level){
                    System.out.println("Leaves not at the same level");
                    return;
                }

            }
            else{
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
                level ++;
            }

        }

        System.out.println("Leaves at the same level");

    }

    public static void main(String[] args) {
        CheckLeafAtSameLevel cl = new CheckLeafAtSameLevel();
        Node root1;
        root1 = new Node(12);
        root1.left = new Node(5);
        root1.left.left = new Node(3);
        root1.left.right = new Node(9);
        root1.left.left.left = new Node(1);
        //root1.left.right.left = new Node(1);

        cl.checkLevelByLevel(root1);


    }
}
