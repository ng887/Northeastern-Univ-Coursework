package Trees.BinaryTree;



/**
 * Created by neha on 2/15/2017.
 */
public class Level {
    public int getLevel(Node root, Node node, int level) {
        if (root == null) {
            return 0;
        }

        if (root == node) {
            return level;
        }

        int left = getLevel(root.left, node, level + 1);

        if (left != 0) {
            return left;
        } else {
            return getLevel(root.right, node, level + 1);
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Level l = new Level();

        System.out.println("The inorder traversal of tree: ");
        bt.display(bt.root);
        System.out.println();
        bt.printTree();
        System.out.println("\nLevel of " + bt.root.left.left.data + " is " + l.getLevel(bt.root, bt.root.left.left,1));
    }
}
