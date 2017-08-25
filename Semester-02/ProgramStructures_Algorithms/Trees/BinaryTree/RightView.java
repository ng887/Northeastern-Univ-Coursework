package Trees.BinaryTree;

/**
 * Created by neha on 2/8/2017.
 */
public class RightView {

    public static int currentLevel =0;
    public void printRightViewRecur(Node root, int nextLevel){
        if(root==null) return;

        if(currentLevel<nextLevel){
            System.out.print ("  " + root.data);
            currentLevel = nextLevel;
        }
        printRightViewRecur(root.right,nextLevel+1);
        printRightViewRecur(root.left,nextLevel+1);
    }

    public static void main(String[] args) {
        RightView r = new RightView();
        BinaryTree t = new BinaryTree();
        t.printTree();

        r.printRightViewRecur(t.root,1);

    }
}
