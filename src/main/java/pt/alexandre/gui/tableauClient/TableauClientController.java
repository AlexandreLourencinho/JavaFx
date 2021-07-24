package pt.alexandre.gui.tableauClient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.alexandre.gui.tableauClient.model.Client;


/**
 * Classe permettant la gestion d'un tableau de client (ici générique, sans connexion à la base de donnée) pour la découverte
 * et l'utilisation des tableview et leurs contenus (tablecolumn notamment)
 * Exercice permettant un début de gestion de formulaire
 * @see Client
 * @see FXML
 * @see TableView
 * @see ObservableList
 * @see FXCollections
 * @see TextField
 * @see TableColumn
 * @author Alexandre Lourencinho
 */
public class TableauClientController
{

    @FXML
    private TableView<Client> tableauCli;
    @FXML
    private TableColumn<Client,String> colonnePrenom;
    @FXML
    private TableColumn<Client,String> colonneNom;
    @FXML
    private TableColumn<Client, String> colonneVille;
    @FXML
    private TextField textPrenom;
    @FXML
    private TextField textNom;
    @FXML
    private TextField textVille;


    ObservableList<Client> model = FXCollections.observableArrayList();

    /**
     * initialisation du tableau avec des données de remplissage
     */
    @FXML
    public void initialize()
    {
        model.add(new Client("Josh", "Homme", "Joshua Tree"));
        model.add(new Client("Dave", "Grohl", "Warren"));
        model.add(new Client("Krist", "Novoselic", "Compton"));
        model.add(new Client("Robert", "Trujillo", "Santa Monica"));
        tableauCli.setEditable(false);
        colonneNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonnePrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colonneVille.setCellValueFactory(new PropertyValueFactory<>("ville"));
        tableauCli.setItems(model);

    }

    /**
     * Méthode permettant d'ajouter un client au tableau
     */
    public void ajouter()
    {
        model.add(new Client(textNom.getText(),textPrenom.getText(),textVille.getText()));
        tableauCli.setItems(model);
//        tableauCli.setItems(model);
        textNom.clear();
        textPrenom.clear();
        textVille.clear();
    }

    /**
     * méthode permettant simplement de vider les champs
     */
    public void annuler()
    {
        textNom.clear();
        textPrenom.clear();
        textVille.clear();
    }

    /**
     * méthode permettant de supprimer le client séléctionné
     */
    public void supprimer()
    {
        model.remove(tableauCli.getSelectionModel().getSelectedIndex());
    }

}
