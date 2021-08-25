package pt.alexandre.gui.testapi.model;

import org.json.JSONObject;

public class Disque
{

    private String disc_genre;
    private String disc_title;
    private Float disc_price;
    private String disc_label;
    private int  disc_year;
    private String disc_picture;
    private int disc_id;
    private int artist_id;

    public Disque(String disc_genre, String disc_title, Float disc_price, String disc_label, int disc_year, String disc_picture, int disc_id, int artist_id)
    {
        this.disc_genre = disc_genre;
        this.disc_title = disc_title;
        this.disc_price = disc_price;
        this.disc_label = disc_label;
        this.disc_year = disc_year;
        this.disc_picture = disc_picture;
        this.disc_id = disc_id;
        this.artist_id = artist_id;
    }

    public Disque()
    {
    }

    public Disque(JSONObject json){
        this.disc_genre = json.getString("disc_genre");
        this.disc_title = json.getString("disc_title");
        this.disc_price = json.getFloat("disc_price");
        this.disc_label = json.getString("disc_label");;
        this.disc_year = json.getInt("disc_year");
        this.disc_picture = json.getString("disc_picture");;
        this.disc_id = json.getInt("disc_id");
        this.artist_id = json.getInt("artist_id");
    }

    public String getDisc_genre()
    {
        return disc_genre;
    }

    public void setDisc_genre(String disc_genre)
    {
        this.disc_genre = disc_genre;
    }

    public String getDisc_title()
    {
        return disc_title;
    }

    public void setDisc_title(String disc_title)
    {
        this.disc_title = disc_title;
    }

    public Float getDisc_price()
    {
        return disc_price;
    }

    public void setDisc_price(Float disc_price)
    {
        this.disc_price = disc_price;
    }

    public String getDisc_label()
    {
        return disc_label;
    }

    public void setDisc_label(String disc_label)
    {
        this.disc_label = disc_label;
    }

    public int getDisc_year()
    {
        return disc_year;
    }

    public void setDisc_year(int disc_year)
    {
        this.disc_year = disc_year;
    }

    public String getDisc_picture()
    {
        return disc_picture;
    }

    public void setDisc_picture(String disc_picture)
    {
        this.disc_picture = disc_picture;
    }

    public int getDisc_id()
    {
        return disc_id;
    }

    public void setDisc_id(int disc_id)
    {
        this.disc_id = disc_id;
    }

    public int getArtist_id()
    {
        return artist_id;
    }

    public void setArtist_id(int artist_id)
    {
        this.artist_id = artist_id;
    }

    public String toString()
    {
        return this.disc_title + " " + this.disc_year;
    }
}
