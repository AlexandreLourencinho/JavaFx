package pt.alexandre.gui.exoPapyrusJDBC;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import pt.alexandre.gui.exoPapyrusJDBC.model.Fournisseur;
import pt.alexandre.gui.exoPapyrusJDBC.model.FournisseurDAO;
import java.sql.SQLException;

/**
 * Classe permettant l'execution des scripts pour l'exercice sur la recherche et récupération des informations d'un fournisseur
 * dans la table fournis de la base papyrus
 * @see TextField
 * @see Fournisseur
 * @see FournisseurDAO
 * @see FournisseurDAO#fournisseurValide(Fournisseur)
 * @see FournisseurDAO#trouverFournisseur(int)
 * @see Integer
 * @see Alert
 * @author Alexandre Lourencinho
 */
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


    /**
     * méthode permettant de récupérer les informations d'un fournisseur de la table papyrus
     */
    public void recupInfo()
    {
        try {
            if(codeFou.getText().matches("^\\p{Digit}+$"))
            {
                FournisseurDAO fournisseurDAO = new FournisseurDAO();
                code = Integer.parseInt(codeFou.getText());
                Fournisseur fournisseur = fournisseurDAO.trouverFournisseur(code);


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
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("erreur - FRI");
            alert.setContentText("Il y a eu une erreur lors de l'exécution du script");
            alert.showAndWait();
        }
    }
}
