package Trees.BinaryTree;

/**
 * Created by neha on 3/7/2017.
 */
public class CheckSubtree {


    public boolean isSubtree(Node binaryTreeNode, Node subtreeNode){
        if(subtreeNode == null){
            return false;
        }

        if(binaryTreeNode == null){
            return true;
        }

        if(areSame(binaryTreeNode,subtreeNode)){
            return true;
        }

        return (isSubtree(binaryTreeNode.left,subtreeNode) || isSubtree(binaryTreeNode.right,subtreeNode));
    }

    private boolean areSame(Node root1, Node root2) {
        if(root1 == null  && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }

        return (root1.data == root2.data &&
                areSame(root1.left,root2.left) &&
                areSame(root1.right,root2.right));
    }

    public static void main(String[] args) {
        CheckSubtree cs = new CheckSubtree();

        Node root1, root2;
        root1 = new Node(26);
        root1.right = new Node(3);
        root1.right.right = new Node(3);
        root1.left = new Node(10);
        root1.left.left = new Node(4);
        root1.left.left.right = new Node(30);
        root1.left.right = new Node(6);

        root2 = new Node(10);
        root2.right = new Node(6);
        root2.left = new Node(4);
        root2.left.right = new Node(30);

        if(cs.isSubtree(root1,root2)){
            System.out.println("Tree 2 is subtree of Tree 1");
        }else{
            System.out.println("Tree 2 is not subtree of Tree 1");
        };
    }
}
