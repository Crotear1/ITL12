public class Main {
    public static void main(String[] args) {
        Schaf schaf = new Schaf();
        schaf.gewicht = 100;
        schaf.laenge = 1;
        schaf.breite = 1;
        schaf.hoehe = 1;
        schaf.zerbrechlich = false;
        schaf.stapelbar = false;
        schaf.beschriftung = "Schaf";
        schaf.berechneVolumen();

        Tisch tisch = new Tisch();
        tisch.gewicht = 5;
        tisch.laenge = 1;
        tisch.breite = 1;
        tisch.hoehe = 1;
        tisch.zerbrechlich = false;
        tisch.stapelbar = false;
        tisch.beschriftung = "Tisch";
        tisch.berechneVolumen();

        System.out.println(schaf.beschriftung+ " transportierbar: "+ Transport.transportMachbar(schaf));
        System.out.println(schaf.beschriftung+ " transportierbar: "+ Transport.transportMachbar(tisch));
    }
}