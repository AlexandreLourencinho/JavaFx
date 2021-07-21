package pt.alexandre.gui.lacazadacocher;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class LacazadacocherController
{
    public TextField zonetxt;
    public Label labelAff;
    public TitledPane choix;
    public TitledPane casse;
    public TitledPane texte;
    public TitledPane fond;
    public RadioButton radioMinuscule;
    public RadioButton radioMajuscule;
    public RadioButton radioCyan;
    public RadioButton radioRose;
    public RadioButton radioRouge;
    public RadioButton radioFondVert;
    public RadioButton radioFondBleu;
    public RadioButton radioFondrouge;
    public RadioButton[] arAdio;
    public CheckBox checkFond;
    public CheckBox checkTxt;
    public CheckBox checkCasse;

    @FXML
    ToggleGroup radioCasse, radioTexte, radioFond;

    @FXML
    public void initialize()
    {

    }

    public void auRelachement()
    {
        if (zonetxt.getText().equals(""))
        {
            arAdio = new RadioButton[]{radioMinuscule,radioRose,radioCyan,radioFondBleu,radioMajuscule,radioFondrouge
                    ,radioFondVert,radioRouge};
            for(RadioButton r : arAdio){
                r.setSelected(false);
            }
            choix.setDisable(true);
            checkTxt.setSelected(false);
            checkFond.setSelected(false);
            checkCasse.setSelected(false);
            labelAff.setStyle("");
            labelAff.setText("");
            casse.setDisable(true);
            texte.setDisable(true);
            fond.setDisable(true);
        } else
        {
            choix.setDisable(false);
            labelAff.setText(zonetxt.getText());
        }
    }

    public void testCasse()
    {
        String style="";
        if(checkCasse.isSelected()){
            casse.setDisable(false);
        }else{
            casse.setDisable(true);
        }
        if(checkFond.isSelected()){
            fond.setDisable(false);
        }else{
            fond.setDisable(true);
        }
        if(checkTxt.isSelected()){
            texte.setDisable(false);
        }else{
            texte.setDisable(true);
        }
        if (radioCasse.getSelectedToggle() != null)
        {
            RadioButton boutonRadioSelectionCasse = (RadioButton) radioCasse.getSelectedToggle();
            String cassee = boutonRadioSelectionCasse.getText();
            switch (cassee)
            {
                case "Minuscule" -> labelAff.setText(zonetxt.getText().toLowerCase());
                case "Majuscule" -> labelAff.setText(zonetxt.getText().toUpperCase());
                default -> labelAff.setText(zonetxt.getText());
            }
        }
        if (radioTexte.getSelectedToggle() != null)
        {
            RadioButton boutonRadioSelectionCouleur = (RadioButton) radioTexte.getSelectedToggle();
            String couleurTexte = boutonRadioSelectionCouleur.getText();
            System.out.println(couleurTexte);
            switch (couleurTexte)
            {
                case "Marron" -> style = style + "-fx-text-fill: brown;";
                case "Rose" -> style = style + "-fx-text-fill: pink;";
                case "Cyan" -> style = style + "-fx-text-fill: cyan;";
                default -> style = style + "-fx-text-fill: black;";
            }
        }
        if(radioFond.getSelectedToggle() != null){
            RadioButton boutonRadioSelectionFond = (RadioButton) radioFond.getSelectedToggle();
            String couleurFond = boutonRadioSelectionFond.getText();
            System.out.println(couleurFond);
            switch (couleurFond)
            {
                case "Rouge" -> style = style + "-fx-background-color: red;";
                case "Vert" -> style = style + "-fx-background-color: green;";
                case "Bleu" -> style = style + "-fx-background-color: blue;";
                default -> style = style + "-fx-background-color: white;";
            }
        }
        labelAff.setStyle(style);
    }
}