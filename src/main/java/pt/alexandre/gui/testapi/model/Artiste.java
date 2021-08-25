package pt.alexandre.gui.testapi.model;

import org.json.JSONObject;

public class Artiste
{
    private int artist_id;
    private String artist_name;

    public Artiste()
    {
    }

    public Artiste(JSONObject json)
    {
        this.artist_id = json.getInt("artist_id");
        this.artist_name = json.getString("artist_name");
    }

    public int getArtist_id()
    {
        return artist_id;
    }

    public void setArtist_id(int artist_id)
    {
        this.artist_id = artist_id;
    }

    public String getArtist_name()
    {
        return artist_name;
    }

    public void setArtist_name(String artist_name)
    {
        this.artist_name = artist_name;
    }

    public String toString()
    {
        return this.artist_name + " " + this.artist_id;
    }


}
