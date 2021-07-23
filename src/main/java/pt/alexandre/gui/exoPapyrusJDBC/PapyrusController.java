package pt.alexandre.gui.exoPapyrusJDBC;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import pt.alexandre.gui.exoPapyrusJDBC.model.Fournisseur;
import pt.alexandre.gui.exoPapyrusJDBC.model.FournisseurDAO;
import pt.alexandre.gui.exoPapyrusJDBC.model.RequetePrepares;

import java.sql.ResultSet;
import java.sql.SQLException;

import static java.util.Objects.isNull;

public class PapyrusController
{
    @FXML
    public TextField codeFou;
    @FXML
    public TextField nomFou;
    @FXML
    public TextField addrFou;
    @FXML
    public TextField cpFou;
    @FXML
    public TextField villeFou;
    @FXML
    public TextField contactFou;

    private int code;

    private boolean resOk = false;

    private Fournisseur fournisseur;


    public void recupInfo() throws SQLException
    {
        if(codeFou.getText().matches("^\\p{Digit}+$"))
        {
            FournisseurDAO fournisseurDAO = new FournisseurDAO();
            code = Integer.parseInt(codeFou.getText());
            fournisseur = fournisseurDAO.trouverFournisseur(code);


            System.out.println(fournisseur.toString());
            if(fournisseurDAO.fournisseurValide(fournisseur)){
                nomFou.setText(fournisseur.getNomfou());
                villeFou.setText(fournisseur.getVilfou());
                cpFou.setText(fournisseur.getPosfou());
                addrFou.setText(fournisseur.getRuefou());
                contactFou.setText(fournisseur.getConfou());
            }else{
                                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("aucun fournisseur à ce numéro.");
                alert.setTitle("Aucun résultat");
                alert.showAndWait();
            }
        }else{
            Alert alert =  new Alert(Alert.AlertType.WARNING);
            alert.setContentText("ne rentrez que des chiffres");
            alert.setTitle("erreur de donnée d'entrée");
            alert.showAndWait();
        }

    }




}
