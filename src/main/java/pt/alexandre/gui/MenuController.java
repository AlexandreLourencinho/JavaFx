package pt.alexandre.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pt.alexandre.App;

import java.io.IOException;
import java.util.Objects;

/**
 * Classe permettant la gestion de la fenêtre principale de l'application, contenant les liens vers les différents exercices
 * ainsi que vers la "page 2" du menu
 * @see FXMLLoader
 * @see Scene
 * @see Parent
 * @see Alert
 * @author Alexandre Lourencinho
 */
public class MenuController
{
    public Button boutonAdd;
    public Button boutonCaza;
    public Stage stagefen = new Stage();
    public Button sliders;
    public Button sliders2;


    /**
     * Méthode ouvrant la fenêtre présentant l'additionneur
     * @see pt.alexandre.gui.additionneur.AdditionneurController
     */
    public void fenAdd()
    {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("additionneur/additionneur.fxml")));
            Scene scene = new Scene(root);
            stagefen.setTitle("additionneur");
            stagefen.setScene(scene);
            stagefen.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur FXML");
            alert.setContentText("Il y a eu un problème lors de l'ouverture de la fenêtre.");
            alert.showAndWait();
        }
    }

    /**
     * Méthode ouvrant la fenêtre présentant l'éditeur de style de texte
     * @see pt.alexandre.gui.lacazadacocher.LacazadacocherController
     */
    public void fenCaza()
    {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("lacazadacocher/lacazadacocher.fxml")));
            Scene scene = new Scene(root);
            stagefen.setTitle("la case à cocher");
            stagefen.setScene(scene);
            stagefen.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur FXML");
            alert.setContentText("Il y a eu un problème lors de l'ouverture de la fenêtre.");
            alert.showAndWait();
        }

    }

    /**
     * Méthode ouvrant la fenêtre présentant la version simple des sliders
     * @see pt.alexandre.gui.sliders.SlidersController
     */
    public void fenSliders()
    {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sliders/sliders.fxml")));
            Scene scene = new Scene(root);
            stagefen.setTitle("SLIDERS LES MONDES PARALLELES OMG");
            stagefen.setScene(scene);
            stagefen.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur FXML");
            alert.setContentText("Il y a eu un problème lors de l'ouverture de la fenêtre.");
            alert.showAndWait();
        }
    }

    /**
     * Méthode ouvrant la fenêtre présentant la version avec écouteurs des slider
     * @see pt.alexandre.gui.sliders2.Sliders2Controller
     */
    public void fenSlidersDeux()
    {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sliders2/sliders2.fxml")));
            Scene scene = new Scene(root);
            stagefen.setTitle("SLIDERS LES MONDES PARALLELES OMG2");
            stagefen.setScene(scene);
            stagefen.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur FXML");
            alert.setContentText("Il y a eu un problème lors de l'ouverture de la fenêtre.");
            alert.showAndWait();
        }
    }

    /**
     * Méthode ouvrant la fenêtre présentant l'interface d'exercice sur les tableview
     * @see pt.alexandre.gui.tableauClient.TableauClientController
     */
    public void fenClient()
    {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("tableauClient/tableauClient.fxml")));
            Scene scene = new Scene(root);
            stagefen.setTitle("Creation de taleau client");
            stagefen.setScene(scene);
            stagefen.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur FXML");
            alert.setContentText("Il y a eu un problème lors de l'ouverture de la fenêtre.");
            alert.showAndWait();
        }
    }

    /**
     * Méthode ouvrant la fenêtre présentant le transcodeur, permettant de chiffrer des messages via une clef
     * de chiffrement. Exercice adaptée de l'évaluation java "simple" en ligne de code
     * @see pt.alexandre.gui.leTranscodeur.LeTranscodeurController
     */
    public void fenTranscodeur()
    {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("leTranscodeur/leTranscodeur.fxml")));
            Scene scene = new Scene(root);
            stagefen.setTitle("EL FAMOSO TRANSCODEUR");
            stagefen.setScene(scene);
            stagefen.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur FXML");
            alert.setContentText("Il y a eu un problème lors de l'ouverture de la fenêtre.");
            alert.showAndWait();
        }
    }

    /**
     * Méthode ouvrant la fenêtre présentant le premier exercice JDBC basé sur la base "papyrus" (voir les éval SQL de TBDA)
     * la base est fournie dans le dossier
     * @see pt.alexandre.gui.exoPapyrusJDBC.PapyrusController
     */
    public void fenPapyrus()
    {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("exoPapyrusJDBC/papyrus.fxml")));
            Scene scene = new Scene(root);
            stagefen.setTitle("EL FAMOSO TRANSCODEUR");
            stagefen.setScene(scene);
            stagefen.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur FXML");
            alert.setContentText("Il y a eu un problème lors de l'ouverture de la fenêtre.");
            alert.showAndWait();
        }
    }

    /**
     * Méthode ouvrant la fenêtre présentant le deuxième exercice JDBC basé sur papyrus
     * @see pt.alexandre.gui.exoPapyrusJDBC.ListeCmdController
     */
    public void fenPapyrus2()
    {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("exoPapyrusJDBC/listeCmd.fxml")));
            Scene scene = new Scene(root);
            stagefen.setTitle("EL FAMOSO TRANSCODEUR");
            stagefen.setScene(scene);
            stagefen.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur FXML");
            alert.setContentText("Il y a eu un problème lors de l'ouverture de la fenêtre.");
            alert.showAndWait();
        }
    }


    /**
     * Passage page 2 du menu
     * @see Menu2Controller
     */
    public void pageSuivante()
    {
        try {
            App.changeFxml("menu2.fxml");
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("une erreur est survenue au changement de page.");
            alert.showAndWait();
        }
    }

}
