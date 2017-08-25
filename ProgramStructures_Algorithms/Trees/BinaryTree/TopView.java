package Trees.BinaryTree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by neha on 2/8/2017.
 */
public class TopView {

    public void printTopView(Node root){
         if (root == null){
             return;
        }

        HashSet<Integer> set = new HashSet<>();

        Queue<QueueItem> q= new LinkedList<QueueItem>();
        q.add(new QueueItem(root,0));

        while(!q.isEmpty()){
            QueueItem qi = q.remove();
            int hd = qi.horizDistance;
            Node node = qi.node;

            if(!set.contains(hd)){
                set.add(hd);
                System.out.print(node.data + " ");
            }

            if(node.left != null){
                q.add(new QueueItem(node.left,hd -1));
            }
            if(node.right != null){
                q.add(new QueueItem(node.right,hd +1));
            }

        }
    }

    public static void main(String[] args) {
        TopView p = new TopView();
        BinaryTree t = new BinaryTree();
        t.printTree();

        p.printTopView(t.root);

    }

}
