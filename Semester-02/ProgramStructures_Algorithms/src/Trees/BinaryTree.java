package Trees;

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
       root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        root.left.right.right = new Node(10);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
      root.right.right.right = new Node(11);

    }

    public Node insert(Node node, int data){
      if(node == null){
          return new Node(data);
      }

      if(data <  node.data){
          node.left = insert(node.left, data);
          node.left.parent = node;
      }
      else if (data > node.data){
          node.right = insert(node.right,data);
          node.right.parent = node;
      }
        return node;
    }

    public void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.print(root.data + " ");
            display(root.right);
        }
    }

    public void printTree(){
        System.out.println("Binary BinaryTree: ");
        System.out.println("                           1\n" +
                "                        /   \\\n" +
                "                        2      3\n" +
                "                      /   \\   /  \\\n" +
                "                     4     5   6  7\n" +
                "                      \\   \\      \n" +
                "                       9   10      ");
        System.out.println();
    }

}
