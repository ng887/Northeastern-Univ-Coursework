package Assignments.Quiz;

/**
 * Created by neha on 3/22/2017.
 */
public class Isomorphic {

        public boolean isIsomorphic(Node node1 , Node node2){
            if(node1 == null && node2 == null){
                return true;
            }
            if(node1 == null || node2 == null){
                return false;
            }

            return (isIsomorphic(node1.left, node2.left)
                    && isIsomorphic(node1.right , node2.right));
        }

}
