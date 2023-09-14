import java.util.ArrayList;
import java.util.Scanner;

class Konto {
    private String kontoinhaber;
    private String bankleitzahl;
    private String kontonummer;
    private double ueberziehungsrahmen;
    private double kontofuehrungsgebuehren;
    private double kontostand;
    private String kontoart;

    public Konto(String kontoinhaber, String bankleitzahl, String kontonummer, double ueberziehungsrahmen,
                 double kontofuehrungsgebuehren, double kontostand, String kontoart) {
        this.kontoinhaber = kontoinhaber;
        this.bankleitzahl = bankleitzahl;
        this.kontonummer = kontonummer;
        this.ueberziehungsrahmen = ueberziehungsrahmen;
        this.kontofuehrungsgebuehren = kontofuehrungsgebuehren;
        this.kontostand = kontostand;
        this.kontoart = kontoart;
    }

    public void einzahlen(double betrag) {
        kontostand += betrag;
        System.out.println("Einzahlung erfolgreich. Neuer Kontostand: " + kontostand);
    }

    public void abheben(double betrag) {
        if (betrag > kontostand + ueberziehungsrahmen) {
            System.out.println("Fehler: Nicht genug Geld auf dem Konto.");
        } else {
            kontostand -= betrag;
            System.out.println("Abhebung erfolgreich. Neuer Kontostand: " + kontostand);
        }
    }

    public void kontoauszug() {
        System.out.println("Kontoinhaber: " + kontoinhaber);
        System.out.println("Bankleitzahl: " + bankleitzahl);
        System.out.println("Kontonummer: " + kontonummer);
        System.out.println("Überziehungsrahmen: " + ueberziehungsrahmen);
        System.out.println("Kontoführungsgebühren: " + kontofuehrungsgebuehren);
        System.out.println("Kontostand: " + kontostand);
        System.out.println("Kontoart: " + kontoart);
    }
}
