package Assignments.Assignment_01_Trees;

/**
 * Created by neha on 3/8/2017.
 */
public class BinarySearchTree {

    private Node root;

    public Node getRoot() {
        return root;
    }


    BinarySearchTree(){
        root = null;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    /* 1.1 Find the sum of k smallest numbers in BST */
    /*Time complexity: O(k)*/
    /*Do inorder traversal and keep track of count of visited Nodes and keep adding Nodes until the count becomes k */
    static int countSmall = 0;
    public int sumOfKSmallestElements( Node root, int k){
        if (root == null ){
            return 0;
        }
        if (countSmall >= k){
            return 0;
        }

        int result = sumOfKSmallestElements( root.left, k);
        if( countSmall >= k){
            return result;
        }
        result += root.data;
        countSmall++;

        if(countSmall >= k){
            return result;
        }
        return result + sumOfKSmallestElements( root.right, k);


    }

    /*1.2 Find the sum of k largest numbers in a BST */
     /*Time complexity: O(k)*/
     /*Do reverse inorder traversal and keep track of count of visited Nodes and keep adding Nodes until the count becomes k */
    static int countLarge = 0;
    public int sumofKLargestElements(Node root, int k){
        if (root == null ){
            return 0;
        }
        if (countLarge >= k){
            return 0;
        }

        int result = sumofKLargestElements( root.right, k);
        if( countLarge >= k){
            return result;
        }
        result += root.data;
        countLarge++;

        if(countLarge >= k){
            return result;
        }
        return result + sumofKLargestElements( root.left, k);

    }

    /*LCA of a BST */
    public Node findLcaBST(Node root, Node node1, Node node2){

        if(root.data > node1.data && root.data > node2.data){
            return findLcaBST(root.left,node1,node2);
        }
        else if(root.data < node1.data && root.data < node2.data){
            return findLcaBST(root.right,node1,node2);
        }
        else{
            return root;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(20);
        bst.insert(8);
        bst.insert(4);
        bst.insert(12);
        bst.insert(22);
       /* root = bst.insert(root, 10);
        root = bst.insert(root, 14);
        root = bst.insert(root, 22);*/
        int k = 3;

        System.out.println("Sum of k smallest elements:");
        System.out.println(bst.sumOfKSmallestElements(bst.getRoot(), k));

        System.out.println("Sum of k largest elements:");
        System.out.println(bst.sumofKLargestElements(bst.getRoot(), k));

        Node node1,node2;
        node1 = bst.root.left.right;
        node2 = bst.root.left.left;
        System.out.println("LCA of " + node1.data + " and " + node2.data + " is " + bst.findLcaBST(bst.root,node1,node2).data);

    }

}
