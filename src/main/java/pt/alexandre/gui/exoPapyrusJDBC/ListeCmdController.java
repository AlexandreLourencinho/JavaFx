package pt.alexandre.gui.exoPapyrusJDBC;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import pt.alexandre.gui.exoPapyrusJDBC.model.Fournisseur;
import pt.alexandre.gui.exoPapyrusJDBC.model.FournisseurDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe permettant la gestion de l'affichage de la liste des commandes par fournisseur. Cadre : exercices JDBC sur
 * la base papyrus
 * @see Fournisseur
 * @see FournisseurDAO
 * @see FournisseurDAO#listeFournisseurs()
 * @see FournisseurDAO#comFournisseur(String)
 * @see ObservableList
 * @see ComboBox
 * @see javafx.scene.control.TextArea
 * @see ResultSet
 * @author Alexandre Lourencinho
 */
public class ListeCmdController
{

    @FXML
    public ComboBox<String> listeFou;
    public TextArea zoneTexte;

    private ObservableList<String> dbTypeList = FXCollections.observableArrayList();
    private ArrayList<Fournisseur> listeFourn;


    /**
     * méthode permettant de générer et afficher dans une liste déroulante la liste des fournisseurs
     */
    public void initialize()
    {
        try {
            FournisseurDAO fournisseurDAO = new FournisseurDAO();
            listeFourn=fournisseurDAO.listeFournisseurs();
            System.out.println(listeFourn.toString());
            listeFou.setPromptText("Sélectionnez un fournisseur");
            for(Fournisseur fourni : listeFourn)
                dbTypeList.add(fourni.getNomfou());
            listeFou.setItems(dbTypeList);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Il y a eu une erreur à la récupération des fournisseurs, veuillez contacter un administrateur");
            alert.showAndWait();
        }
    }

    /**
     * méthode appelant celle récupérant les informations de commandes d'un fournisseur et l'affichant dans la zone de
     * texte prévue à cet effet
     */
    public void comFourni()
    {
        try {
            String str="";
            FournisseurDAO fournisseurDAO = new FournisseurDAO();
            ResultSet resultat = fournisseurDAO.comFournisseur(listeFou.getValue());
            while (resultat.next()) {
                str = str + resultat.getInt("numcom") +" " +resultat.getString("datcom")  +" "+resultat.getString("obscom") +"\n";
            }
            zoneTexte.setText(str);
        }catch(SQLException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Il y a eu une erreur à l'affichage des commandes, veuillez contacter un administrateur");
            alert.showAndWait();
        }

    }



}
