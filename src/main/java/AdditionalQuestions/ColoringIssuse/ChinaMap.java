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

        System.out.println(chinaMap.vertices);
    }



    public void getCities(){
        try {
            File cityFile = new File("E:\\workplace\\Algorithm_CourseDesign\\src\\AdditionalQuestions\\ColoringIssuse\\Data\\Cities.txt");
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
}
