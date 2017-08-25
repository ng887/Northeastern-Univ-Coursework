package Trees.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by neha on 2/6/2017.
 */
public class LevelByLevel {

    public void printLevelByLevelOneQueue(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            Node currentNode =  queue.poll();

            if(currentNode != null){
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                System.out.print(currentNode.data + " ");
            }
            else{
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
                System.out.println();
            }

        }

    }

    public static void main(String[] args) {
        LevelByLevel l = new LevelByLevel();
        BinaryTree t = new BinaryTree();
        t.printTree();

        l.printLevelByLevelOneQueue(t.root);

    }
}
