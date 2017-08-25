package Trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by neha on 3/9/2017.
 */
public class SmallestLargest {
    /*Method 1: k-th smallest Non- Recursive */
    public int findKSmallestNonRecursive(Node root, int k) {
        if (root == null || k <= 0) {
            return -1;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        Node node = root;
        while(!stack.isEmpty()) {
            //Inorder Traversal
            //Left first
            while (node != null && node.left != null) {
                stack.push(node.left);
                node = node.left;
            }
            //Process left/curr
            node = stack.pop();
            k--;
            if (k == 0) {
                return node.data;
            }
            node = node.right;
            if (node != null) {
                stack.push(node);
            }
        }

        return -1;
    }

    /*Method 2: k-th smallest Recursive */
    public int findKSmallestElement(Node root, int k){
        if (root == null || k <= 0) {
            return -1;
        }
        ArrayList<Node> kSmallestElements = new ArrayList<Node>();
        findKSmallestElementHelper(root,k,kSmallestElements);

        if(kSmallestElements.size() < k){
            return -1;
        }
        return kSmallestElements.get(k).data;
    }

    private void findKSmallestElementHelper(Node node, int k, List<Node> kSmallestElements) {
        if(kSmallestElements.size() == k){
            return;
        }
        if(node.left == null && node.right == null){
           kSmallestElements.add(node);
        }
        if(node.left != null){
           findKSmallestElementHelper(node.left,k,kSmallestElements);
        }
        kSmallestElements.add(node);
        if(node.right != null){
            findKSmallestElementHelper(node.right,k,kSmallestElements);
        }
    }

    /* k-th Largest */

    /*Smallest*/
    public int findSmallestElement(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        Node current = root;
        while(current.getLeft() != null){
            current = current.getLeft();
        }
        return current.data;
    }

    /*Largest*/
    public int findLargestElement(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        Node current = root;
        while(current.getRight() != null){
            current = current.getRight();
        }
        return current.data;
    }

    public static void main(String[] args) {
        SmallestLargest small = new SmallestLargest();
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(9);
        bst.insert(19);
        bst.insert(-5);
        bst.insert(17);
        bst.insert(21);
        System.out.println("K smallest Element " + small.findKSmallestElement(bst.getRoot(),3));
        System.out.println("K smallest Element Recursivly " + small.findKSmallestNonRecursive(bst.getRoot(),3));
        System.out.println("Smallest Element " + small.findSmallestElement(bst.getRoot()));
        System.out.println("Largest Element " + small.findLargestElement(bst.getRoot()));
    }
}
