package Trees;

import java.util.*;

/**
 * Created by neha on 2/8/2017.
 */
public class BottomView {

    public static TreeMap<Integer, Integer> ht = new TreeMap<>();

    public void getBottomView(Node root){

        if(root == null){
            return;
        }

        HashSet<Integer> set = new HashSet<>();

        Queue<QueueItem> q = new LinkedList<QueueItem>();
        q.add(new QueueItem(root,0));

        while(!q.isEmpty()){
            QueueItem qi = q.remove();
            int hd = qi.horizDistance;
            Node node = qi.node;

            ht.put(hd,node.data);

            if(node.left != null){
                q.add(new QueueItem(node.left,hd -1));
            }
            if(node.right != null){
                q.add(new QueueItem(node.right,hd +1));
            }
        }
    }

    public void printBottomView() {
        Set<Integer> keys = ht.keySet();
        for (Integer key : keys) {
            System.out.print(ht.get(key) + " ");
        }
    }

    public static void main(String[] args) {
        BottomView p = new BottomView();
        Tree t = new Tree();
        t.printTree();

        p.getBottomView(t.root);
        p.printBottomView();

    }
}
