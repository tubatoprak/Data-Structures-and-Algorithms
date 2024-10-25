import java.util.ArrayList;
import java.util.Objects;

/**
 * Vertex Class
 */
public class Vertex {
    /**
     * id of vertex
     */
    int id;
    /**
     * label of vertex
     */
    String label;
    /**
     * weight of vertex
     */
    double weight;
    /**
     * list of keys
     */
    ArrayList<String> keys = new ArrayList<>();
    /***
     * list of value
     */
    ArrayList<String> values = new ArrayList<>();

    /**
     * Constructor
     * @param id of vertex
     * @param label of vertex
     * @param weight of vertex
     */
    public Vertex(int id, String label, double weight) {
        this.id = id;
        this.label = label;
        this.weight = weight;
    }

    /**
     * Constructor
     * @param id of vertex
     */
    public Vertex(int id) {
        this.id = id;
        this.label = "label";
        this.weight = 0;
    }

    /**
     *  Get the id
     * @return id of vertex
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id
     * @param id of vertex
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set the weight
     * @param weight of vertex
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Get the label
     * @return label old vertex
     */
    public String getLabel() {
        return label;
    }

    /**
     * Get the weight
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Add given user-defined property
     * @param key of property
     * @param value  of property
     * @return true or false
     */
    boolean add_properties(String key, String value){
       for (String s : keys) {
           if (s.equals(key))
               return false;
       }
       keys.add(key);
       values.add(value);
       return true;
   }
   /*
   public void print_porperties(){
       for (int i = 0; i < keys.size(); i++) {
           System.out.println(keys.get(i)+"------"+ values.get(i));
       }
   }*/

    /**
     * Filter the vertices by the given user-defined property and returns a subgraph of the graph.
     * @param key  wanted key
     * @param value  wanted value
     * @return true if the searched binary is found.
     */
    public boolean filter_porperties(String key,String value){
        for (int i = 0; i < keys.size(); i++) {
           if(keys.get(i).equals(key) && values.get(i).equals(value))
               return true;
        }
        return false;
    }

    /** Return a String representation of the vertex
     @return A String representation of the vertex
     */
    public String toString() {
        return "Vertex: " +
                "id = " + id +
                " label = '" + label + '\'' +
                " weight = " + weight +" --> ";
    }

    /** Return true if two vertex are equal.
     @param o The object to compare to
     @return true if the edges have the same
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return id == vertex.id && Double.compare(vertex.weight, weight) == 0 && Objects.equals(label, vertex.label);
    }

}
