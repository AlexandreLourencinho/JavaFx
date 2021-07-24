package pt.alexandre.gui.gestionTableClient.model;

/**
 * @author Alexandre Lourencinho
 */
public class Clients {

    private int id;
    private String nom;
    private String prenom;
    private String ville;

    public Clients()
    {

    }

    public Clients(int id,String nom,String prenom, String ville)
    {
        this.id=id;
        this.nom=nom;
        this.prenom= prenom;
        this.ville = ville;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
