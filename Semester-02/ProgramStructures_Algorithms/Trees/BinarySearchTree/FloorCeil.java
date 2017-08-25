package Trees.BinarySearchTree;

/**
 * Created by neha on 3/11/2017.
 */
public class FloorCeil {

    public int findCeil(Node node,int input ){
        if(node == null){
            return -1;
        }
        if(node.data == input){
            return node.data;
        }
        if(node.data < input){
            return findCeil(node.right,input);
        }
        // Else, either left subtree or root has the ceil value
        int ceil = findCeil(node.left,input);
        return (ceil >= input)? ceil  : node.data;
    }

    public int findFloor(Node node,int input ){
        if(node == null){
            return -1;
        }
        if(node.data == input){
            return node.data;
        }
        if(node.data < input){
            return findFloor(node.left,input);
        }
        // Else, either left subtree or root has the ceil value
        int floor = findFloor(node.right,input);
        return (floor >= input)? floor  : node.data;
    }

    public static void main(String[] args) {
        FloorCeil tree = new FloorCeil();
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(4);
        bst.insert(12);
        bst.insert(2);
        bst.insert(6);
        bst.insert(10);
        bst.insert(14);
        for (int i = 0; i < 16; i++) {
            System.out.print("\nCeiling ");
            System.out.print(i + " --> " + tree.findCeil(bst.getRoot(), i));
        }
        for (int i = 0; i < 16; i++) {
            System.out.print("\nFloor ");
            System.out.print(i + " --> " + tree.findFloor(bst.getRoot(), i));
        }
    }
}
