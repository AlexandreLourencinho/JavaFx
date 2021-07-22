package pt.alexandre.gui.tableauClient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.alexandre.gui.tableauClient.model.Client;

import java.net.URL;
import java.util.ResourceBundle;

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

    public void ajouter()
    {
        model.add(new Client(textNom.getText(),textPrenom.getText(),textVille.getText()));
        tableauCli.setItems(model);
        tableauCli.setItems(model);
        textNom.clear();
        textPrenom.clear();
        textVille.clear();
    }

    public void annuler()
    {
        textNom.clear();
        textPrenom.clear();
        textVille.clear();
    }

    public void supprimer()
    {
        model.remove(tableauCli.getSelectionModel().getSelectedIndex());
    }

}
