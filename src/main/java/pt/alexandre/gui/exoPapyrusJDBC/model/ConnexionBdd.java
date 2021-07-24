package pt.alexandre.gui.exoPapyrusJDBC.model;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * classe de connexion a la base de donnée papyrus, utilisée pour les exercices JDBC
 * @see DriverManager
 * @see Alert
 * @see Connection
 * @author Alexandre Lourencinho
 */
public class ConnexionBdd
{
    private String url = "jdbc:mysql://localhost:3306/papyrus";
    Connection con = null;

    public Connection connec()
    {
        try
        {
            con = DriverManager.getConnection(url, "root","1234" );
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
            System.out.println(throwables.getErrorCode());
            System.out.println(throwables.getSQLState());
            Alert alert =  new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Il y a eu une erreur de connexion !" + throwables.getMessage());
            alert.showAndWait();
        }
        return con;
    }




}
