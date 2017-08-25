package Trees.BinaryTree;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by neha on 3/18/2017.
 */
public class InvertTree {
    public Node invertTree(Node root) {
        if (root == null) return null;
        Queue<Node> q = new LinkedList();
        q.add(root);

        Node cur = null;
        while(!q.isEmpty()){
            cur= q.poll();

                if (cur.right != null) {
                    q.add(cur.right);
                }
                if (cur.left != null) {
                    q.add(cur.left);
                }

            Node temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
        }
        return root;
    }

    public static void main(String[] args) {
        InvertTree it = new InvertTree();
        BinaryTree t = new BinaryTree();
        t.printTree();
        t.display(t.root);
        System.out.println();
        t.display(it.invertTree(t.root));
    }
}
//[4,2,7,1,3,6,9]
 //       [4,7,2,9,6,3,1]