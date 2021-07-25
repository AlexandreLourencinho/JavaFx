package pt.alexandre.gui.gestionTableClient.model;


import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Alexandre Lourencinho
 */
public class ClientsDAO extends ConnexionBaseHotel
{

    PreparedStatement stmt;
    private Clients cli;
    ResultSet resultat;
    private ArrayList<Clients> listeDesClients;


    /**
     * @param id numéro id du client
     * @return une instance de la classe client
     */
    public Clients trouverClient(int id)
    {
        try {
            stmt = connex().prepareStatement("SELECT * FROM hotel.client WHERE cli_id=?");
            stmt.setInt(1, id);
            resultat = stmt.executeQuery();
            cli = new Clients();
            while (resultat.next()) {
                cli.setId(resultat.getInt("cli_id"));
                cli.setNom(resultat.getString("cli_nom"));
                cli.setPrenom(resultat.getString("cli_prenom"));
                cli.setVille(resultat.getString("cli_ville"));
            }
            stmt.close();
            connex().close();
            return cli;
        } catch (SQLException throwables) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("erreur DAO-FO");
            alert.setContentText("Erreur critique au moment de la récupération des informations");
            alert.show();
            return null;
        }
    }

    /**
     * @return un arraylist d'instances de la classe Clients
     */
    public ArrayList<Clients> listeClients()
    {
        try {
            listeDesClients= new ArrayList<>();
            stmt = connex().prepareStatement("SELECT cli_id,cli_nom,cli_prenom,cli_ville FROM hotel.client");
            resultat = stmt.executeQuery();
            while (resultat.next()) {
                cli = new Clients(resultat.getInt("cli_id"), resultat.getString("cli_nom"), resultat.getString("cli_prenom"), resultat.getString("cli_ville"));
                listeDesClients.add(cli);
            }
            return listeDesClients;
        } catch (SQLException throwables) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur DAO-FA");
            alert.setContentText("Erreur critique au moment de la récupération des informations");
            alert.show();
            return null;
        }
    }

    /**
     * @param cli une instance de la classe Clients
     * @return un booléen
     */
    public boolean ajouterClient(Clients cli)
    {
        try {
            stmt = connex().prepareStatement("INSERT INTO hotel.client(cli_nom,cli_prenom,cli_ville)" +
                    "VALUES (?,?,?)");
            stmt.setString(1, cli.getNom());
            stmt.setString(2, cli.getPrenom());
            stmt.setString(3, cli.getVille());
            stmt.execute();
            return true;
        } catch (SQLException throwables) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur DAO-AC");
            alert.setContentText("Erreur critique au moment de la récupération des informations");
            alert.show();
            return false;
        }
    }

    /**
     * @param cli une instance de la classe Clients
     * @return un booléen
     */
    public boolean modifierClient(Clients cli)
    {
        try {
            stmt = connex().prepareStatement("UPDATE hotel.client SET cli_nom=?,cli_prenom=?,cli_ville=?");
            stmt.setString(1, cli.getNom());
            stmt.setString(2, cli.getPrenom());
            stmt.setString(3, cli.getVille());
            stmt.execute();
            return true;
        } catch (SQLException throwables) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur DAO-UC");
            alert.setContentText("Erreur critique au moment de la récupération des informations");
            alert.show();
            return false;
        }
    }

    /**
     * @param id le numéro d'ID d'un client
     * @return un booléen
     */
    public boolean supprimerClient(int id)
    {
        try {
            stmt = connex().prepareStatement("DELETE FROM hotel.client WHERE cli_id=?");
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException throwables) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur DAO-SC");
            alert.setContentText("Erreur critique au moment de la récupération des informations");
            alert.show();
            return false;
        }
    }
}
