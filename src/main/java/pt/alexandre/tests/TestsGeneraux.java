package pt.alexandre.tests;

import org.junit.Assert;
import org.junit.Test;
import pt.alexandre.gui.exoPapyrusJDBC.model.ConnexionBdd;
import pt.alexandre.gui.exoPapyrusJDBC.model.Fournisseur;
import pt.alexandre.gui.exoPapyrusJDBC.model.FournisseurDAO;
import pt.alexandre.gui.gestionTableClient.model.ConnexionBaseHotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TestsGeneraux
{

    @Test
    public void testCoBddHotel()
    {
        ConnexionBaseHotel con = new ConnexionBaseHotel();
        Connection conn = con.connex();
        Assert.assertNotNull(conn);
    }

    @Test
    public void testCoBddPapyrus()
    {
        ConnexionBdd con = new ConnexionBdd();
        Connection conn = con.connec();
        Assert.assertNotNull(conn);
    }

    @Test
    public void testTrouverFournisseur()
    {
        FournisseurDAO founi = new FournisseurDAO();
        Fournisseur fournisseur = new Fournisseur();

        fournisseur = founi.trouverFournisseur(120);
        Assert.assertNotNull(fournisseur.getConfou());
        Assert.assertNotNull(fournisseur.getNomfou());
        Assert.assertNotNull(fournisseur.getNumfou());
        Assert.assertNotNull(fournisseur.getVilfou());
        Assert.assertNotNull(fournisseur.getRuefou());
    }

    @Test
    public void testListeFournisseur()
    {

        FournisseurDAO reqFourni = new FournisseurDAO();
        ArrayList<Fournisseur> listeFournis = reqFourni.listeFournisseurs();

        for(Fournisseur fourni : listeFournis){
            Assert.assertNotNull(fourni.getNomfou());
            System.out.println(fourni.getNomfou());
        }
    }

    @Test
    public void testDernierNumfou()
    {
        FournisseurDAO reqFou = new FournisseurDAO();
        int dernierId = reqFou.dernierNumfou();
        Assert.assertNotEquals(0,dernierId);
    }

    @Test
    public void testTrouverComFou()
    {
        FournisseurDAO reqFou = new FournisseurDAO();
        Fournisseur fournisseur = reqFou.trouverFournisseur(120);
        ResultSet resultat = reqFou.comFournisseur(fournisseur.getNomfou());
        Assert.assertNotNull(resultat);
        try{
            while(resultat.next()){
                System.out.println(resultat.getInt("numcom") +" " +resultat.getString("datcom")  +" "+resultat.getString("obscom") +"\n");
            }
        }catch(Exception e){
            System.out.println("erreur d'execution");
        }
    }

    @Test
    public void testFournisseurValide()
    {
        FournisseurDAO reqFou = new FournisseurDAO();
        Fournisseur fournisseur = reqFou.trouverFournisseur(120);
        Assert.assertTrue(reqFou.fournisseurValide(fournisseur));
    }

    @Test
    public void testAjoutFournisseur()
    {
        FournisseurDAO reqFou = new FournisseurDAO();
        Fournisseur fournisseur = new Fournisseur(24, "fournitestnom", "fournitestrue", "test1", "fournitestville",
                "testcontact");
        Assert.assertTrue(reqFou.ajouterFournisseur(fournisseur));
        Assert.assertTrue(reqFou.supprimerFournisseur(24));
    }





}
