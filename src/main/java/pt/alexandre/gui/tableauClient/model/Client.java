package pt.alexandre.gui.tableauClient.model;

/**
 * Classe permettant la construction et l'instanciation d'objets "clients"
 * @see pt.alexandre.gui.tableauClient.TableauClientController
 * @author Alexandre Lourencinho
 */
public class Client
{
    private String nom,prenom,ville;

    public Client(){}

    /**
     * Constructeur avec paramètres
     * @param nom chaîne de caractère :  nom du client
     * @param prenom chaîne de caractère : prénom du client
     * @param ville chaîne de caractère : ville du client
     */
    public Client(String nom, String prenom, String ville) {
        this.prenom = prenom;
        this.nom = nom;
        this.ville = ville;
    }


    public String getNom()
    {
        return nom;
    }


    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public String getVille()
    {
        return ville;
    }

    public void setVille(String ville)
    {
        this.ville = ville;
    }
}
