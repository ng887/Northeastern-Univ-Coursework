package Trees.BinaryTree;


import Trees.BinarySearchTree.BinarySearchTree;


/**
 * Created by neha on 2/15/2017.
 *
 * 2 Nodes are cousins if:
 *  - are at same level
 *  - are not siblings
 *  - their parents are siblings
 */


public class Cousin {
        Level l = new Level();
        Sibling s = new Sibling();
    public boolean areCousins(Node node, Node a, Node b){
        if (l.getLevel(node, a, 1) == l.getLevel(node, b, 1)
                && !s.isSibling(node, a, b)
                && s.isSibling(node, a.parent, b.parent)
                )
            return true;

        return false;
    }

    public static void main(String[] args) {
        Cousin c = new Cousin();
        BinaryTree bt = new BinaryTree();

        System.out.println("The inorder traversal of tree: ");
        bt.display(bt.root);
        System.out.println();
        bt.printTree();
        Node a =  bt.root.left.left.left;
        Node b =  bt.root.right.right;
        System.out.println("Are " + a.data + " & " + b.data + " cousins?: " + c.areCousins(bt.root,a,b));


    }
}
