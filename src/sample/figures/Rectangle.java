package sample.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends AbstrFigure {
    @Override
    public void draw(GraphicsContext gc,double x1,double y1,double x2,double y2){
      //  gc.setFill(Color.GREEN);
       // gc.setStroke(Color.BLUE);
       // gc.setLineWidth(5);
       // gc.strokeLine(40, 10, 10, 40);
       // gc.fillOval(10, 60, 30, 30);
       // gc.strokeOval(60, 60, 30, 30);
       // gc.strokeRect(100,100,200,340);
        gc.strokeRect(x1,y1,x2,y2);
    }
}
