package pt.alexandre.gui.additionneur;

import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


/**
 * Controlleur de l'additionneur réalisé lors des débuts des exercices sur le JavaFx
 * projet : améliorer pour en faire une vrai calculatrice
 * @author Alexandre Lourencinho
 */
public class AdditionneurController
{


    public Button boutonresult;
    public Button boutonVider;

    public TextArea zonecalc;

    private int result = 0;


    /**
     * Fonction d'initialisation qui ne sert qu'a mettre la zone de texte en non éditable.
     * Utilisée ici simplement pour se familiariser avec la fonction initialize()
     */
    public void initialize()
    {
        zonecalc.setEditable(false);
    }

    /**
     *
     * @param event réagit ici a l'évenement clic sur les chiffres de l'additionneur
     * @see Event
     */
    public void affich(Event event)
    {
        String value = ((Button) event.getSource()).getText();
        switch (value)
        {
            case "0":
                settest(0);
                result+=0;
                break;
            case "1":
                settest(1);
                result+=1;
                break;
            case "2":
                settest(2);
                result+=2;
                break;
            case "3":
                settest(3);
                result+=3;
                break;
            case "4":
                settest(4);
                result+=4;
                break;
            case "5":
                settest(5);
                result+=5;
                break;
            case "6":
                settest(6);
                result+=6;
                break;
            case "7":
                settest(7);
                result+=7;
                break;
            case "8":
                settest(8);
                result+=8;
                break;
            case "9":
                settest(9);
                result+=9;
                break;
        }
    }

    /**
     * Cette méthode sert uniquement à afficher le calcul dans l'additionneur
     * @param nb Le nombre a afficher
     */
    public void settest(int nb)
    {
        if(zonecalc.getText().equals("")){
            zonecalc.setText(""+nb);
        }else
        {
            zonecalc.setText(zonecalc.getText() + "\n+" + nb);
        }
    }

    /**
     * Cette méthode sert a afficher le résultat du calcul
     */
    public void setresult()
    {
        zonecalc.setText(zonecalc.getText()+ "\n________\n" + result);
    }

    /**
     * Vide la zone de texte dans l'additionneur
     */
    public void effacerFenetre()
    {
        zonecalc.setText("");
        result=0;
    }



}
