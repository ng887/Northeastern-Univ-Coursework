package Trees;

/**
 * Created by neha on 2/8/2017.
 */
public class SameShape {

    public boolean areSameShape(Node node1 , Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }

        return (areSameShape(node1.left, node2.left)
        && areSameShape(node1.right , node2.right));
    }
}
