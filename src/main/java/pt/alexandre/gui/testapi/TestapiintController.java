package pt.alexandre.gui.testapi;

import com.mysql.cj.xdevapi.JsonString;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestapiintController
{

    @FXML
    private TextArea chmpAff;


    public void testApi() throws IOException
    {
        String url = "http://data.fixer.io/api/latest?access_key=";
        String apiKey ="dd53281012dd7d1206c69bdda3058ad6";
        String urlGo = url+ apiKey;


        URL obj = new URL(urlGo);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        int responseCode = con.getResponseCode();
        System.out.println("\nEnvoie requête 'GET' par l’URL"+ urlGo);
        System.out.println("Réponse reçu: "+responseCode);
        BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine())!= null){
            JSONObject jo = new JSONObject(inputLine);
            response.append(jo.toString());
            //affiche ce que nous avons récupéré à l'écran
            chmpAff.appendText(jo.toString()+"\n");
        }

        System.out.println(response);
        in.close();
    }


    public void testApiDeux() throws IOException
    {
        String url = "http://127.0.0.1:8005";
        String apiKey ="/";
        String urlGo = url+ apiKey;


        URL obj = new URL(urlGo);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        int responseCode = con.getResponseCode();
        System.out.println("\nEnvoie requête 'GET' par l’URL"+ urlGo);
        System.out.println("Réponse reçu: "+responseCode);
        BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        JSONArray jo = new JSONArray();
        while ((inputLine = in.readLine())!= null){
            jo = new JSONArray(inputLine);
            response.append(jo.toString());
//            affiche ce que nous avons récupéré à l'écran
            chmpAff.appendText(jo.toString());
//            response.append(inputLine);
//            chmpAff.appendText(inputLine);
        }
        JSONObject json = new JSONObject(jo);
//        json.
        for(Object j : jo){
            System.out.println(j.toString());
            System.out.println(j.getClass());
            System.out.println(j.equals(obj));
        }
        System.out.println(jo.getJSONObject(0).get("disc_genre"));
        System.out.println(response);
        in.close();

    }

}
