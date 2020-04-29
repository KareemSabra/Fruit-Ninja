
import java.util.ArrayList;

import LogicPackage.Misc.ImportImage;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Testss extends Application {

    private int db = 10;
    private int dor = 10;
    private int ds = 10;
    private int dw = 10;
    ArrayList<ImageView> images = new ArrayList<>();
    ArrayList<Image> images2 = new ArrayList<>();


    public static void main(String[] args) {
        launch();

    }


    @Override
    public void start(Stage primaryStage) throws Exception {


        Pane root = new Pane();

        Image image = new ImportImage().getImage("Banana.png");
        ImageView imageView = new ImageView(image);
        imageView.setY(500);
        imageView.setLayoutX(50);
        images.add(imageView);
        images2.add(image);

        Image image1 = new ImportImage().getImage("BananaSliced.png");
        ImageView imageView1 = new ImageView(image1);
        imageView1.setY(500);
        imageView1.setLayoutX(50);
        //images2.add(image1);

        Image image2 = new ImportImage().getImage("Strawberry.png");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setY(500);
        imageView2.setLayoutX(350);
        images.add(imageView2);
        images2.add(image2);

        Image image3 = new ImportImage().getImage("StrawberrySliced.png");
        ImageView imageView3 = new ImageView(image3);
        imageView3.setY(500);
        imageView3.setLayoutX(350);

        Image image4 = new ImportImage().getImage("Orange.png");
        ImageView imageView4 = new ImageView(image4);
        imageView4.setY(500);
        imageView4.setLayoutX(150);
        images.add(imageView4);
        images2.add(image4);

        Image image5 = new ImportImage().getImage("OrangeSliced.png");
        ImageView imageView5 = new ImageView(image5);
        imageView5.setY(500);
        imageView5.setLayoutX(150);
        //imagesSliced.add(image5);

        Image image6 = new ImportImage().getImage("Watermelon.png");
        ImageView imageView6 = new ImageView(image6);
        imageView6.setY(500);
        imageView6.setLayoutX(250);
        images.add(imageView6);
        images2.add(image6);

        Image image7 = new ImportImage().getImage("WatermelonSliced.png");
        ImageView imageView7 = new ImageView(image7);
        imageView7.setY(500);
        imageView7.setLayoutX(250);
        //imagesSliced.add(image7);

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
        rectangle1.setY(800);
        rectangle1.setFill(Color.TRANSPARENT);
        root.getChildren().add(rectangle1);


        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(150),
                        (evt) -> {

                            imageView.setY(imageView.getY() - db);
                            imageView2.setY(imageView2.getY() - ds);
                            imageView4.setY(imageView4.getY() - dor);
                            imageView6.setY(imageView6.getY() - dw);

                            if (imageView.getBoundsInLocal().intersects(rectangle.getBoundsInLocal())) {

                                db = -db - 2;
                            }

                            if (imageView2.getBoundsInLocal().intersects(rectangle.getBoundsInLocal())) {


                                ds = -ds - 2;
                            }

                            if (imageView4.getBoundsInLocal().intersects(rectangle.getBoundsInLocal())) {


                                dor = -dor - 2;
                            }

                            if (imageView6.getBoundsInLocal().intersects(rectangle.getBoundsInLocal())) {


                                dw = -dw - 2;
                            }

                            if ((imageView.getBoundsInLocal().intersects(rectangle1.getBoundsInLocal()))) {


                                    if(imageView.getImage().equals(image1)) {
                                        imageView.setImage(images2.get(2));
                                    }
                                else if(imageView.getImage().equals(image5)) {
                                    imageView.setImage(images2.get(3));
                                }
                                else if(imageView.getImage().equals(image7)) {
                                        imageView.setImage(images2.get(1));
                                    }
                                    else if(imageView.getImage().equals(image3)) {
                                        imageView.setImage(images2.get(0));
                                    }


                                db = db + 22;
                            }

                            if ((imageView2.getBoundsInLocal().intersects(rectangle1.getBoundsInLocal()))) {


                                if(imageView2.getImage().equals(image3)) {
                                    imageView2.setImage(images2.get(0));
                                }
                                else if(imageView2.getImage().equals(image1)) {
                                    imageView2.setImage(images2.get(3));
                                }
                                else if(imageView2.getImage().equals(image7)) {
                                    imageView2.setImage(images2.get(2));
                                }
                                else if(imageView2.getImage().equals(image5)) {
                                    imageView2.setImage(images2.get(1));
                                }


                                ds = ds + 22;
                            }

                            if ((imageView4.getBoundsInLocal().intersects(rectangle1.getBoundsInLocal()))) {


                                if(imageView4.getImage().equals(image5)) {
                                    imageView4.setImage(images2.get(1));
                                }
                                else if(imageView4.getImage().equals(image3)) {
                                    imageView4.setImage(images2.get(0));
                                }

                                else if(imageView4.getImage().equals(image1)) {
                                    imageView4.setImage(images2.get(3));
                                }
                                else if(imageView4.getImage().equals(image7)) {
                                    imageView4.setImage(images2.get(2));
                                }

                                dor = dor + 22;
                            }

                            if ((imageView6.getBoundsInLocal().intersects(rectangle1.getBoundsInLocal()))) {


                                if(imageView6.getImage().equals(image7)) {
                                    imageView6.setImage(images2.get(2));
                                }
                                else if(imageView6.getImage().equals(image5)) {
                                    imageView6.setImage(images2.get(1));
                                }
                                else if(imageView6.getImage().equals(image3)) {
                                    imageView6.setImage(images2.get(0));
                                }
                                else if(imageView6.getImage().equals(image1)) {
                                    imageView6.setImage(images2.get(3));
                                }

                                dw = dw + 22;
                            }


                            root.setOnDragDetected(e -> root.startFullDrag());
                            imageView.setOnMouseDragEntered(evt2 -> {


                                if(imageView.getImage().equals(images2.get(0))) {
                                    imageView.setImage(image1);
                                }
                                else if(imageView.getImage().equals(images2.get(1))) {
                                    imageView.setImage(image3);
                                }
                                else if(imageView.getImage().equals(images2.get(2))) {
                                    imageView.setImage(image5);
                                }
                                else if(imageView.getImage().equals(images2.get(3))) {
                                    imageView.setImage(image7);
                                }

                            });
                            imageView2.setOnMouseDragEntered(evt3 -> {

                                if(imageView2.getImage().equals(images2.get(0))) {
                                    imageView2.setImage(image1);
                                }
                                else if(imageView2.getImage().equals(images2.get(1))) {
                                    imageView2.setImage(image3);
                                }
                                else if(imageView2.getImage().equals(images2.get(2))) {
                                    imageView2.setImage(image5);
                                }
                                else if(imageView2.getImage().equals(images2.get(3))) {
                                    imageView2.setImage(image7);
                                }

                            });

                            imageView4.setOnMouseDragEntered(evt3 -> {

                                if(imageView4.getImage().equals(images2.get(0))) {
                                    imageView4.setImage(image1);
                                }
                                else if(imageView4.getImage().equals(images2.get(1))) {
                                    imageView4.setImage(image3);
                                }
                                else if(imageView4.getImage().equals(images2.get(2))) {
                                    imageView4.setImage(image5);
                                }
                                else if(imageView4.getImage().equals(images2.get(3))) {
                                    imageView4.setImage(image7);
                                }

                            });

                            imageView6.setOnMouseDragEntered(evt3 -> {

                                if(imageView6.getImage().equals(images2.get(0))) {
                                    imageView6.setImage(image1);
                                }
                                else if(imageView6.getImage().equals(images2.get(1))) {
                                    imageView6.setImage(image3);
                                }
                                else if(imageView6.getImage().equals(images2.get(2))) {
                                    imageView6.setImage(image5);
                                }
                                else if(imageView6.getImage().equals(images2.get(3))) {
                                    imageView6.setImage(image7);
                                }

                            });


                        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public int rand(int min, int max) {
        return (int) (Math.random() * max + min);
    }
}