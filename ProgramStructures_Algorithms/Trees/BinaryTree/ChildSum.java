package Trees.BinaryTree;

/**
 * Created by neha on 2/7/2017.
 *
 * For every node, data value must be equal to sum of data values in left and right children. Consider data value as 0 for NULL children.
 *          10
 *         /   \
 *        8    2
 *      / \    /
 *      5 3   2
 *
 */
public class ChildSum {

    /*Calculate sum of children */
    public boolean isChildSum(Node root){
        return isChildSumHelper(root);
    }

    private boolean isChildSumHelper(Node node) {
        if(node == null || node.left == null  && node.right == null){
            return true;
        }
       int left = 0;
        int right = 0;

        if(node.left !=null){
            left = node.left.data;
        }
        if(node.right !=null){
            right = node.right.data;
        }

        if(node.data == left+right
           && isChildSumHelper(node.left)
           && isChildSumHelper(node.right)){
            return true;
        }
        return false;
    }


    /* Calculate reverse i.e convert a tree to child sum property */

    /*
    Original Tree:
              50
           /     \
         /         \
       7             2
     / \             /\
   /     \          /   \
  3        5      1      30
     */


    /* Final Tree:
              39
           /     \
         /         \
       8            31
     / \             /\
   /     \          /   \
  3        5      1      30
     */
    public void convertToChildSum(Node node){
        int left = 0;
        int right =0;

        if(node == null || node.left == null && node.right == null){
            return;
        }

        convertToChildSum(node.left);
        convertToChildSum(node.right);

        if(node.left != null){
            left = node.left.data;
        }
        if(node.right != null){
            right = node.right.data;
        }

        node.data = left+right;

    }





    public static void main(String[] args) {
        ChildSum ck = new ChildSum();
        BinaryTree binaryTree = new BinaryTree();
        Inorder inOrder = new Inorder();

        binaryTree.root = new Node(10);
        binaryTree.root.left = new Node(8);
        binaryTree.root.right = new Node(2);
        binaryTree.root.left.left = new Node(3);
        binaryTree.root.left.right = new Node(5);
        binaryTree.root.right.right = new Node(2);


        BinaryTree tree = new BinaryTree();
        tree.root = new Node(50);
        tree.root.left = new Node(7);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(1);
        tree.root.right.right = new Node(30);

        binaryTree.display(binaryTree.root);
        System.out.println(ck.isChildSum(binaryTree.root));


        System.out.println("Inorder traversal before conversion is :");
        inOrder.inorderRecursive(tree.root);

        ck.convertToChildSum(tree.root);
        System.out.println("");

        System.out.println("Inorder traversal after conversion is :");
        inOrder.inorderRecursive(tree.root);
    }
}

