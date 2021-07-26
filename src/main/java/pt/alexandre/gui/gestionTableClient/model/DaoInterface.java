package pt.alexandre.gui.gestionTableClient.model;

import java.util.ArrayList;

public interface DaoInterface<T>
{
    public boolean ajouter(T o);
    public boolean modifier(T o);
    public boolean supprimer(int id);
    public T trouverUn(int id);
    public ArrayList<T> liste();

}
