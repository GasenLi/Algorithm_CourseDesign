package AdditionalQuestions.ColoringIssuse;

import AdditionalQuestions.ColoringIssuse.Entity.Edge;
import AdditionalQuestions.ColoringIssuse.Entity.Vertex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChinaMap {
    private ArrayList<Vertex> vertices = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();


    public static void main(String[] args) {
        ChinaMap chinaMap = new ChinaMap();

        chinaMap.getCities();
        chinaMap.getEdges();

        Coloring coloring = new Coloring(chinaMap.vertices, chinaMap.edges);
        coloring.coloring();
        coloring.speak();
    }

    public Vertex getVertexByName(String cityName){
        for(int i=0; i<vertices.size(); i++){
            if(vertices.get(i).getName().equals(cityName)){
                return vertices.get(i);
            }
        }

        return null;
    }


    public void getCities(){
        try {
            File cityFile = new File("E:\\workplace\\Algorithm_CourseDesign\\src\\main\\java\\AdditionalQuestions\\ColoringIssuse\\Data\\Cities.txt");
            Scanner scanner = new Scanner(cityFile);

            String city;
            while (scanner.hasNextLine()){
                city = scanner.nextLine();
                vertices.add(new Vertex(city));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getEdges(){
        try {
            File edgeFile = new File("E:\\workplace\\Algorithm_CourseDesign\\src\\main\\java\\AdditionalQuestions\\ColoringIssuse\\Data\\Edges.txt");
            Scanner scanner = new Scanner(edgeFile);

            String line;
            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                String[] cities = line.split("-");

                edges.add(new Edge(getVertexByName(cities[0]), getVertexByName(cities[1])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
