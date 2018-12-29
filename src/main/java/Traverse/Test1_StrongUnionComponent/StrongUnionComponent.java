package Traverse.Test1_StrongUnionComponent;


import Traverse.Test1_StrongUnionComponent.Entity.Edge;
import Traverse.Test1_StrongUnionComponent.Entity.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StrongUnionComponent {
    public LinkedList<Vertex> vertices = new LinkedList<>();
    Stack<Vertex> stack = new Stack();
    public ArrayList<LinkedList<Vertex>> unionComponents = new ArrayList<>();
    LinkedList<Vertex> unionComponent;

    Vertex deadVertex = new Vertex("dead");

    public StrongUnionComponent(LinkedList<Vertex> vertices, LinkedList<Edge> edges) {
        this.vertices = vertices;
        createMap(edges);
    }

    public void createMap(LinkedList<Edge> edges) {
        for (Edge edge : edges) {
            edge.getVertex1().nexts.add(edge.getVertex2());
        }
    }

    public void strongUnionComponent() {
        for (Vertex vertex : vertices) {
            if (vertex.isVisited == null) {
                stack.push(vertex);
                DFS(vertex);
            }
        }
    }

    public void DFS(Vertex vertex) {
        vertex.isVisited = vertex;

        if (vertex.nexts.size() != 0) {
            for (Vertex next : vertex.nexts) {
                if(next.isVisited == deadVertex){
                    continue;
                }

                if (next.isVisited != deadVertex && next.isVisited == null) {
                    stack.push(next);
                    DFS(next);
                    stack.pop();
                } else {
                    vertex.isVisited = next;

                    unionComponent = new LinkedList<>();
                    while (!stack.contains(next)) {
                        unionComponent.add(vertex.isVisited);
                        next = next.isVisited;
                    }

                    Vertex unionVertex = null;
                    Stack<Vertex> colnedStack = (Stack<Vertex>) stack.clone();
                    while (unionVertex != next) {
                        unionVertex = colnedStack.pop();
                        unionComponent.add(unionVertex);
                    }

                    unionComponents.add(unionComponent);
                }
            }
        } else {
            unionComponent = new LinkedList<>();
            unionComponent.add(vertex);
            unionComponents.add(unionComponent);

            vertex.isVisited = deadVertex;
        }
    }

    public boolean isStrongUnionComponent() {
        for (LinkedList<Vertex> unionComponent : unionComponents) {
            if (unionComponent.size() > 1) {
                return true;
            }
        }

        return false;
    }

    public void speak() {
        if (isStrongUnionComponent()) {
            System.out.println("包含强联通分量！");
        } else {
            System.out.println("不包含强联通分量");
        }
    }
}
