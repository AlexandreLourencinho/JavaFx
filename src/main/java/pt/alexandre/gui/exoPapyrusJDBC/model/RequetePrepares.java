package pt.alexandre.gui.exoPapyrusJDBC.model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequetePrepares extends ConnexionBdd
{
    private static ResultSet resultat;
    private static PreparedStatement stmt;

    public ResultSet selectUn(int numfou)
    {
        try
        {
            stmt = connec().prepareStatement("SELECT * FROM papyrus.fournis WHERE numfou=?");
            stmt.setInt(1, numfou);
            resultat = stmt.executeQuery();
        }
        catch (SQLException throwables)
        {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("Il y a eu une erreur de connexion !");
            alert.showAndWait();
        }
        return resultat;
    }

    public void detruitTout()
    {
        try
        {
            stmt.close();
            resultat.close();
            con.close();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }

    public ResultSet listeFournis(int numfou)
    {
        try
        {
            stmt = connec().prepareStatement("SELECT * FROM papyrus.fournis, papyrus.entcom WHERE numfou=?");
            stmt.setInt(1, numfou);
            return stmt.executeQuery();
        }
        catch (SQLException throwables)
        {
            Alert alert = new Alert(AlertType.WARNING);
            alert.showAndWait();
        }
        return null;
    }


    public ResultSet listeFournisseur()
    {
        try
        {
            stmt = connec().prepareStatement("SELECT fournis.nomfou FROM papyrus.fournis");
            return stmt.executeQuery();
        }
        catch (SQLException throwables)
        {
            Alert alert = new Alert(AlertType.WARNING);
            alert.showAndWait();
        }
        return null;
    }


    public ResultSet comFournisseur(String nomfou)
    {
        try
        {
            stmt = connec().prepareStatement(
                    "SELECT * FROM papyrus.entcom INNER JOIN papyrus.fournis ON entcom.numfou = fournis.numfou WHERE nomfou=?");
            stmt.setString(1, nomfou);
            return stmt.executeQuery();
        }
        catch (SQLException exception)
        {
            Alert alert = new Alert(AlertType.WARNING);
            alert.showAndWait();
        }
        return null;
    }

    public boolean ajoutFournis(int numfou, String nomfou, String ruefou, String posfou, String vilfou, String confou)
    {
        try
        {
            stmt = connec().prepareStatement("INSERT INTO papyrus.fournis(numfou, nomfou, ruefou, posfou, vilfou, " +
                    "confou) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, numfou);
            stmt.setString(2, nomfou);
            stmt.setString(3, ruefou);
            stmt.setString(4, posfou);
            stmt.setString(5, vilfou);
            stmt.setString(6, confou);
            stmt.execute();
            return true;
        }
        catch (SQLException e)
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setContentText("erreur d'insertion");
            alert.showAndWait();
            return false;
        }

    }

    public int grosNumfou()
    {
        int num=0;
        ResultSet result;
        try
        {
            stmt = connec().prepareStatement("SELECT MAX(fournis.numfou) as numfou FROM papyrus.fournis");
            result = stmt.executeQuery();
            while (result.next())
            {
                num = result.getInt("numfou");

            }
            return num;
        }
        catch (SQLException e)
        {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("problème de récupération de numéro fournisseur");
            alert.showAndWait();
            return 0;
        }
    }

    public void terminer()
    {
        try
        {
            connec().close();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
