package pt.alexandre.gui.gestionTableClient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.alexandre.gui.gestionTableClient.model.Clients;

public class GestionTableClientController {

    @FXML
    public TextField txtNom;
    @FXML
    public TextField txtPrenom;
    @FXML
    public TextField txtVille;
    @FXML
    public TableView tableauClient;
    @FXML
    public TableColumn colonneNom;
    @FXML
    public TableColumn colonnePrenom;


    ObservableList<Clients> model = FXCollections.observableArrayList();


    public void initialize()
    {
        tableauClient.setEditable(false);
        colonneNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonnePrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    }

}
