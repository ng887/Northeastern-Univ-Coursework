package Graph;

/**
 * Created by neha on 3/17/2017.
 */
public class Edge {

    private String startVertex;
    private String endVertex;
    private int weight;

    /*Getters*/
    public String getStartVertex() {
        return startVertex;
    }

    public String getEndVertex() {
        return endVertex;
    }

    public int getWeight() {
        return weight;
    }

    /*Setters*/
    public void setStartVertex(String startVertex) {
        this.startVertex = startVertex;
    }

    public void setEndVertex(String endVertex) {
        this.endVertex = endVertex;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    /*Edge Constructor*/
    public Edge(String startVertex, String endVertex, int weight){
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }
}
