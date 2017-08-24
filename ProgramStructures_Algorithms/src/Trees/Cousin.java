package Trees;

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
        if (l.getLevelBST(node, a, 1) == l.getLevelBST(node, b, 1)
                && !s.isSibling(node, a, b)
                && s.isSibling(node, a.parent, b.parent)
                )
            return true;

        return false;
    }

    public static void main(String[] args) {
        Cousin c = new Cousin();

        BinaryTree bt = new BinaryTree();
        bt.root = bt.insert(bt.root, 10);
        bt.root = bt.insert(bt.root, 9);
        bt.root = bt.insert(bt.root, 19);
        bt.root = bt.insert(bt.root, -5);
        bt.root = bt.insert(bt.root, 17);
        bt.root = bt.insert(bt.root, 21);

        Inorder inOrder = new Inorder();
        System.out.println("Inorder traversal of tree :");
        inOrder.inorderRecursive(bt.root);
        System.out.println("");

        Node a =  bt.root.left.left;
        Node b = bt.root.right.right;
        System.out.println("Are " + a.data + " & " + b.data + " cousins?: " + c.areCousins(bt.root,a,b));


    }
}
