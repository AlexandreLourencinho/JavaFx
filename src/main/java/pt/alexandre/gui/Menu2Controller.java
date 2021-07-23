package pt.alexandre.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import pt.alexandre.App;

import java.io.IOException;

public class Menu2Controller {

    public Stage stagefen = new Stage();

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

    public void fenPapyrus2() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("exoPapyrusJDBC/ajoutFournis.fxml"));
        Scene scene = new Scene(root);
        stagefen.setTitle("EL FAMOSO TRANSCODEUR");
        stagefen.setScene(scene);
        stagefen.show();
    }




}
