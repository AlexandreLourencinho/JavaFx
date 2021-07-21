package pt.alexandre.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController
{
    public Button boutonAdd;
    public Button boutonCaza;
    public Stage stagefen;
    public Button sliders;

    public void fenAdd(ActionEvent actionEvent) throws IOException
    {
        stagefen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("additionneur/additionneur.fxml"));
        Scene scene = new Scene(root);
        stagefen.setTitle("additionneur");
        stagefen.setScene(scene);
        stagefen.show();
    }

    public void fenCaza() throws IOException
    {
        stagefen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("lacazadacocher/lacazadacocher.fxml"));
        Scene scene = new Scene(root);
        stagefen.setTitle("la case à cocher");
        stagefen.setScene(scene);
        stagefen.show();

    }

    public void fenSliders() throws IOException
    {
        stagefen = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sliders/sliders.fxml"));
        Scene scene = new Scene(root);
        stagefen.setTitle("SLIDERS LES MONDES PARALLELES OMG");
        stagefen.setScene(scene);
        stagefen.show();
    }

}
