public class Schaf implements Transportierbar{
    int gewicht;
    int laenge;
    int breite;
    int hoehe;
    boolean zerbrechlich;
    boolean stapelbar;
    String beschriftung;


    @Override
    public int gewicht() {
        return gewicht;
    }

    @Override
    public int laenge() {
        return laenge;
    }

    @Override
    public int breite() {
        return breite;
    }

    @Override
    public int hoeheCm() {
        return hoehe;
    }

    @Override
    public boolean zerbrechlich() {
        return zerbrechlich;
    }

    @Override
    public boolean stapelbar() {
        return stapelbar;
    }

    @Override
    public String beschriftung() {
        return beschriftung;
    }

    @Override
    public void berechneVolumen() {
        System.out.println("Volumen: " + laenge() * breite() * hoeheCm());
    }
}
