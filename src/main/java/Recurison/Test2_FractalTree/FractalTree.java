package Recurison.Test2_FractalTree;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class FractalTree extends Application {
    private Pane pane;
    private double[][] point; //用于存储树的节点

    private double paneWidth = 1400; //界面宽度
    private double paneHeight = 700; //界面高度
    private double length = 180; //初始线段长度
    private double width = 40; //初始线段长度

    private double angle = 30; //偏离角度
    private double lengthCoefficient = 0.75; //长度系数
    private double roughnessCoefficient = 0.8; //粗度系数

    private Color color = Color.BLACK; //是否随机偏离一定角度

    @Override
    public void start(Stage stage) throws Exception {
        point = new double[1][5];
        pane = new Pane();
        double startX = paneWidth / 2;
        double startY = paneHeight - paneHeight / 10;
        double endX = startX;
        double endY = startY - length;
        Line line = new Line(startX, startY, endX, endY);
        line.setStrokeWidth(width);
        pane.getChildren().add(line);

        point[0][0] = endX;
        point[0][1] = endY;
        point[0][2] = 0;
        point[0][3] = length;
        point[0][4] = width*roughnessCoefficient;
        final Scene scene = new Scene(pane, paneWidth, paneHeight);

        cycleDraw();

        stage.setScene(scene);
        stage.show();
    }

    public void cycleDraw(){
        while (point[0][3] >= 5){
            if(point[0][3] <= 8){
                color = Color.RED;
            }

            draw(getRandomAngle());
        }
    }

    public double getRandomAngle(){
        double random = Math.random() * 10 +10;

        return Math.PI / 180 * (angle + random);
    }

    int len, j, i;
    double[][] array;
    double startX, startY;
    double endX, endY;
    public void draw(double a) {
        len = point.length;
        array = new double[len * 2][point[0].length];
        j = 0;
        for (i = 0; i < len; i++) {
            startX = point[i][0];
            startY = point[i][1];
            double angle = point[i][2];
            double length = point[i][3];
            double width = point[i][4];

            //右边的线
            endX = startX + length * lengthCoefficient * Math.sin(angle + a);
            endY = startY - length * lengthCoefficient * Math.cos(angle + a);
            Line rightLine = new Line(startX, startY, endX, endY);
            rightLine.setStrokeWidth(width);
            rightLine.setStroke(color);
            pane.getChildren().add(rightLine);

            array[j][0] = endX;
            array[j][1] = endY;
            array[j][2] = angle + a;
            array[j][3] = length * lengthCoefficient;
            array[j][4] = width * roughnessCoefficient;
            j++;

            //左边的线
            a = getRandomAngle();
            endX = startX + length * lengthCoefficient * Math.sin(angle - a);
            endY = startY - length * lengthCoefficient * Math.cos(angle - a);
            Line leftLine = new Line(startX, startY, endX, endY);
            leftLine.setStrokeWidth(width);
            leftLine.setStroke(color);
            pane.getChildren().add(leftLine);

            array[j][0] = endX;
            array[j][1] = endY;
            array[j][2] = angle - a;
            array[j][3] = length * lengthCoefficient;
            array[j][4] = width * roughnessCoefficient;
            j++;
        }
        point = array;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
