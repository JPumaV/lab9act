package graph;

import listas.*;

public class GraphLink<E> {
    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new ListLinked<>();
    }

    public void insertVertex(E data) {
        if (!searchVertex(data)) {
            listVertex.add(new Vertex<>(data));
        }
    }

    private Vertex<E> getVertex(E data) {
        Node<Vertex<E>> current = listVertex.getHead();
        while (current != null) {
            if (current.getData().getData().equals(data))
                return current.getData();
            current = current.getNext();
        }
        return null;
    }

    public boolean searchVertex(E data) {
        return getVertex(data) != null;
    }

    public void insertEdge(E verOri, E verDes) {
        Vertex<E> v1 = getVertex(verOri);
        Vertex<E> v2 = getVertex(verDes);

        if (v1 != null && v2 != null && !v1.listAdj.contains(new Edge<>(v2))) {
            v1.listAdj.add(new Edge<>(v2));
            v2.listAdj.add(new Edge<>(v1));
        }
    }

    public boolean searchEdge(E v, E z) {
        Vertex<E> vertexV = getVertex(v);
        Vertex<E> vertexZ = getVertex(z);

        if (vertexV != null && vertexZ != null) {
            return vertexV.listAdj.contains(new Edge<>(vertexZ));
        }
        return false;
    }

    public void removeEdge(E v, E z) {
        Vertex<E> vertexV = getVertex(v);
        Vertex<E> vertexZ = getVertex(z);
        if (vertexV != null && vertexZ != null) {
            vertexV.listAdj.remove(new Edge<>(vertexZ));
            vertexZ.listAdj.remove(new Edge<>(vertexV));
        }
    }

    public void removeVertex(E v) {
        Vertex<E> vertex = getVertex(v);
        if (vertex != null) {
            // Eliminar conexiones con otros vértices
            Node<Vertex<E>> current = listVertex.getHead();
            while (current != null) {
                current.getData().listAdj.remove(new Edge<>(vertex));
                current = current.getNext();
            }
            listVertex.remove(vertex);
        }
    }

    public void dfs(E v) {
        Vertex<E> start = getVertex(v);
        if (start == null)
            return;

        ListLinked<Vertex<E>> visited = new ListLinked<>();
        dfsRecursive(start, visited);
    }

    private void dfsRecursive(Vertex<E> v, ListLinked<Vertex<E>> visited) {
        System.out.print(v.getData() + " ");
        visited.add(v);

        Node<Edge<E>> current = v.listAdj.getHead();
        while (current != null) {
            Vertex<E> neighbor = current.getData().getRefDest();
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
            current = current.getNext();
        }
    }

    public String toString() {
        return listVertex.toString();
    }
}
