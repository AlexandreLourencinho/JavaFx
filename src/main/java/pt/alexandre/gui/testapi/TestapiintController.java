package pt.alexandre.gui.testapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonString;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.json.JSONArray;
import org.json.JSONObject;
import pt.alexandre.gui.testapi.model.Artiste;
import pt.alexandre.gui.testapi.model.Disque;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

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
        String url = "http://127.0.0.1:3000/api/menu/objets/";
        String apiKey ="";
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
            chmpAff.appendText(jo.toString());

        }
        ArrayList<Disque> listeD = new ArrayList<>();
        for(int i = 0; i<jo.length();i++){
            JSONObject test = jo.getJSONObject(i);
            Disque disque = new Disque(test);
            System.out.println(disque);
            listeD.add(disque);

        }
        System.out.println(listeD);
        in.close();

    }


    public void testApiTrois() throws IOException, InterruptedException
    {

        HashMap<String, String> values = new HashMap<>();
        values.put("test1","vrai");

        ObjectMapper objMapper = new ObjectMapper();
        String corpsRequete = objMapper.writeValueAsString(values);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest requete = HttpRequest.newBuilder().version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create("http://127.0.0.1:8005/accueil/pageAccueil/"))
                .POST(HttpRequest.BodyPublishers.ofString(corpsRequete))
                .build();
        HttpResponse<String> reponse = client.send(requete,HttpResponse.BodyHandlers.ofString());
        System.out.println(reponse.body());

        JSONArray joa = new JSONArray(reponse.body());
        ArrayList<Artiste> tabArtiste= new ArrayList<>();
        chmpAff.clear();
        for(int i =0 ; i<joa.length();i++){
            chmpAff.appendText(joa.getJSONObject(i).toString());
            JSONObject jo = joa.getJSONObject(i);
            Artiste artiste = new Artiste(jo);
            System.out.println(artiste);
            tabArtiste.add(artiste);
        }
        System.out.println(tabArtiste);



    }

}
