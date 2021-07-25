package pt.alexandre.gui.gestionTableClient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import pt.alexandre.gui.gestionTableClient.model.Clients;
import pt.alexandre.gui.gestionTableClient.model.ClientsDAO;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Alexandre Lourencinho
 */
public class GestionTableClientController {

    @FXML
    public TextField txtNom;
    @FXML
    public TextField txtPrenom;
    @FXML
    public TextField txtVille;
    @FXML
    public TableView<Clients> tableauClient;
    @FXML
    public TableColumn<Clients,String> colonneNom;
    @FXML
    public TableColumn<Clients,String> colonnePrenom;
    public Pane paneDetails;


    ObservableList<Clients> model = FXCollections.observableArrayList();


    public void initialize()
    {
        colonneNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonnePrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        masquerPaneDetails();
        listeDesClients();

    }

    public void afficherPaneDetails()
    {
        paneDetails.setVisible(true);
    }

    public void masquerPaneDetails()
    {
        paneDetails.setVisible(false);
    }

    public void listeDesClients()
    {
        ClientsDAO reqCli = new ClientsDAO();
        ArrayList<Clients> tousClients = new ArrayList<>(reqCli.listeClients());
        model.addAll(tousClients);
        tableauClient.setItems(model);
    }

    public void modifierClient()
    {
        afficherPaneDetails();
        txtNom.setText(tableauClient.getSelectionModel().getSelectedItem().getNom());
        txtPrenom.setText(tableauClient.getSelectionModel().getSelectedItem().getPrenom());
        txtVille.setText(tableauClient.getSelectionModel().getSelectedItem().getVille());
    }

    public void supprimerUnClient()
    {
        ClientsDAO reqCli = new ClientsDAO();
        System.out.println(tableauClient.getSelectionModel().getSelectedIndex());
        int id = tableauClient.getSelectionModel().getSelectedItem().getId()+1;
        if(reqCli.supprimerClient(id)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Client supprimé");
            alert.setContentText("Vous avez bien supprimé le client de la base de données");
            alert.showAndWait();
        }
    }


}
