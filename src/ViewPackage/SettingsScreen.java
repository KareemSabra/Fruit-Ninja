package ViewPackage;


import LogicPackage.Instantiation.PlayerSingleton;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SettingsScreen {
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();
    private static SettingsScreen instance;
    private String difficulty = "Easy";

    public static SettingsScreen getInstance(){
        if (instance == null)
            instance = new SettingsScreen();
        return instance;
    }

    private SettingsScreen() {
    }

    public String getDifficulty(){
        return this.difficulty;
    }

    public void getsSettingsScreen(){
        Stage settingsStage = new Stage();
        settingsStage.setTitle("Settings");

        Label difficultyLabel = new Label("Difficulty");
        difficultyLabel.setStyle("-fx-background-color: TRANSPARENT");

        choiceBox.getItems().add("Easy");
        choiceBox.getItems().add("Medium");
        choiceBox.getItems().add("Hard");
        choiceBox.setValue("Easy");


        Button but = new Button();
        but.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                difficulty = choiceBox.getValue();
            }
        });


        HBox difficultyBox = new HBox(20,difficultyLabel,choiceBox,but);
        Scene scene = new Scene(difficultyBox,600,700);
        settingsStage.setScene(scene);
        settingsStage.show();


    }

}
