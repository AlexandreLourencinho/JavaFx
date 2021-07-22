package pt.alexandre.gui.leTranscodeur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.germain.tool.ManaBox;
import pt.alexandre.gui.leTranscodeur.tools.GenClef;
import pt.alexandre.gui.leTranscodeur.tools.Transcoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LeTranscodeurController
{

    public Label labelClefSauvee;
    @FXML
    private TextField txtClair;
    @FXML
    private TextField txtClef;
    @FXML
    private TextField txtCode;
    @FXML
    private Button btnEncode;
    @FXML
    private Button genClef;
    @FXML
    private Button btnDecode;

    public void genererClef()
    {
        GenClef gen = new GenClef();
        txtClef.setText(ManaBox.encrypt(gen.randomKey()));
    }

    public void encoderMessage()
    {
        Transcoder trans = new Transcoder(txtClef.getText());
        System.out.println(txtClef.getText());
        txtCode.setText(trans.encode(txtClair.getText()));
    }

    public void decoderMessage()
    {
        Transcoder trans = new Transcoder(txtClef.getText());
        txtClair.setText(trans.decode(txtCode.getText()));
    }

    public void viderChamps()
    {
        txtCode.clear();
        txtClef.clear();
        txtClair.clear();
    }

    public void sauverClef()
    {
        String dir = System.getProperty("user.dir");
        int rand = (int) (100*Math.random());
        String fichier = "fichierclef"+rand+".txt";
        Path fich = Paths.get(dir,fichier);
        try
        {
            Files.writeString(fich,txtClef.getText(), StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            labelClefSauvee.setText("Votre clef a été sauvegardée dans le fichier "+fichier);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
