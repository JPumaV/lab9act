
package graph;

public class Main {
    public static void main(String[] args) {
        GraphLink<String> graph = new GraphLink<>();

        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");

        graph.insertEdge("A", "B");
        graph.insertEdge("A", "C");
        graph.insertEdge("B", "D");

        System.out.println("Grafo:");
        System.out.println(graph);

        System.out.println("¿Existe el vértice C?: " + graph.searchVertex("C"));
        System.out.println("¿Existe la arista A-B?: " + graph.searchEdge("A", "B"));

        graph.removeEdge("A", "B");
        System.out.println("Después de eliminar la arista A-B:");
        System.out.println(graph);

        System.out.println("Recorrido DFS desde A:");
        graph.dfs("A");

        graph.removeVertex("C");
        System.out.println("\nDespués de eliminar el vértice C:");
        System.out.println(graph);
    }
}