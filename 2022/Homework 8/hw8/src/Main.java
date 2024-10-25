public class Main {

    public static void main(String[] args) {
    //////////////////////////////////////////////////////////////////////////////////////Directed

        MyGraph graph1 = new MyGraph(3,true);
        System.out.println("-----------Start-------------------");
        graph1.printGraph();
        System.out.println("------------New Vertex--------------");
        graph1.newVertex("D", 21);
        graph1.printGraph();

        System.out.println("-------------Add Vertex--------------");
        Vertex temp = new Vertex(9,"E",4);
        graph1.addVertex(temp);
        graph1.printGraph();

        System.out.println("-------------Add Edge----------------");
        graph1.addEdge(0, 1,5);
        graph1.addEdge(0, 2,3);
        graph1.addEdge(1, 3,8);
        graph1.addEdge(2, 4,6);
        graph1.addEdge(3, 2,1);
        graph1.addEdge(3, 4,2);
        graph1.printGraph();
        System.out.println("---------Export Matrix---------");
        graph1.exportMatrix();

        System.out.println("-------Remove Edge-----------");
        graph1.removeEdge(3, 2);
        graph1.printGraph();

        System.out.println("--------Remove vertex---------");
        graph1.removeVertex(2);
        graph1.printGraph();
        System.out.println("-------Key-Value------------------------");
        graph1.add_properties(3,"color","pink");
        graph1.add_properties(1,"color","orange");
        graph1.add_properties(0,"color","yellow");
        graph1.add_properties(4,"color","blue");
        graph1.add_properties(4,"color","yellow");
        graph1.add_properties(1,"size","50");
        graph1.add_properties(3,"size","25");
        graph1.filterVertices("color","yellow");
        System.out.println("--------Remove Vertex label---------------");
        graph1.removeVertex("A");
        graph1.printGraph();
        //////////////////////////////////////////////////////////////////////////////// !isDirected
        MyGraph graph2 = new MyGraph(3,false);
        System.out.println("-----------Start-------------------");
        graph2.printGraph();
        System.out.println("");
        System.out.println("------------New Vertex--------------");
        graph2.newVertex("D", 21);
        graph2.printGraph();
        System.out.println("-------------Add Vertex--------------");
        Vertex temps = new Vertex(4,"E",4);
        graph2.addVertex(temps);
        graph2.printGraph();

        System.out.println("-------------Add Edge----------------");
        graph2.addEdge(0, 1,5);
        graph2.addEdge(1, 2,3);
        graph2.addEdge(2, 3,2);
        graph2.addEdge(3, 4,4);
        graph2.printGraph();
        System.out.println("---------Export Matrix---------");
        graph2.exportMatrix();

        System.out.println("-------Remove Edge-----------");
        graph2.removeEdge(3, 2);
        graph2.printGraph();

        System.out.println("--------Remove vertex---------");
        graph2.removeVertex(4);
        graph2.printGraph();


    }
}
