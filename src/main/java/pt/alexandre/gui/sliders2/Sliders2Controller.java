package pt.alexandre.gui.sliders2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

/**
 * Version du slider utilisant les addlistener - écouteurs
 * @see ObservableValue
 * @author Alexandre Lourencinho
 */
public class Sliders2Controller
{

    public Slider slideRouge;
    public Slider slideVert;
    public Slider slideBleu;
    public Pane paneAff;
    public double bleu, vert, rouge;

    /**
     * initialisation à l'ouverture de la fenêtre des écouteurs sur les 3 slider
     * au changement de valeur, la récupère et la stock dans les variables bleu vert et rouge.
     * la fonction getCouleur() y est appelée afin de mettre à jour la couleur du pane
     * @see Sliders2Controller#getCouleur()
     */
    public void initialize()
    {

        slideBleu.valueProperty().addListener(
                new ChangeListener<Number>()
                {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
                    {
                        bleu = (double) newValue;
                        getCouleur();
                    }
                }
        );
        slideRouge.valueProperty().addListener(
                new ChangeListener<Number>()
                {

                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
                    {
                        rouge = slideRouge.getValue();
                        getCouleur();
                    }
                }

        );
        slideVert.valueProperty().addListener(
                new ChangeListener<Number>()
                {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
                    {
                        vert = slideVert.getValue();
                        getCouleur();
                    }
                }
        );
    }

    /**
     * récupère les trois valeurs rouge bleu et vert définies en continue par les écouteurs sur les sliders
     * et définit la couleur du pane via un -fx-background-color : RGB
     */
    public void getCouleur()
    {
        paneAff.setStyle("-fx-background-color: rgb("+rouge+","+vert+","+bleu+")");
    }




}
