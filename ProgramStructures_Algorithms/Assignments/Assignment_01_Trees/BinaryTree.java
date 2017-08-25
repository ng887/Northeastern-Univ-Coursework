package Assignments.Assignment_01_Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by neha on 3/7/2017.
 */

class BinaryTree{
    /*2.2  LCA of a Binary Tree */
    public Node lcaRecursive(Node root, Node node1, Node node2){
        if (root == null){
            return null;
        }

        if(root == node1 || root == node2){
            return root;
        }

        Node left =  lcaRecursive(root.left, node1 , node2);
        Node right =  lcaRecursive(root.right, node1 , node2);

        if(left != null && right != null){
            return root;
        }

        if(left == null && right == null){
            return null;
        }

        return left != null ? left : right;

    }



        /*3. Check if a binary tree is subtree of another binary tree.*/
        /* Time Complexity - Worst Case: O(mn) where m and n are number of nodes in the trees */
        public boolean isSubtree(Node binaryTreeNode, Node subtreeNode){
        if(subtreeNode == null){
            return true;
        }

        if(binaryTreeNode == null){
            return false;
        }

        if(areSame(binaryTreeNode,subtreeNode)){
            return true;
        }

        return (isSubtree(binaryTreeNode.left,subtreeNode) || isSubtree(binaryTreeNode.right,subtreeNode));
    }

    /*Helper method to check if two trees are same and the data is also same */
    Node root1, root2;
    private boolean areSame(Node root1, Node root2) {
        if(root1 == null  && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }

        return (root1.data == root2.data &&
                areSame(root1.left,root2.left) &&
                areSame(root1.right,root2.right));
    }

    /*4. Check if all leaves are at same level in a binary tree. */
    /*Time Complexity: O(n) */
       public void checkLevelByLevel(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        int leafLevel = 0;
        int level = 0;

        while(!queue.isEmpty()){
            Node currentNode =  queue.poll();

            if(currentNode != null){
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                if(currentNode.left == null && currentNode.right == null && leafLevel == 0){
                    leafLevel = level;
                }else if(currentNode.left == null && currentNode.right == null && leafLevel != level){
                    System.out.println("Leaves not at the same level");
                    return;
                }

            }
            else{
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
                level ++;
            }

        }

        System.out.println("Leaves at the same level");

    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root1 = new Node(50);
        bt.root1.right = new Node(60);
        bt.root1.right.right = new Node(65);
        bt.root1.left = new Node(30);
        bt.root1.left.left = new Node(20);
        //bt.root1.left.left.right = new Node(25);
        bt.root1.left.right = new Node(6);

        bt.root2 = new Node(30);
        bt.root2.right = new Node(6);
        bt.root2.left = new Node(20);
        //bt.root2.left.right = new Node(25);

        Node node1,node2;
        node1 = bt.root1.left.right;
        node2 = bt.root1.left.left;
        System.out.println("LCA of " + node1.data + " and " + node2.data + " is " + bt.lcaRecursive(bt.root1,node1,node2).data);

        if(bt.isSubtree(bt.root1,bt.root2)){
            System.out.println("Tree 2 is subtree of Tree 1");
        }else{
            System.out.println("Tree 2 is not subtree of Tree 1");
        };

        bt.checkLevelByLevel(bt.root1);


    }




}
