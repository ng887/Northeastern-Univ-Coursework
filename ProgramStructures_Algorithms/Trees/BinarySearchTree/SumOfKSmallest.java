package Trees.BinarySearchTree;

/**
 * Created by neha on 3/7/2017.
 */


public class SumOfKSmallest {


    static int count = 0;
        private int SumOfKSmallestElements( Node root, int k){
        if (root == null ){
            return 0;
        }
        if (count >= k){
            return 0;
        }

        int result = SumOfKSmallestElements( root.left, k);
        if( count >= k){
            return result;
        }
        result += root.data;
        count++;

        if(count >= k){
            return result;
        }
            return result + SumOfKSmallestElements( root.right, k);


    }

    public static void main(String[] args) {
        SumOfKSmallest sum = new SumOfKSmallest();

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        bst.insert(8);
        bst.insert(4);
        bst.insert(12);
        bst.insert(22);

        int k = 3;

        System.out.println("Sum of k smallest elements:");
        System.out.println(sum.SumOfKSmallestElements(bst.getRoot(), k));

       
        
    }

}
