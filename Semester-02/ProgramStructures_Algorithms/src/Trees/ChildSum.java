package Trees;

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
    public static void main(String[] args) {
        ChildSum ck = new ChildSum();
        Tree tree = new Tree();

        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(2);

        tree.display(tree.root);
        System.out.println(ck.isChildSum(tree.root));
    }
}

