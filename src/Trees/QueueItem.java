package Trees;

/**
 * Created by neha on 2/8/2017.
 */
public class QueueItem {
    Node node;
    int horizDistance;

    public QueueItem(Node node, int hd){
        this.node = node;
        horizDistance = hd;
    }
}
