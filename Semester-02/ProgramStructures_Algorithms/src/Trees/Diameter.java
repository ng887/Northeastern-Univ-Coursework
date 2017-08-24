package Trees;

/**
 * Created by neha on 2/15/2017.
 *
 * Diam­e­ter of tree is defined as A longest path or route between any two nodes in a tree.
 * The path may or may not for through the root
 *
 * Approach:

 Find the height of left subtree.
 Find the height of right subtree.
 Find the left diameter.
 Find the right diameter.
 Return the Maximum(Diameter of left sub­tree,  Diam­e­ter of right sub­tree,
 Longest path between two nodes which passes through the root.)

 Time-Complexity : O(n^2)
 */
public class Diameter {
    Height h = new Height();
    public int getDiameterOfBT(Node root){
        if (root == null){
            return 0;
        }

        int leftHeight = h.getHeight(root.left) ;
        int rightHeight =h.getHeight(root.right);

        int leftDiameter = getDiameterOfBT(root.left);
        int rightDiameter = getDiameterOfBT(root.right);

        return Math.max(leftHeight+rightHeight+1 ,Math.max(leftDiameter,rightDiameter));

    }
}
