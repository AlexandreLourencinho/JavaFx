package pt.alexandre.gui.exoPapyrusJDBC;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
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

    private int plusGrandNumfou;


    public int avoirPlusGrandNumfou()
    {
        RequetePrepares req = new RequetePrepares();
        int recup=0;
        try
        {
                recup = req.grosNumfou();
            return recup;
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("problème de grosnumfou");
            alert.showAndWait();
            return 0;
        }
    }

    public void ajouter()
    {
        String nom,rue,cp,ville,contact;
        RequetePrepares req = new RequetePrepares();
        try
        {
            nom = txtNom.getText();
            rue = txtRue.getText();
            cp = txtCp.getText();
            ville = txtVille.getText();
            contact=txtContact.getText();
            plusGrandNumfou = avoirPlusGrandNumfou()+1;
            if(req.ajoutFournis(plusGrandNumfou,nom,rue,cp,ville,contact)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("vous avez ajouter le fournisseur " + nom + " !");
            alert.showAndWait();
            }
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("problème d'insertion");
            alert.showAndWait();
        }
    }
}
