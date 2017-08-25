package Graph;

import java.io.Console;
import java.util.*;

/**
 * Created by neha on 3/17/2017.
 */
public class Graph {
    private String startVertex;
    private HashMap<String, Vertex> vertices;

    public Graph() {
        this.startVertex = "";
        vertices = new HashMap<String, Vertex>();
        Initialize();
    }

    public String getStartVertex() {
        return startVertex;
    }

    public HashMap<String, Vertex> getVertices() {
        return vertices;
    }

    public void setStartVertex(String startVertex) {
        this.startVertex = startVertex;
    }

    public void setVertices(HashMap<String, Vertex> vertices) {
        this.vertices = vertices;
    }


    private void Initialize() {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        Vertex vertexF = new Vertex("F");
        Vertex vertexG = new Vertex("G");

        vertexA.addEdge("B", 1);
        vertexB.addEdge("C", 1);
        vertexD.addEdge("B", 1);
        vertexB.addEdge("E", 1);
        vertexC.addEdge("E",1);
        vertexE.addEdge("D", 1);
        vertexE.addEdge("F", 1);
        vertexG.addEdge("D", 1);

        vertices.put("A", vertexA);
        vertices.put("B", vertexB);
        vertices.put("C", vertexC);
        vertices.put("D", vertexD);
        vertices.put("E", vertexE);
        vertices.put("F", vertexF);
        vertices.put("G", vertexG);


    }

    public boolean initStartVertex(String vertexName) {
        if (vertices.containsKey(vertexName)) {
            startVertex = vertexName;
            return true;
        }
        return false;
    }

    public boolean addVertex(Vertex vertex) {
        if (vertices.containsKey(vertex.getName())) {
            return false;
        }
        vertices.put(vertex.getName(), vertex);
        return true;
    }

    public void resetVisited() {
        for (Map.Entry<String, Vertex> entry : vertices.entrySet()) {
            entry.getValue().setVisted(false);
        }
    }



    public void depthFirst(String sourceVertex) {

        initStartVertex(sourceVertex);
        resetVisited();

        Stack<Vertex> stack = new Stack<Vertex>();
        stack.push(null);
        stack.push(vertices.get(startVertex));

        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            if (vertex != null) {
                if (vertex.isVisted() != true) {
                    System.out.print(vertex.getName() + "\t");
                    vertex.setVisted(true);
                } else
                    continue;

                List<String> neighbours = vertex.getNeighbours();
                for (int i = 0; i < neighbours.size(); i++) {
                    if (!(vertices.get(neighbours.get(i)).isVisted())) {
                        stack.push(vertices.get(neighbours.get(i)));
                    }
                }

            } else {
                if (stack.isEmpty())
                    break;
                else
                    stack.push(null);
                System.out.println();
            }

        }// end of while

    }

    public boolean hasCycle() {
        boolean[] curPath = new boolean[128]; // character set

        for (int i = 0; i < curPath.length ; i++) {
            curPath[i] = false;
        }

        for (Map.Entry<String, Vertex> entry : vertices.entrySet()) {
            // System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue().getName());
            if (hasCycleHelper(entry.getValue().getName(), curPath)) {
                System.out.println("Cycle contains: ");
                for (int i = 0; i < curPath.length; i++)
                {
                    if (curPath[i]) {
                        System.out.print( Character.toString((char) i) + ",");
                    }
                }
                return true;
            }
        }

        return false;
    }

    private boolean hasCycleHelper(String sourceVertexName, boolean[] curPath) {
        Vertex curVertex = vertices.get(sourceVertexName);
        if(!curVertex.isVisted())
        {
            curVertex.setVisted(true);
            curPath[sourceVertexName.charAt(0)] = true; // Assuming vertex name are single character strings e.g A, B , D

            List<String> neighbours = curVertex.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                Vertex curNeighbor = vertices.get(neighbours.get(i));
                if (!(curNeighbor.isVisted()) && hasCycleHelper(curNeighbor.getName(),curPath)) {
                   return true;
                }
                else if (curPath[curNeighbor.getName().charAt(0)]){
                    return true;
                }
            }
        }
        curPath[sourceVertexName.charAt(0)] = false;
        return false;
    }


    public static void main(String[] args) {
        Graph graph = new Graph();
        System.out.println("\nGraph is cyclic: " + graph.hasCycle());

    }
}
