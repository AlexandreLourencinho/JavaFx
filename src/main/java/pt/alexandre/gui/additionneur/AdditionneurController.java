package pt.alexandre;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class AdditionneurController
{

    public Button boutonun;

    public Button boutondeux;
    public Button boutontrois;
    public Button boutonquatre;
    public Button boutoncinq;
    public Button boutonsix;
    public Button boutonsept;
    public Button boutonhuit;
    public Button boutonneuf;
    public Button boutonzero;
    public Button boutonresult;
    public Button boutonVider;
    public Stage stagefen;

    public TextArea zonecalc;

    private int result = 0;

    public void initialize()
    {
        zonecalc.setEditable(false);
    }

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

    public void settest(int nb)
    {
        if(zonecalc.getText().equals("")){
            zonecalc.setText(""+nb);
        }else
        {
            zonecalc.setText(zonecalc.getText() + "\n+" + nb);
        }
    }

    public void setresult()
    {
        zonecalc.setText(zonecalc.getText()+ "\n________\n" + result);
    }

    public void effacerFenetre()
    {
        zonecalc.setText("");
        result=0;
    }



}
