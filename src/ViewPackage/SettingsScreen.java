package ViewPackage;


import LogicPackage.Instantiation.PlayerSingleton;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SettingsScreen {
    private ChoiceBox<String> choiceBox;
    private static SettingsScreen instance;

    public static SettingsScreen getInstance(){
        if (instance == null)
            instance = new SettingsScreen();
        return instance;
    }

    private SettingsScreen() {
    }

    public String getDifficulty(){
        return this.choiceBox.getValue();
    }

    public void getsSettingsScreen(){
        Stage settingsStage = new Stage();
        settingsStage.setTitle("Settings");

        Label difficultyLabel = new Label("Difficulty");
        difficultyLabel.setStyle("-fx-background-color: TRANSPARENT");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Easy");
        choiceBox.getItems().add("Intermediate");
        choiceBox.getItems().add("Expert");
        choiceBox.setValue("Easy");


        HBox difficultyBox = new HBox(20,difficultyLabel,choiceBox);
        Scene scene = new Scene(difficultyBox,600,700);
        settingsStage.setScene(scene);
        settingsStage.show();


    }

}
