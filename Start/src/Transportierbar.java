public interface Transportierbar
{
    float MAX_GEWICHT_PRO_FLAECHE = 29.99f;

    // alle Methoden in Interfaces sind implizit public und abstract
    int gewicht();
    int laenge();
    int breite();
    int hoeheCm();

    boolean zerbrechlich();
    boolean stapelbar();
    String beschriftung();

    public void berechneVolumen();
}
