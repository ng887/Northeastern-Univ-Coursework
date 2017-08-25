package Trees.BinaryTree;

import java.util.HashSet;

/**
 * Created by neha on 2/10/2017.
 *
 */
public class LowestCommonAncestor {

   // Method 1:
    /*
    Take one node and follow its parent link till we face null.
    Keep on putting each node in a hashset.
    Next take another node and follow its parent link and keep on checking each node in the hashset.
    when it finds a match in hashset, that very node is the lowest common ancestor.
     */

    public Node lca (Node node1, Node node2){
        HashSet<Node> set = new HashSet<Node>();

        while (node1 != null)
        {
            set.add(node1);
            node1 = node1.parent;
        }

        while (node2 !=null){
            if(set.contains(node2)){
                return node2;
            }
            else{
                node2 = node2.parent;
            }
        }
        return null;
    }

    //Method 2: Recursive
    public Node lcaRecursive(Node root, Node node1, Node node2){
        if (root == null){
            return null;
        }

        if(root == node1 || root == node2){
            return root;
        }

        Node left =  lcaRecursive(root.left, node1 , node2);
        Node right =  lcaRecursive(root.right, node1 , node2);

        if(left != null && right != null){
            return root;
        }

        if(left == null && right == null){
            return null;
        }

        return left != null ? left : right;

    }


    public static void main(String[] args) {
        LowestCommonAncestor lc = new LowestCommonAncestor();
        Node node1, node2, lca, lcaR;
        BinaryTree bt = new BinaryTree();
        bt.insert(20);
        bt.insert(8);
        bt.insert(22);
        bt.insert(4);
        bt.insert(12);
        bt.insert(10);
        bt.insert(14);

        node1 = bt.root.left.right.left;
        node2 = bt.root.left;
        lca = lc.lca(node1, node2);
        lcaR = lc. lcaRecursive(bt.root,node1,node2);

        System.out.println("LCA of " + node1.data + " and " + node2.data
                + " is " + lca.data);

        System.out.println("Recursive LCA of " + node1.data + " and " + node2.data
                + " is " + lcaR.data);
    }
}

