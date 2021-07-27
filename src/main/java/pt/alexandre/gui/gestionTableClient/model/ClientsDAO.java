package pt.alexandre.gui.gestionTableClient.model;


import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *  Classe DAO rassemblant les méthodes agissant sur la base hotel
 * @see Clients
 * @see pt.alexandre.gui.gestionTableClient.GestionTableClientController
 * @see DaoInterface
 * @author Alexandre Lourencinho
 */
public class ClientsDAO extends ConnexionBaseHotel implements DaoInterface<Clients>
{

    PreparedStatement stmt;
    private Clients cli;
    ResultSet resultat;
    private ArrayList<Clients> listeDesClients;


    /**
     * méthode permettant de trouver un client de la base hotel
     * @param id numéro id du client
     * @return une instance de la classe client
     */
    @Override
    public Clients trouverUn(int id)
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
     * méthode permettant de lister tous les clients de la base hotel
     * @return un arraylist d'instances de la classe Clients
     */
    @Override
    public ArrayList<Clients> liste()
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
     * méthode permettant d'ajouter un client dans la base hotel
     * @param cli une instance de la classe Clients
     * @return un booléen
     */
    @Override
    public boolean ajouter(Clients cli)
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
     * méthode permettant de modifier un client de la base hotel
     * @param cli une instance de la classe Clients
     * @return un booléen
     */
    @Override
    public boolean modifier(Clients cli)
    {
        try {
            stmt = connex().prepareStatement("UPDATE hotel.client SET cli_nom=?,cli_prenom=?,cli_ville=? WHERE " +
                    "cli_id=?");
            stmt.setString(1, cli.getNom());
            stmt.setString(2, cli.getPrenom());
            stmt.setString(3, cli.getVille());
            stmt.setInt(4,cli.getId());
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
     * méthode permettant de supprimer un client de la base hotel (nécessite de supprimer aussi ses réservations)
     * @param id le numéro d'ID d'un client
     * @return un booléen
     */
    @Override
    public boolean supprimer(int id)
    {
        try {
            System.out.println(id);
            stmt = connex().prepareStatement("DELETE FROM hotel.reservation WHERE res_cli_id=?;");
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            stmt = connex().prepareStatement("DELETE FROM hotel.client WHERE cli_id=?");
            stmt.setInt(1,id);
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
