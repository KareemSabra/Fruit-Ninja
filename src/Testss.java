import java.util.ArrayList;
import java.util.List;

import LogicPackage.GameObject;
import LogicPackage.ImportImage;
import LogicPackage.Instantiation.FruitFactory.FruitFactory;
import LogicPackage.Instantiation.FruitFactory.Pineapple;
import LogicPackage.Instantiation.Game.Game;
import com.sun.xml.internal.bind.WhiteSpaceProcessor;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.WHITE;

public class Testss extends Application {

    private int dy = 10;
    int i = rand(0,2);
    int j = rand(0,2);
    ArrayList<ImageView> images = new ArrayList<>();



    public static void main(String[] args) {
        launch();

    }


    @Override
    public void start(Stage primaryStage) throws Exception {



        Pane root = new Pane();

        Image image = new ImportImage().getImage("Arcade.png");
        ImageView imageView = new ImageView(image);
        imageView.setY(500);
        imageView.setLayoutX(rand(100,300));
        images.add(imageView);

        Image image1 = new ImportImage().getImage("Classic.png");
        ImageView imageView1 = new ImageView(image1);
        imageView1.setY(500);
        imageView1.setLayoutX(rand(100,300));
        images.add(imageView1);

        Image image2 = new ImportImage().getImage("NewGameButton.png");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setY(500);
        imageView2.setLayoutX(rand(100,300));
        images.add(imageView2);

        Image image3 = new ImportImage().getImage("ContinueGameButton.png");
        ImageView imageView3 = new ImageView(image3);
        imageView3.setY(500);
        imageView3.setLayoutX(rand(100,300));
        images.add(imageView3);


        root.getChildren().addAll(images);

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(1);
        rectangle.setWidth(500);
        rectangle.setY(100);
        rectangle.setFill(Color.TRANSPARENT);
        root.getChildren().add(rectangle);

        Rectangle rectangle1 = new Rectangle();
        rectangle1.setHeight(1);
        rectangle1.setWidth(500);
        rectangle1.setY(700);
        rectangle1.setFill(Color.TRANSPARENT);
        root.getChildren().add(rectangle1);

        System.out.println(i);
        System.out.println(j);




            Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(100),
                        (evt) -> {

                            if(i == 1)
                            {

                                imageView.setY(imageView.getY() - dy);
                                imageView1.setY(imageView1.getY() - dy);

                                if(imageView1.getBoundsInLocal().intersects(rectangle.getBoundsInLocal())) {

                                    System.out.println("CLASH UP");
                                    dy = -dy-2;
                                }

                            if((imageView1.getBoundsInLocal().intersects(rectangle1.getBoundsInLocal())) && ((j==1)||(i!=1)) ) {


                                System.out.println("CLASH DOWN");
                                dy = dy+22;
                            }}

                            if(j == 0)
                            {

                                imageView2.setY(imageView2.getY() - dy);
                                imageView3.setY(imageView3.getY() - dy);

                                if(imageView2.getBoundsInLocal().intersects(rectangle.getBoundsInLocal())) {

                                    System.out.println("CLASH UP");
                                    dy = -dy-2;
                                }

                                if((imageView2.getBoundsInLocal().intersects(rectangle1.getBoundsInLocal())) && ((i==0)||(j!=0)) ) {

                                    System.out.println("CLASH DOWN");
                                    dy = dy+22;
                                }}

                            }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(root,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();

        }

    public int rand(int min, int max) {
        return (int)(Math.random() * max + min);
    }

}