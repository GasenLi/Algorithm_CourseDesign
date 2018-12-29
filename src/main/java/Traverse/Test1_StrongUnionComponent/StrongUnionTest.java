package Traverse.Test1_StrongUnionComponent;

import Traverse.Test1_StrongUnionComponent.Entity.Edge;
import Traverse.Test1_StrongUnionComponent.Entity.Vertex;

import java.util.LinkedList;

public class StrongUnionTest {

    public static void main(String[] args) {
        LinkedList<Vertex> vertices = new LinkedList<>();
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Vertex vertex4 = new Vertex("D");
        Vertex vertex5 = new Vertex("E");
        Vertex vertex6 = new Vertex("F");
        Vertex vertex7 = new Vertex("G");
        vertices.add(vertex1);
        vertices.add(vertex2);
        vertices.add(vertex3);
        vertices.add(vertex4);
        vertices.add(vertex5);
        vertices.add(vertex6);
        vertices.add(vertex7);

        LinkedList<Edge> edges = new LinkedList<>();
        edges.add(new Edge(vertex1, vertex2));
        edges.add(new Edge(vertex2, vertex3));
        edges.add(new Edge(vertex3, vertex4));
        edges.add(new Edge(vertex3, vertex5));
        edges.add(new Edge(vertex5, vertex4));
        edges.add(new Edge(vertex5, vertex2));
        edges.add(new Edge(vertex5, vertex6));
        edges.add(new Edge(vertex5, vertex7));
        edges.add(new Edge(vertex6, vertex7));
        edges.add(new Edge(vertex7, vertex1));


        StrongUnionComponent strongUnionComponent = new StrongUnionComponent(vertices, edges);
        strongUnionComponent.strongUnionComponent();
        strongUnionComponent.speak();
    }

}
