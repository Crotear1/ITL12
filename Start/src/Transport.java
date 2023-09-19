public class Transport
{
    public static boolean transportMachbar (Transportierbar tDetails)
    {
        int gewicht = tDetails.gewicht();
        int laenge = tDetails.laenge();
        int breite = tDetails.breite();

        float gewichtProFlaeche = (float)gewicht/(laenge*breite);

        if (gewichtProFlaeche < tDetails.MAX_GEWICHT_PRO_FLAECHE)
        {
            return true;
        }
        return false;
    }
}
