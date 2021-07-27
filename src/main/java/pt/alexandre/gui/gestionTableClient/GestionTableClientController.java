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
import pt.alexandre.gui.gestionTableClient.model.Clients;
import pt.alexandre.gui.gestionTableClient.model.ClientsDAO;
import pt.alexandre.gui.gestionTableClient.tools.CheckForm;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * classe permettant la gestion de la page gestion des clients de la base hotel
 * @see Clients
 * @see ClientsDAO
 * @see CheckForm
 * @see pt.alexandre.gui.gestionTableClient.model.ConnexionBaseHotel
 * @author Alexandre Lourencinho
 */
public class GestionTableClientController
{

    @FXML
    public TextField txtNom;
    @FXML
    public TextField txtPrenom;
    @FXML
    public TextField txtVille;
    @FXML
    public TableView<Clients> tableauClient;
    @FXML
    public TableColumn<Clients, String> colonneNom;
    @FXML
    public TableColumn<Clients, String> colonnePrenom;
    public Pane paneDetails;

    CheckForm check = new CheckForm();

    private Clients tempCli;


    ObservableList<Clients> model = FXCollections.observableArrayList();


    public void initialize()
    {
        colonneNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonnePrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
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

    /**
     * méthode mettant à jour la liste des clients dans le tableview
     */
    public void listeDesClients()
    {
        ClientsDAO reqCli = new ClientsDAO();
        ArrayList<Clients> tousClients = new ArrayList<>(reqCli.liste());
        model.clear();
        model.addAll(tousClients);
        tableauClient.setItems(model);
    }

    /**
     * méthode permettant simplement d'afficher les détails (éditables) d'un client
     */
    public void modifierClient()
    {
        afficherPaneDetails();
        tempCli = tableauClient.getSelectionModel().getSelectedItem();
        txtNom.setText(tempCli.getNom());
        txtPrenom.setText(tempCli.getPrenom());
        txtVille.setText(tempCli.getVille());
    }

    /**
     * méthode appelant la suppression de client si celui ci existe
     */
    public void supprimerUnClient()
    {
        ClientsDAO reqCli = new ClientsDAO();
        System.out.println(tableauClient.getSelectionModel().getSelectedItem().getId());
        int id = tableauClient.getSelectionModel().getSelectedItem().getId();
        if (reqCli.supprimer(id))
        {
            listeDesClients();
            annulerTout();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Client supprimé");
            alert.setContentText("Vous avez bien supprimé le client de la base de données");
            alert.showAndWait();

        }
    }

    /**
     * méthode permettant d'appeler les méthodes de modification ou d'ajout selon si le client existe déjà ou non
     */
    public void miseAJourClient()
    {
        ClientsDAO reqCli = new ClientsDAO();
        if (tempCli != null)
        {
            tempCli.setNom(txtNom.getText());
            tempCli.setPrenom(txtPrenom.getText());
            tempCli.setVille(txtVille.getText());

            if (reqCli.modifier(tempCli))
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Client modifié");
                alert.setContentText("Vous avez bien modifié les informations du client " + tempCli.getNom());
                annulerTout();
                listeDesClients();
                alert.showAndWait();
            }
        } else
        {
            Clients cli = new Clients();
            cli.setNom(txtNom.getText());
            cli.setPrenom(txtPrenom.getText());
            cli.setVille(txtVille.getText());
            if (reqCli.ajouter(cli))
            {
                annulerTout();
                listeDesClients();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ajout réussi");
                alert.setContentText("Vous avez bien ajouté le client " + cli.getNom() + " " + cli.getPrenom() + ".");
                alert.showAndWait();
            } else
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Ajout échoué !!!");
                alert.setContentText(
                        "Quelque chose s'est mal passé lors de l'ajout du client " + cli.getNom() + " " + cli.getPrenom() + " !");
                alert.showAndWait();
            }
        }
    }

    /**
     * méthode gérant l'affichage du pane
     */
    public void ajouterClient()
    {
        tableauClient.getSelectionModel().clearSelection();
        txtNom.clear();
        txtPrenom.clear();
        txtVille.clear();
        tempCli = null;
        listeDesClients();
        afficherPaneDetails();
    }

    /**
     * méthode permettant simplement de purger l'objet client temporaire, de vider les champs et de fermer le pane
     * détails
     */
    public void annulerTout()
    {
        tableauClient.getSelectionModel().clearSelection();
        tempCli = null;
        txtNom.clear();
        txtPrenom.clear();
        txtVille.clear();
        masquerPaneDetails();
    }

    /**
     * méthode appelant la vérification de formulaire, et renvoi vers la gestion d'ajout / de modification si le
     * formulaire est correctement rempli
     */
    public void verif()
    {
        HashMap<String, Boolean> result = check.checkFormClients(txtNom.getText(), txtPrenom.getText(),
                txtVille.getText(),txtNom,txtPrenom,txtVille);
        for(String i : result.keySet()){
            System.out.println( i + " - " +  result.get(i));
            if(!result.get(i)){

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erreur dans le formulaire");
                alert.setContentText(i);
                alert.showAndWait();
            }else{
                miseAJourClient();
            }
        }


    }
}


