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

/**
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

    public void listeDesClients()
    {
        ClientsDAO reqCli = new ClientsDAO();
        ArrayList<Clients> tousClients = new ArrayList<>(reqCli.liste());
        model.clear();
        model.addAll(tousClients);
        tableauClient.setItems(model);
    }

    public void modifierClient()
    {
        afficherPaneDetails();
        tempCli = tableauClient.getSelectionModel().getSelectedItem();
        txtNom.setText(tempCli.getNom());
        txtPrenom.setText(tempCli.getPrenom());
        txtVille.setText(tempCli.getVille());
    }

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

    public void annulerTout()
    {
        tableauClient.getSelectionModel().clearSelection();
        tempCli = null;
        txtNom.clear();
        txtPrenom.clear();
        txtVille.clear();
        masquerPaneDetails();
    }

    public void verif()
    {
        if(check.checkFormClients(txtNom.getText(),txtPrenom.getText(),txtVille.getText())){
            miseAJourClient();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur dans le formulaire");
            alert.setContentText("Ne rentrez que des caractères alphanumériques, commencez par une majuscule (les - " +
                    "sont autorisés pour la ville )");
            alert.showAndWait();
        }
    }

}
