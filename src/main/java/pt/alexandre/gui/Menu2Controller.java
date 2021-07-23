package pt.alexandre.gui;

import javafx.scene.control.Alert;
import pt.alexandre.App;

import java.io.IOException;

public class Menu2Controller {

    public void pagePrecedente()
    {
        try {
            App.changeFxml("menu.fxml");
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("une erreur est survenue au changement de page.");
            alert.showAndWait();
        }
    }
}
