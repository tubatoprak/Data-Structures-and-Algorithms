import java.util.*;

/**
 *  A ListGraph is an extension of the AbstractGraph abstract class
 * *   that uses an array of lists to represent the vertexs.
 */
public class MyGraph implements DynamicGraph {

// Data Fields
    /** The number of vertices */
    private int numV;

    /** The id of vertices */
    private int idV = 0;

    /** Flag to indicate whether this is a directed graph */
    private boolean directed;
    /**
     * to name vertexes
     */
    String labels = "A";

    /** An array of Lists to contain the edges that
     originate with each vertex. */
    private List< Vertex >[] vertex;
    /**
     *  An array of Lists to contain the weights that
     *      originate with each edge
     */
    private List< Double >[] weights;

    // ConstructorS
    /** Construct a graph with the specified number of vertices
     and the directed flag. If the directed flag is true,
     this is a directed graph.
     @param numV The number of vertices
     @param directed The directed flag
     */
    public MyGraph(int numV, boolean directed) {
        this.numV = numV;
        this.directed = directed;
        vertex = new List[numV];
        weights = new List[numV];
        for (int i = 0; i < numV; i++) {
            vertex[i] = new LinkedList< Vertex >();
            weights[i] = new ArrayList<>();
        }
        for (int i = 0; i < numV; i++) {
            Vertex temp = new Vertex(idV,labels,i);
            vertex[i].add(temp);
            weights[i].add(0.0);
            idV++;
            labels();
        }
    }
    /**
     *  to otomatic name of vertexes
     */
    private void labels(){
        char tmp = labels.charAt(0);
        tmp++;
        labels = String.valueOf(tmp);
    }
    /**
     * Method increase of size dynamically.
     */
    public void increaseSize() {
        List< Vertex >[] temp = new List[vertex.length + 1];
        List< Double >[] temp2 = new List[weights.length + 1];
        for (int i = 0; i < numV+1; i++) {
            temp[i] = new LinkedList<>();
            temp2[i] = new ArrayList<>();
        }
        for (int i = 0; i < vertex.length; i++){
            temp[i] = vertex[i];
            temp2[i] = weights[i];
        }
        vertex = temp;
        weights = temp2;
    }
    /**
     * Generate a new vertex by given parameters.
     * @param label of vertex
     * @param weight of vertex
     */
    public void newVertex(String label, double weight) {
        increaseSize();
        Vertex temp = new Vertex(idV,label,weight);
        vertex[numV].add(temp);
        weights[numV].add(0.0);
        numV++;
        idV++;
    }

    /**
     * method to string
     * @return string
     */
    @Override
    public String toString() {
        return "MGraph{" +
                "numV=" + numV +
                ", directed=" + directed +
                ", vertex=" + Arrays.toString(vertex) +
                '}';
    }
    /**
     *Add the given vertex to the graph.
     * @param new_vertex given vertex entered
     */
    public void addVertex(Vertex new_vertex) {
        increaseSize();
        new_vertex.setId(idV);
        vertex[numV].add(new_vertex);
        weights[numV].add(0.0);
        numV++;
    }
    /**
     *  Add an edge between the given two vertices in the graph.
     * @param vertexID1 of source
     * @param vertexID2 of dest
     * @param weight of edge
     */
    public void addEdge(int vertexID1, int vertexID2, double weight) {
        Vertex temp = vertex[vertexID2].get(0) ;
        vertex[vertexID1].add(temp);
        weights[vertexID1].add(weight);
        if(!isDirected()){
            Vertex tmp = vertex[vertexID1].get(0) ;
            vertex[vertexID2].add(tmp);
            weights[vertexID2].add(weight);
        }

    }

    /**
     * Remove the edge between the given two vertices.
     * @param vertexID1 of source
     * @param vertexID2 of dest
     */
    public void removeEdge(int vertexID1, int vertexID2) {
        Vertex temp = vertex[vertexID2].get(0) ;
        vertex[vertexID1].remove(temp);
        weights[vertexID1].remove(temp.getWeight());
        if(!isDirected()){
            Vertex tmp = vertex[vertexID1].get(0) ;
            vertex[vertexID2].remove(tmp);
            weights[vertexID2].remove(tmp.getWeight());
        }
    }

    /**
     * Remove the vertex from the graph with respect to the given vertex id.
     * @param vertexID of id
     */

    public void removeVertex(int vertexID) {
        Vertex temp = new Vertex(vertexID);
        for (int i = 0; i < numV; i++) {
            if(!(i == vertexID))
                removeEdge(i,vertexID);
        }
        System.arraycopy(vertex, vertexID + 1, vertex, vertexID, vertex.length - vertexID - 1);
        System.arraycopy(weights, vertexID + 1, weights, vertexID, weights.length - vertexID - 1);
        numV--;
    }

    /**
     * Remove the vertex from the graph with respect to the given vertex labeş.
     * @param labels of vertex
     */
    public void removeVertex(String labels){
        for (int i = 0; i < numV; i++) {
            if(vertex[i].get(0).getLabel().equals(labels))
                removeVertex(i);
        }
    }

    /**
     *  Add by the given user-defined property
     * @param id of vertex
     * @param key of properties
     * @param value of properties
     */
    public boolean  add_properties(int id ,String key, String value){
        if(id > numV)
            return false;
        for (int i = 0; i < numV; i++) {
            if(vertex[i].get(0).getId() == id)
                return vertex[id].get(0).add_properties(key,value);
        }
        return false;
    }

    /**
     * Filter the vertices by the given user-defined property and returns a subgraph of the graph.
     * @param key of properties
     * @param filter of  properties
     */
    public void filterVertices(String key, String filter) {
        for (int i = 0; i < numV; i++) {
            if(vertex[i].get(0).filter_porperties(key,filter))
                System.out.println("Vertex id:"+ i + " -- Key:"+key+" -- Filter:"+ filter);
        }
    }

    /**
     * helper to exportmatrix
     * @param k index
     * @param id id
     * @return index of id
     */
    public int helper(int k ,int id){
        for (int i = 0;i < vertex[k].size(); i++){
            if (vertex[k].get(i).getId() == id)
                return i;
        }
        return -1;
    }

    /**
     * Generate the adjacency matrix representation of the graph and returns the matrix
     */

    public void exportMatrix() {
        int temp = 0;
        int printIndex = 0;
        System.out.print("\t");
        for (int i = 0;i < numV; i++) System.out.print("  "+ i +"  ");
        System.out.println(" ");
        for (int i = 0; i < numV; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < numV; j++) {
                printIndex = helper(i,j);
                if (printIndex != -1){
                    if (weights[i].get(printIndex) == 0.0){
                        System.out.print("  -  ");
                    }else
                        System.out.print(" " + weights[i].get(printIndex) + " ");
                }else{
                    System.out.print("  -  ");
                }
            }
            System.out.print("\n");
        }
    }

    /**
     * Print the graph in adjacency list format
     */

    public void printGraph() {
        for (int i = 0; i < numV; i++) {
            System.out.println(vertex[i].toString()+"-->");
        }
    }
    @Override
    public int getNumV() {
        return numV;
    }

    @Override
    public boolean isDirected() {
        return directed;
    }

    @Override
    public void insert(Edge edge) {

    }

    @Override
    public boolean isEdge(Vertex source, Vertex dest) {
        return vertex[source.getId()].contains(dest);
    }

    @Override
    public Edge getEdge(Vertex source, Vertex dest) {
        return null;
    }

}
