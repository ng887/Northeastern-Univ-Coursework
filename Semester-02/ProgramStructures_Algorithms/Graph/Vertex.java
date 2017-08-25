package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neha on 3/17/2017.
 */
public class Vertex {

    private String name;
    private List<Edge> edgesList;
    private boolean isVisted;

    /*Getters*/
    public String getName() {
        return name;
    }

    public List<Edge> getEdgesList() {
        return edgesList;
    }

    public boolean isVisted() {
        return isVisted;
    }

    /*Setters*/
    public void setName(String name) {
        this.name = name;
    }

    public void setEdgesList(List<Edge> edgesList) {
        this.edgesList = edgesList;
    }

    public void setVisted(boolean visted) {
        isVisted = visted;
    }

    public Vertex(String name) {
        this.name = name;
        this.edgesList = new ArrayList<Edge>();
    }

    /*Add Edge from a start vertex*/
    public boolean addEdge(String endVertex, int weight){

        for(int i = 0 ; i < edgesList.size(); i ++)
        {
            if(edgesList.get(i).getEndVertex() == endVertex)
                return false;
        }
        Edge edge = new Edge(this.name, endVertex, weight);
        edgesList.add(edge);
        return true;
    }

    /*get neighbours of a vertex */
    public List<String> getNeighbours(){
        List<String> neighboursList = new ArrayList<String>();

        for(int i = 0; i < edgesList.size(); i ++){
            neighboursList.add(edgesList.get(i).getEndVertex());
        }
        return neighboursList;

    }
}
