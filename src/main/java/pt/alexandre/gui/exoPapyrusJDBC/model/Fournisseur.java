package pt.alexandre.gui.exoPapyrusJDBC.model;

/**
 * Classe fournisseur permettant d'instancier des objets fournisseurs et de les manipuler.
 * @author Lourencinho Alexandre
 */
public class Fournisseur {

    private int numfou;

    private String nomfou ;
    private String ruefou ;
    private String posfou;
    private String vilfou;
    private String confou;

    public Fournisseur(){

    }

    /**
     * constructeur de la classe fournisseur
     * @param nom le nom du fournisseur
     * @param rue l'adresse du fournisseur
     * @param pos le code postal du fournisseur
     * @param ville la ville du fournisseur
     * @param contact ...bonne question, dans la base, on dirait des pseudos...
     */
    public Fournisseur(String nom, String rue, String pos, String ville, String contact)
    {
        this.nomfou = nom;
        this.ruefou = rue;
        this.posfou = pos;
        this.vilfou = ville;
        this.confou = contact;
    }

    public void setNumfou(int numfou) {
        this.numfou = numfou;
    }

    public void setNomfou(String nomfou) {
        this.nomfou = nomfou;
    }

    public int getNumfou() {
        return numfou;
    }

    public String getNomfou() {
        return nomfou;
    }

    public String getRuefou() {
        return ruefou;
    }

    public String getPosfou() {
        return posfou;
    }

    public String getVilfou() {
        return vilfou;
    }

    public String getConfou() {
        return confou;
    }

    public void setRuefou(String ruefou) {
        this.ruefou = ruefou;
    }

    public void setPosfou(String posfou) {
        this.posfou = posfou;
    }

    public void setVilfou(String vilfou) {
        this.vilfou = vilfou;
    }


    public void setConfou(String confou) {
        this.confou = confou;
    }
}
