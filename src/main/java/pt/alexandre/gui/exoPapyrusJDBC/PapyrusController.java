package pt.alexandre.gui.exoPapyrusJDBC;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import pt.alexandre.gui.exoPapyrusJDBC.model.RequetePrepares;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PapyrusController
{
    @FXML
    public TextField codeFou;
    @FXML
    public TextField nomFou;
    @FXML
    public TextField addrFou;
    @FXML
    public TextField cpFou;
    @FXML
    public TextField villeFou;
    @FXML
    public TextField contactFou;


    public void recupInfo() throws SQLException
    {
        boolean resOk = false;
        if(codeFou.getText().matches("^\\p{Digit}+$"))
        {
            RequetePrepares req= new RequetePrepares();
            int code = Integer.parseInt(codeFou.getText());

            ResultSet resultat = req.selectUn(code);

            while (resultat.next())
            {
                resOk = true;
                nomFou.setText(resultat.getString("nomfou"));
                villeFou.setText(resultat.getString("vilfou"));
                cpFou.setText(resultat.getString("posfou"));
                addrFou.setText(resultat.getString("ruefou"));
                contactFou.setText(resultat.getString("confou"));
            }
            if (!resOk) {
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("aucun résultat.");
                alert.showAndWait();
            }
            req.detruitTout();
        }else{
            Alert alert =  new Alert(Alert.AlertType.WARNING);
            alert.setContentText("ne rentrez que des chiffres");
            alert.showAndWait();
        }

    }




}
