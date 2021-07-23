package pt.alexandre.gui.exoPapyrusJDBC;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import pt.alexandre.gui.exoPapyrusJDBC.model.Fournisseur;
import pt.alexandre.gui.exoPapyrusJDBC.model.FournisseurDAO;
import pt.alexandre.gui.exoPapyrusJDBC.model.RequetePrepares;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AjoutFournisController {


    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtRue;
    @FXML
    private TextField txtCp;
    @FXML
    private TextField txtVille;
    @FXML
    private TextField txtContact;


    public void ajouter()
    {
        Fournisseur fourni = new Fournisseur();
        FournisseurDAO reqFourni = new FournisseurDAO();
        try
        {
            fourni.setNumfou(reqFourni.dernierNumfou());
            fourni.setNomfou(txtNom.getText());
            fourni.setRuefou(txtRue.getText());
            fourni.setPosfou(txtCp.getText());
            fourni.setVilfou(txtVille.getText());
            fourni.setConfou(txtContact.getText());
            if(reqFourni.ajouterFournisseur(fourni)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("vous avez ajouté le fournisseur " + fourni.getNomfou() + " !");
            alert.setTitle("Tout s'est bien passé.");
            alert.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("vous n'avez pas ajouté le fournisseur " + fourni.getNomfou() + " !");
                alert.setTitle("Problème lors de l'appel de la requête");
                alert.showAndWait();
            }
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("problème d'insertion " + e.getMessage());
            alert.showAndWait();
        }
    }
}
