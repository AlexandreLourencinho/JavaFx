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
            Alert alert =  new Alert(AlertType.WARNING);
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
        try{
            stmt = connec().prepareStatement("SELECT * FROM papyrus.fournis, papyrus.entcom WHERE numfou=?");
            stmt.setInt(1,numfou);
            return stmt.executeQuery();
        }catch(SQLException throwables){
            Alert alert = new Alert(AlertType.WARNING);
            alert.showAndWait();
        }
        return null;
    }


    public ResultSet listeFournisseur()
    {
        try{
            stmt = connec().prepareStatement("SELECT fournis.nomfou FROM papyrus.fournis");
            return stmt.executeQuery();
        }catch(SQLException throwables){
            Alert alert = new Alert(AlertType.WARNING);
            alert.showAndWait();
        }
        return null;
    }


    public ResultSet comFournisseur(String nomfou)
    {

        try{
            stmt = connec().prepareStatement("SELECT * FROM papyrus.entcom INNER JOIN papyrus.fournis ON entcom.numfou = fournis.numfou WHERE nomfou=?");
            stmt.setString(1,nomfou);
            return stmt.executeQuery();
        }catch(SQLException exception){
            Alert alert = new Alert(AlertType.WARNING);
            alert.showAndWait();
        }


        return null;
    }
}
