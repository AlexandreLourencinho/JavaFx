package pt.alexandre.gui.gestionTableClient.tools;

public class CheckForm
{
    public boolean checkFormClients(String nom, String prenom, String ville)
    {
        return nom.matches("^[\\p{Upper}][\\p{Lower}]+$") && prenom.matches(
                "^[\\p{Upper}][\\p{Lower}]+$") && !ville.matches("[\\p{Digit}]");
    }
}
