package pt.alexandre.gui.gestionTableClient.tools;

import javafx.scene.control.TextField;

import java.util.HashMap;

/**
 * Classe permettant de vérifier les champs de formulaire d'ajout et de modification
 * @see pt.alexandre.gui.gestionTableClient.model.Clients
 * @see pt.alexandre.gui.gestionTableClient.model.ClientsDAO
 * @author Alexandre Lourencinho
 */
public class CheckForm
{
    /**
     * méthode vérifiant les champs d'ajout ou de modification d'un client
     * @param nom une chaîne de caractère contenant le nom du client
     * @param prenom une chaîne de caractère contenant le prénom du client
     * @param ville une chaîne de caractère contenant la ville de résidence du client
     * @param txtnom le champ textfield du nom pour formattage
     * @param txtprenom le champ textfield du prénom pour formattage
     * @param txtville le champ textfield de la ville pour formattage
     * @return un hashmap contenant un boolean indiquant si le formulaire est valide ou non, et le message d'erreur
     * en chaine de caractère le cas échéant
     */
    public HashMap<String, Boolean> checkFormClients(String nom, String prenom, String ville, TextField txtnom,
                                                     TextField txtprenom, TextField txtville)
    {
        String str="";
        HashMap<String, Boolean> resultat = new HashMap<>();
        boolean res=true;

        if(!nom.matches("^[\\p{Upper}][\\p{Lower}]+$")){
            str = str + "Le nom est incorrect. Il doit commencer par une majuscule et ne pas contenir de chiffres.\n";
            txtnom.setStyle("-fx-border-color: red");
        }
        if(!prenom.matches("^[\\p{Upper}][\\p{Lower}]+$")){
            str = str + " Le prénom est incorrect. Il doit commencer par une majuscule et ne pas contenir de chiffres" +
                    ".\n";
            txtprenom.setStyle("-fx-border-color: red");
        }
        if(ville.matches("[\\p{Digit}]") || ville.length()<2){
            str = str + " La ville est incorrecte. Elle ne doit pas comporter de numéro.\n";
            txtville.setStyle("-fx-border-color: red");
        }
        if(str!=""){
            res =false;
        }
        resultat.put(str,res);
        return  resultat;
    }
}
