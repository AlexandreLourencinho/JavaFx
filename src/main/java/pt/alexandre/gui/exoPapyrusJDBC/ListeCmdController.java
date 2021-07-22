package pt.alexandre.gui.exoPapyrusJDBC;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import pt.alexandre.gui.exoPapyrusJDBC.model.RequetePrepares;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ListeCmdController
{

    @FXML
    public ComboBox<String> listeFou;
    public TextArea zoneTexte;

    private ObservableList<String> dbTypeList = FXCollections.observableArrayList();


    public void initialize()
    {
        try {
            RequetePrepares req = new RequetePrepares();
            ResultSet result = req.listeFournisseur();
            System.out.println(result);
            listeFou.setPromptText("Sélectionnez un fournisseur");
            while(result.next()){
                dbTypeList.add(result.getString("nomfou"));
            }
            listeFou.setItems(dbTypeList);
        } catch (SQLException throwables) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Il y a eu une erreur à la récupération des fournisseurs, veuillez contacter un administrateur");
            alert.showAndWait();
        }
    }

    public void comFourni()
    {
        try {
            String str="";
            RequetePrepares req = new RequetePrepares();
            ResultSet resultat = req.comFournisseur(listeFou.getValue());
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
