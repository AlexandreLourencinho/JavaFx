package pt.alexandre.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import pt.alexandre.App;

import java.io.IOException;
import java.util.Objects;

/**
 * Deuxième page du menu de l'application
 * @see Stage
 * @see Scene
 * @see Parent
 * @see FXMLLoader
 * @see Alert
 * @author Alexandre Lourencinho
 */
public class Menu2Controller {

    public Stage stagefen = new Stage();

    /**
     * retour à la page 1 du menu
     * @see MenuController
     */
    public void pagePrecedente()
    {
        try {
            App.changeFxml("menu.fxml");
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("une erreur est survenue au changement de page.");
            alert.showAndWait();
        }
    }

    /**
     * méthode ouvrant le troisième exercice JDBC sur la base papyrus
     * @see pt.alexandre.gui.exoPapyrusJDBC.AjoutFournisController
     */
    public void fenPapyrus3()
    {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("exoPapyrusJDBC/ajoutFournis.fxml")));
            Scene scene = new Scene(root);
            stagefen.setTitle("EL FAMOSO TRANSCODEUR");
            stagefen.setScene(scene);
            stagefen.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("une erreur est survenue au changement de page.");
            alert.showAndWait();
        }
    }

    public void fenGestionTableClient()
    {
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gestionTableClient/gestionTableClient.fxml")));
            Scene scene = new Scene(root);
            stagefen.setTitle("Gestion de la table client");
            stagefen.setScene(scene);
            stagefen.show();
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur FXML-FGTC");
            alert.setContentText("Erreur lors du chargement du sous-programme");
            alert.showAndWait();
        }
    }

    public void fenTestApi()
    {
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("testapi/testapiint.fxml")));
            Scene scene = new Scene(root);
            stagefen.setTitle("test api sur java");
            stagefen.setScene(scene);
            stagefen.show();
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur FXML-FTA");
            alert.setContentText("Erreur lors du chargement du sous-programme");
            alert.showAndWait();
        }

    }



}
