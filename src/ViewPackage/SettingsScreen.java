package ViewPackage;


import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SettingsScreen {
    private String Difficulty;

    public void getsSettingsScreen(){
        Stage settingsStage = new Stage();
        settingsStage.setTitle("Settings");

        Label difficultyLabel = new Label("Difficulty");
        difficultyLabel.setStyle("-fx-background-color: TRANSPARENT");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Easy");
        choiceBox.getItems().add("Intermediate");
        choiceBox.getItems().add("Expert");



    }

}
