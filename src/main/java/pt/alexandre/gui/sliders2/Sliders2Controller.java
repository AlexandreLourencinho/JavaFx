package pt.alexandre.gui.sliders2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

public class Sliders2Controller
{

    public Slider slideRouge;
    public Slider slideVert;
    public Slider slideBleu;
    public Pane paneAff;
    public double bleu, vert, rouge;

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

    public void getCouleur()
    {
        paneAff.setStyle("-fx-background-color: rgb("+rouge+","+vert+","+bleu+")");
    }




}
