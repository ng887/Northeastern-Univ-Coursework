package Trees;

/**
 * Created by neha on 2/6/2017.
 */
public class Height {

    public int getHeight(Node node){
        if(node == null) {
            return 0;
        }

        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);
        return 1 + Math.max(lHeight,rHeight);

    }

    public boolean isHeightBalance(Node root){
        return isHeightBalanceHelper(root);
    }

    private boolean isHeightBalanceHelper(Node node) {
        if(node == null){
            return true;
        }
        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        if(Math.abs(lHeight - rHeight) <= 1 &&
                isHeightBalanceHelper(node.left) &&
                isHeightBalanceHelper(node.right)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Height h = new Height();
        Tree t = new Tree();
        t.printTree();

        System.out.println("Height of tree is " + h.getHeight(t.root));

    }
}
