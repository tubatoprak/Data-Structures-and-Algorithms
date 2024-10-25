import java.util.Iterator;

public interface DynamicGraph extends Graph {
    /**
     *
      * @param label of vertex
     * @param weight of vertex
     */
    void newVertex (String label, double weight);
    void addVertex (Vertex new_vertex);
    void addEdge (int vertexID1, int vertexID2, double weight);
    void removeEdge (int vertexID1, int vertexID2);
    void removeVertex (int vertexID);
    void filterVertices (String key, String filter);
    void exportMatrix();
    void printGraph();

}
