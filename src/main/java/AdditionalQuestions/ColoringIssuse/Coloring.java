package AdditionalQuestions.ColoringIssuse;

import AdditionalQuestions.ColoringIssuse.Entity.Edge;
import AdditionalQuestions.ColoringIssuse.Entity.Vertex;

import java.util.*;

public class Coloring {
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;

    //将所有顶点的边分别存储起来
    private HashMap<Vertex, LinkedList<Vertex>> edgeMap;

    private String[] colors = new String[10];

    public Coloring(ArrayList<Vertex> vertices, ArrayList<Edge> edges){
        this.vertices = vertices;
        this.edges = edges;

        for(int i=0; i<10; i++){
            colors[i] = i+"";
        }

        initialEdgeLists();
    }

    public void initialEdgeLists(){
        edgeMap = new HashMap<>();

        //初始化所有顶点
        for(Vertex vertex : vertices){
            edgeMap.put(vertex, new LinkedList<>());
        }

        //为所有顶点加边
        for(Edge edge : edges){
            edgeMap.get(edge.getVertex1()).add(edge.getVertex2());
            edgeMap.get(edge.getVertex2()).add(edge.getVertex1());
        }
    }

    //选取可选的颜色
    public String getExtraColor(Set<String> usedColors){

        int setLengthBefor = 0, setLengthAfter = 0;
        for(String acolor : colors){
            setLengthBefor = usedColors.size();
            usedColors.add(acolor);
            setLengthAfter = usedColors.size();

            if(setLengthAfter != setLengthBefor){
                return acolor;
            }
        }

        return null;
    }


    public void coloring(){
        for(Map.Entry<Vertex, LinkedList<Vertex>> entry : edgeMap.entrySet()){
            Set<String> usedColor = new HashSet<>();

            for(Vertex vertex : entry.getValue()){
                if(vertex.getColor()!=null){
                    usedColor.add(vertex.getColor());
                }
            }

            entry.getKey().setColor(getExtraColor(usedColor));
        }
    }

    public void speak() {
        for(Vertex vertex : vertices){
            System.out.println(vertex.getName() + "---" + vertex.getColor());
        }
    }
}
