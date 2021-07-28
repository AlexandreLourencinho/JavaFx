package pt.alexandre.gui.exoPapyrusJDBC.model;

import javafx.scene.control.Alert;
import pt.alexandre.gui.gestionTableClient.model.DaoInterface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommandesDAO extends ConnexionBdd implements DaoInterface<Commandes>
{
    private PreparedStatement stmt;
    private ArrayList<Commandes> listeCom = new ArrayList<>();

    @Override
    public boolean ajouter(Commandes o)
    {
        return false;
    }

    @Override
    public boolean modifier(Commandes o)
    {
        return false;
    }

    @Override
    public boolean supprimer(int id)
    {
        return false;
    }

    @Override
    public Commandes trouverUn(int id)
    {
        return null;
    }

    @Override
    public ArrayList<Commandes> liste()
    {

        try
        {
            stmt = connec().prepareStatement("SELECT * FROM papyrus.entcom");
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                Commandes com = new Commandes(result.getInt("numcom"),result.getString("obscom"), result.getString(
                        "datcom"));
                listeCom.add(com);
            }
            return listeCom;
        }
        catch (SQLException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR DAO- LC");
            alert.setContentText("Impossible de retrouver les commandes");
            alert.showAndWait();
            return null;
        }
    }
}
