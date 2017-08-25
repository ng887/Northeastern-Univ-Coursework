package Trees.BinarySearchTree;

import java.util.Arrays;

/**
 * Created by neha on 3/10/2017.
 */

class Index{  // for converting  from preorder to BST
    int index = 0;
}

public class ConstructBST {

    Node root;

    public ConstructBST(){}

    public ConstructBST(String BinaryTree){
        root = null;
        createBinaryTree();
    }

    /*Method 1 */
    public Node convertSortedArraytoBST(int[] arr, int start, int end){

        if(start > end){
            return null;
        }

        int mid = start + (end-start)/2;
        Node node = new Node(arr[mid]);

        node.left = convertSortedArraytoBST(arr, start, mid-1);
        node.right = convertSortedArraytoBST(arr, mid+1, end);

        return node;
    }

    /*Method 2 */
    /*
    private void convertSortedArraytoBST(Node currentNode, int[] inorder, int[] index)
    {
        if (currentNode == null)
        {
            return;
        }

        convertSortedArraytoBST(currentNode.left, inorder, index);

        currentNode.data = inorder[index[0]];
        index[0] += 1;

        convertSortedArraytoBST(currentNode.right, inorder, index);
    }
    */


    public Node convertBtToBst(){
        int count = getSize();
        int[] arr = new int[count];
        int[] index = new int[1];

        storeValuesToArray(root,arr,index);
        Arrays.sort(arr);
        return convertSortedArraytoBST(arr,0,arr.length-1);
    }

    private void createBinaryTree(){
        root = new Node(8);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);


        root.right = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

    }

    private void storeValuesToArray(Node currentNode, int[] arr, int[] index) {
        if(currentNode == null){
            return;
        }

        storeValuesToArray(currentNode.left,arr,index);
        arr[index[0]] = currentNode.data;

        index[0] += 1;
        storeValuesToArray(currentNode.right,arr,index);

    }

    private int getSize(){
        return getSize(root);
    }
    private int getSize(Node node){
        if(node == null){
            return 0;
        }

        return 1+ getSize(node.left) + getSize(node.right);
    }

    /*Merge BST to make a new BST */
    public Node mergeBST(Node node1 ,Node node2){
        int[] index = new int[1];
        index[0] = 0;

        int count1 = getSize(node1);
        int count2 = getSize(node2);
        int[] arr1 = new int[count1];
        int[] arr2 = new int[count2];
        storeValuesToArray(node1, arr1, index);
        index[0] = 0;
        storeValuesToArray(node2, arr2, index);

        int[] merged = mergeArrays(arr1, arr2);
        index[0] = 0;

        Node mergedNode = convertSortedArraytoBST( merged, 0, merged.length -1);
        return mergedNode;
}

    private int[] mergeArrays(int[] arr1, int[] arr2){

        int[] merged = new int[arr1.length + arr2.length];

        int i =0, j = 0, k = 0;

        while( i < arr1.length && j < arr2.length){

            if(arr1[i] < arr2[j]){

                merged[k] = arr1[i];
                k ++; i ++;
            }
            else{
                merged[k] = arr2[j];
                k ++; j ++;
            }
        }
        while( i < arr1.length){
            merged[k] = arr1[i];
            k ++; i ++;
        }

        while( j < arr2.length){
            merged[k] = arr2[j];
            k ++; j ++;
        }
        return merged;

    }


    /*Preorder to BST */
    /*Time Complexity - O(n)*/
    public Node convertPreorderArraytoBST(int preorderArr[], int size){
        return convertPreorderArraytoBSTHelper(preorderArr, index,0,size-1,size);
    }
    Index index = new Index();
    private Node convertPreorderArraytoBSTHelper(int[] preorderArr, Index preIndex, int low, int high, int size){

        if(preIndex.index >= size || low > high){
            return null;
        }

       Node root = new Node(preorderArr[preIndex.index]);
       preIndex.index += 1;

       if(low == high){
           return root;
       }

       int i;
       for( i=low; i<=high ; i ++){
           if(preorderArr[i] > root.data ){
               break;
           }
       }

       root.left = convertPreorderArraytoBSTHelper(preorderArr,preIndex,preIndex.index,i-1,size);
       root.right =  convertPreorderArraytoBSTHelper(preorderArr,preIndex,i,high,size);

       return root;
    }


    public static void main(String[] args) {
        ConstructBST tree = new ConstructBST("BinaryTree");
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("Inorder traversal of Binary tree constructed to BST");
        bst.printBST(tree.convertBtToBst());

        System.out.println("\n\nInorder traversal of merged BST");
        BinarySearchTree bst2 = new BinarySearchTree();
        BinarySearchTree bst3 = new BinarySearchTree();

        bst2.insert(100);
        bst2.insert(50);
        bst2.insert(150);
        bst2.insert(40);
        bst2.insert(80);
        bst2.insert(25);
        bst2.insert(35);

        bst3.insert(80);
        bst3.insert(55);
        bst3.insert(90);

        bst.printBST(tree.mergeBST(bst2.getRoot(),bst3.getRoot()));


        System.out.println("\n\nInorder traversal of array constructed to BST");
        ConstructBST tree1 = new ConstructBST();
        int arr[] = {1,2,10,12,14,20,27};
        bst.printBST(tree1.convertSortedArraytoBST(arr,0,6));

        System.out.println("\n\nInorder traversal of preorder array constructed to BST");
        int preorderArr[] = {8,3,1,6,4,7,10,14,13};
        bst.printBST(tree1.convertPreorderArraytoBST(preorderArr,preorderArr.length));
    }

}
