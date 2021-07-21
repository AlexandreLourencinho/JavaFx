package pt.alexandre.gui.tableauClient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pt.alexandre.gui.tableauClient.model.Client;

public class TableauClientController
{

    @FXML
    private TableView<Client> tableauCli;
    @FXML
    private TableColumn<Client,String> ColonnePrenom;
    @FXML
    private TableColumn<Client,String> colonneNom;
    @FXML
    private TableColumn<Client, String> colonneVille;
    public TextField textPrenom;
    public TextField textNom;
    public TextField textVille;
    ObservableList<Client> model = FXCollections.observableArrayList();
}
