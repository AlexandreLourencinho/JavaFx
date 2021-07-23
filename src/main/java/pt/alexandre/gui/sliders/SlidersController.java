package pt.alexandre.gui.sliders;

import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

/**
 * Version simplifiée du slider de couleur : la mise à jour en direct du RGB est assurée par la fonction
 * "on mouse dragged" trouvée dans scene builder
 */
public class SlidersController
{
    public Slider slideRouge;
    public Slider slideVert;
    public Slider slideBleu;
    public Pane paneAff;


    /**
     * La fonction qui met à jour la couleur d'un fond selon les paramètres des différents sliders
     * récupère une valeur de 0 a 255 pour le rouge, le vert et le bleu, et définit la couleur du fond
     * du pane en fonctions de celles-ci
     * @see Pane
     */
    public void changeCouleur()
    {
        double rouge,vert,bleu;
        rouge = slideRouge.getValue();
        vert = slideVert.getValue();
        bleu=slideBleu.getValue();
        paneAff.setStyle("-fx-background-color: rgb("+rouge+","+vert+","+bleu+")");
    }
}