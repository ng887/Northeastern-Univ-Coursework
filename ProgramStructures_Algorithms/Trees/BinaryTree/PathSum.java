package Trees.BinaryTree;

/**
 * Created by neha on 2/8/2017.
 */
public class PathSum {
    public boolean hasPathSum(Node root, int sum){
        return hasPathSumHelper(root,sum);
    }

    private boolean hasPathSumHelper(Node node, int sum) {
        if(node == null){
            return sum == 0;
        }

        boolean ans = false;
        int subSum = sum - node.data;
        if(subSum == 0 && node.left == null && node.right == null){
            return true;
        }

        if(node.left !=null){
            ans = ans||hasPathSumHelper(node.left,subSum);
        }

        if(node.right != null){
            ans= ans||hasPathSumHelper(node.right,subSum);
        }
        return ans;
    }
    public static void main(String[] args) {
        PathSum p = new PathSum();
        BinaryTree t = new BinaryTree();
        t.printTree();

        System.out.println(p.hasPathSum(t.root,5));

    }

}
