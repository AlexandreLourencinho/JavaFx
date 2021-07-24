package pt.alexandre.gui.exoPapyrusJDBC.model;

import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Cette classe fournit les différentes fonctions
 * JDBC nécessaires a la gestion de la  table fournisseur
 * crud sur la  table fournisseur
 * @see Fournisseur
 * @see ResultSet
 * @see PreparedStatement
 * @author Alexandre
 */
public class FournisseurDAO extends ConnexionBdd
{
    private PreparedStatement stmt;
    private ResultSet res;
    private ArrayList<Fournisseur> listeFourni = new ArrayList<>();

    /**
     * @param fourni une instance de la classe {@link Fournisseur}
     * @return un booléen indiquant si l'insertion s'est correctement déroulée ou non
     */
    public boolean ajouterFournisseur(Fournisseur fourni)
    {
        try {
            stmt = connec().prepareStatement("INSERT INTO papyrus.fournis(numfou, nomfou, ruefou, posfou, vilfou, confou" +
                    ") VALUES (?,?,?,?,?,?)");
            stmt.setInt(1,fourni.getNumfou());
            stmt.setString(2,fourni.getNomfou());
            stmt.setString(3, fourni.getRuefou());
            stmt.setString(4, fourni.getPosfou());
            stmt.setString(5, fourni.getVilfou());
            stmt.setString(6, fourni.getConfou());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("erreur DAO-A");
            alert.setContentText("Erreur à l'insertion");
            return false;
        }
    }

    public boolean modifierFournisseur()
    {

        return false;
    }

    public Fournisseur trouverFournisseur(int numfou)
    {
        try
        {
            Fournisseur fourni = new Fournisseur();
            stmt = connec().prepareStatement("SELECT * FROM papyrus.fournis WHERE numfou=?");
            stmt.setInt(1, numfou);
            res = stmt.executeQuery();
            while (res.next()){
                fourni.setNumfou(res.getInt("numfou"));
                fourni.setNomfou(res.getString("nomfou"));
                fourni.setVilfou(res.getString("vilfou"));
                fourni.setRuefou(res.getString("ruefou"));
                fourni.setPosfou(res.getString("posfou"));
                fourni.setConfou(res.getString("confou"));
            }
            System.out.println(fourni.getNomfou());
            connec().close();
            stmt.close();
            res.close();
            return fourni;
        }
        catch (SQLException throwables)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Il y a eu une erreur lors de la recherche ou de la récupération du fournisseur.");
            alert.setTitle("erreur de DAO-F");
            alert.showAndWait();
            return null;
        }
    }

    public ArrayList<Fournisseur> listeFournisseurs()
    {

        try {
            stmt = connec().prepareStatement("SELECT nomfou FROM papyrus.fournis");
            res = stmt.executeQuery();
            while(res.next()){
                Fournisseur fourni = new Fournisseur();
                fourni.setNomfou(res.getString("nomfou"));
                listeFourni.add(fourni);
            }
            return listeFourni;
        } catch (SQLException throwables) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Il y a eu une erreur lors de la recherche ou de la récupération du fournisseur.");
            alert.setTitle("erreur de DAO-L");
            alert.showAndWait();
            return null;
        }

    }

    public int dernierNumfou()
    {
        int num=0;
        try
        {
            stmt = connec().prepareStatement("SELECT MAX(fournis.numfou) as numfou FROM papyrus.fournis");
            res = stmt.executeQuery();
            while (res.next())
            {
                num = res.getInt("numfou");
            }
            return num+1;
        }
        catch (SQLException e)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("problème de récupération de numéro fournisseur");
            alert.showAndWait();
            return 0;
        }
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
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.showAndWait();
        }
        return null;
    }


    public boolean fournisseurValide(Fournisseur founis)
    {
        return founis.getNomfou() != null || founis.getRuefou() != null || founis.getConfou() != null || founis.getVilfou() != null;
    }

}
