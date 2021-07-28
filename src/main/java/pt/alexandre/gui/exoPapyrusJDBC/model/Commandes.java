package pt.alexandre.gui.exoPapyrusJDBC.model;

import java.util.ArrayList;

public class Commandes
{
    private int numcom;
    private String obscom;
    private String datecom;

    public Commandes(int numcom,String obscom, String datecom)
    {
        this.numcom=numcom;
        this.obscom=obscom;
        this.datecom=datecom;
    }

    public Commandes()
    {

    }

    @Override
    public String toString()
    {
        return ""+this.numcom+" " + this.obscom + " " + this.datecom + "\n";
    }

    public void setNumcom(int numcom)
    {
        this.numcom = numcom;
    }

    public void setObscom(String obscom)
    {
        this.obscom = obscom;
    }

    public void setDatecom(String datecom)
    {
        this.datecom = datecom;
    }
}
