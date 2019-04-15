package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import sample.figures.Rectangle;

public class Main extends Application {
    double x1,x2,y1,y2;
    @Override
    public void start(Stage primaryStage) throws Exception{
       // public boolean isPressed;
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        //rect.draw(gc,60,60,80,80);

        EventHandler<MouseEvent> mousePressed=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Handled!");
                x1=event.getX();
                y1=event.getY();

            }
        };
        EventHandler<MouseEvent> mouseReleased=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("MOuse released!");
                x2=event.getX();
                y2=event.getY();
                Rectangle rect=new Rectangle();
                if (x2>x1) {
                    if(y2>y1) {
                        rect.draw(gc, x1, y1, x2 - x1, y2 - y1);
                    }
                    else{
                        rect.draw(gc,x1,y2,x2-x1,y1-y2);
                    }
                }
                else{
                    if(y2<y1){
                        rect.draw(gc,x2,y2,x1-x2,y1-y2);
                    }
                    else {
                        rect.draw(gc, x2, y1, x1 - x2, y2 - y1);
                    }
                }
            }
        };
        EventHandler<MouseEvent> mouseClicked=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Just clicked");
            }
        };
        canvas.setOnMousePressed(mousePressed);
      //  canvas.setOnMouseClicked(mouseClicked);
        canvas.setOnMouseReleased(mouseReleased);
        //canvas.addEventFilter(MouseEvent.MOUSE_PRESSED,mousePressed);
        //canvas.addEventFilter(MouseEvent.MOUSE_RELEASED,mouseReleased);
       // canvas.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseClicked);

        //rect.(MouseEvent.MOUSE_CLICKED, eventHandler);
        //draw(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public void draw(GraphicsContext gc){
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);
    }
}
