package pt.alexandre.gui.exoPapyrusJDBC;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import pt.alexandre.gui.exoPapyrusJDBC.model.Commandes;
import pt.alexandre.gui.exoPapyrusJDBC.model.CommandesDAO;
import pt.alexandre.gui.exoPapyrusJDBC.model.Fournisseur;
import pt.alexandre.gui.exoPapyrusJDBC.model.FournisseurDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe permettant la gestion de l'affichage de la liste des commandes par fournisseur. Cadre : exercices JDBC sur
 * la base papyrus
 *
 * @author Alexandre Lourencinho
 * @see Fournisseur
 * @see FournisseurDAO
 * @see FournisseurDAO#listeFournisseurs()
 * @see ObservableList
 * @see ComboBox
 * @see javafx.scene.control.TextArea
 * @see ResultSet
 */
public class ListeCmdController
{

    @FXML
    public ComboBox<Fournisseur> listeFou;
    public TextArea zoneTexte;

    private ObservableList<Fournisseur> dbTypeList = FXCollections.observableArrayList();
    private ArrayList<Fournisseur> listeFourn;


    /**
     * méthode permettant de générer et afficher dans une liste déroulante la liste des fournisseurs
     */
    public void initialize()
    {
        try
        {
            FournisseurDAO fournisseurDAO = new FournisseurDAO();
            dbTypeList.addAll(fournisseurDAO.listeFournisseurs());
            listeFou.setPromptText("Sélectionnez un fournisseur");
            listeFou.setItems(dbTypeList);
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(
                    "Il y a eu une erreur à la récupération des fournisseurs, veuillez contacter un administrateur");
            alert.showAndWait();
        }
    }

    /**
     * méthode appelant celle récupérant les informations de commandes d'un fournisseur et l'affichant dans la zone de
     * texte prévue à cet effet
     */
    public void comFourni()
    {
        try
        {
            FournisseurDAO fournisseurDAO = new FournisseurDAO();
            if (listeFou.getSelectionModel().getSelectedItem().getNumfou() == 0000)
            {
                CommandesDAO reqCom = new CommandesDAO();
               ArrayList<Commandes> listeDesCom= reqCom.liste();
               for(Commandes com : listeDesCom){
                   zoneTexte.appendText(com.toString()+"\n");
               }
            } else
            {
                Commandes com = fournisseurDAO.comFournisseur(listeFou.getSelectionModel().getSelectedItem());
                zoneTexte.setText(com.toString());
            }
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(
                    "Il y a eu une erreur à l'affichage des commandes, veuillez contacter un administrateur");
            alert.showAndWait();
        }

    }


}
