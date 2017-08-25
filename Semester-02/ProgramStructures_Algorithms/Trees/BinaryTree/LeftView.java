package Trees.BinaryTree;

/**
 * Created by neha on 2/8/2017.
 */
public class LeftView {
    static int currentLevel = 0;
    public void printLeftView(Node root){

        printLeftViewHelper(root,1);
    }

    private void printLeftViewHelper(Node node, int nextLevel) {


        if (node== null){
            return;
        }

        if(currentLevel < nextLevel)
        {
            System.out.print(node.data + " ");
            currentLevel=nextLevel;
        }

        printLeftViewHelper(node.left,nextLevel+1);
        printLeftViewHelper(node.right,nextLevel+1);



    }

    public static void main(String[] args) {
        LeftView l = new LeftView();
        BinaryTree t = new BinaryTree();
        t.printTree();

        l.printLeftView(t.root);

    }
}
