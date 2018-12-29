package AdditionalQuestions.ColoringIssuse;

import AdditionalQuestions.ColoringIssuse.Entity.Edge;
import AdditionalQuestions.ColoringIssuse.Entity.Vertex;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        ArrayList<Vertex> vertices = new ArrayList<>();
        char v = 'A';
        for(int i=0; i<5; i++){
            vertices.add(new Vertex(v+""));
            v++;
        }

        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(vertices.get(0), vertices.get(1)));
        edges.add(new Edge(vertices.get(0), vertices.get(2)));
        edges.add(new Edge(vertices.get(2), vertices.get(3)));
        edges.add(new Edge(vertices.get(3), vertices.get(1)));
        edges.add(new Edge(vertices.get(3), vertices.get(4)));
        edges.add(new Edge(vertices.get(1), vertices.get(4)));


        Coloring coloring = new Coloring(vertices, edges);
        coloring.coloring();
        coloring.speak();
    }
}
