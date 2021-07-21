package pt.alexandre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.alexandre.gui.MenuController;

import java.io.IOException;

public class App extends Application
{

    public static Stage stage;
    static Scene scene;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        Parent root = FXMLLoader.load(MenuController.class.getResource("menu.fxml"));
        scene = new Scene(root);
        stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Menu des exercices");
        stage.setScene(scene);
        stage.show();


    }
}
