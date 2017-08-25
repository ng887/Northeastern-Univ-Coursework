package Trees.BinaryTree;

/**
 * Created by neha on 2/6/2017.
 */
public class BinaryTree {

    /*
    // TREE
                          1
                        /   \
                        2      3
                      /   \   /  \
                      4    5   6  7
                     / \   \        \
                    8 9     10      11
    */

    public Node root;


    public BinaryTree()
    {
        createTree();
    }

    private void createTree()
    {

        Node node = new Node(1);
        root = node;

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left= new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        root.left.right.right = new Node(10);

        root.right.right.right = new Node(11);
    }


    void insert(int data) {
        root = insertHelper(root, data);
    }

    /* A recursive function to insert a new data in BST */
    Node insertHelper(Node root, int data) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(data);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (data < root.data)
            root.left = insertHelper(root.left, data);
        else if (data > root.data)
            root.right = insertHelper(root.right, data);

        /* return the (unchanged) node pointer */
        return root;
    }

    public void display(Node root){
        if(root!=null){
            System.out.print(root.data + " ");
            display(root.left);
            display(root.right);
        }
    }

    public void printTree(){
        System.out.println("Binary Tree: ");
        System.out.println("                           1\n" +
                "                        /   \\\n" +
                "                        2      3\n" +
                "                      /   \\   /  \\\n" +
                "                     4     5  6  7\n" +
                "                    / \\    \\      \\\n" +
                "                   8   9   10      11");
        System.out.println();
    }

}
