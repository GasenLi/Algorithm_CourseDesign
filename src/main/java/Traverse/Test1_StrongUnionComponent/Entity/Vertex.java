package Traverse.Test1_StrongUnionComponent.Entity;

import java.util.LinkedList;

public class Vertex {
    public String name;
    public LinkedList<Vertex> nexts = new LinkedList<>();
    public Vertex isVisited;

    public Vertex(String name){
        this.name = name;
    }

}
