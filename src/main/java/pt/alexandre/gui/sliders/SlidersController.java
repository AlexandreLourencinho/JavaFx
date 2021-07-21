package pt.alexandre.gui.sliders;

import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

public class SlidersController
{
    public Slider slideRouge;
    public Slider slideVert;
    public Slider slideBleu;
    public Pane paneAff;


    public void changeCouleur()
    {
        double rouge,vert,bleu;
        rouge = slideRouge.getValue();
        vert = slideVert.getValue();
        bleu=slideBleu.getValue();
        paneAff.setStyle("-fx-background-color: rgb("+rouge+","+vert+","+bleu+")");
    }
}