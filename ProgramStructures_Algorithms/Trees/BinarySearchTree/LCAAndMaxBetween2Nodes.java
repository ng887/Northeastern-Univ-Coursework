package Trees.BinarySearchTree;

/**
 * Created by neha on 3/7/2017.
 */
/*LeastCommonAncestor*/
public class LCAAndMaxBetween2Nodes {

    public Node findLcaBST(Node root, Node node1, Node node2) {

        if (root.data > node1.data && root.data > node2.data) {
            return findLcaBST(root.left, node1, node2);
        } else if (root.data < node1.data && root.data < node2.data) {
            return findLcaBST(root.right, node1, node2);
        } else {
            return root;
        }
    }

    /*
      The idea is to find Longest Common Ancestor of node ‘node1’ and node ‘node2’.
     Then search maximum node between LCA and ‘greater node between node1 and node2’.
          */
    public int maxBetweenTwoNodes(Node root, Node node1, Node node2){
        Node ancestor= findLcaBST(root,node1,node2);
        int target = Integer.max(node1.data,node2.data);
        return maxBetweenAncestorX(ancestor,target);
      }

    public int maxBetweenAncestorX(Node ancestor, int x) {
        int max = ancestor.data;

       // Traversing the path between ansector and
        // Node and finding maximum element.

        while (ancestor.data != x) {
            if (ancestor.data > x) {
                max = Integer.max(ancestor.data,max);
                ancestor = ancestor.left;
            }else{
                max = Integer.max(ancestor.data,max);
                ancestor = ancestor.right;
            }

        }
        return max;
    }




    public static void main(String[] args) {
        LCAAndMaxBetween2Nodes tree = new LCAAndMaxBetween2Nodes();
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(9);
        bst.insert(19);
        bst.insert(-5);
        bst.insert(17);
        bst.insert(21);

        System.out.println("The inorder traversal of BST: ");
        bst.printBST(bst.getRoot());
        Node a = bst.getRoot().left.left;
        Node b = bst.getRoot().right.left;
        System.out.println("\nLeast Common Ancestor of " + a.data + " & " + b.data +" is :" + tree.findLcaBST(bst.getRoot(),a,b).data);
        System.out.println("Max between two nodes" + a.data + " & " + b.data + " is :" + tree.maxBetweenTwoNodes(bst.getRoot(),a,b));


    }
}
