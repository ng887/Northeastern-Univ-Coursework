package Trees.BinarySearchTree;


import java.util.Stack;

/**
 * Created by neha on 3/14/2017.
 */
public class SumEqualToK {

    public int findSum(Node root, int sum){
        Stack stack1 = new Stack<>();
        Stack stack2 = new Stack<>();

        Node cur1 = root;
        Node cur2 = root;

        while (!stack1.isEmpty() || !stack2.isEmpty() || cur1 != null || cur2 != null){
            if(cur1 != null || cur2 != null){
                if(cur1 != null){
                    stack1.push(cur1);
                    cur1 = cur1.left;
                }
                if(cur2 != null) {
                    stack2.push(cur2);
                    cur2 = cur2.right;
                }
            }
            else{

                int val1 = (int) stack1.peek();
                int val2 = (int) stack2.peek();

                if(stack1.peek() == stack1.peek()) {
                    break;
                }

                if (val1 + val2 == sum){
                    System.out.println("The nodes are:" + val1 + " " + val2);
                    return 1;
                }

                if(val1 + val2 < sum){
                    cur1 = (Node) stack1.pop();
                    cur1 = cur1.right;
                }
                else{
                    cur2 = (Node) stack1.pop();
                    cur2 = cur2.left;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SumEqualToK tree = new SumEqualToK();
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        bst.insert(8);
        bst.insert(4);
        bst.insert(12);
        bst.insert(22);

        tree.findSum(bst.getRoot(),30);
    }

}
