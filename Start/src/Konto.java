import java.util.ArrayList;

class Konto {
    private String kontoinhaber;
    private String bankleitzahl;
    private String kontonummer;
    private double kontofuehrungsgebuehren;
    private double kontostand;
    private String kontoTyp;

    private ArrayList<Girokonto> girokontos = new ArrayList<Girokonto>();
    private ArrayList<Sparkonto> sparkontos = new ArrayList<Sparkonto>();
    private ArrayList<Kreditkonto> kreditkontos = new ArrayList<Kreditkonto>();

    public Konto(String kontoinhaber, String bankleitzahl, String kontonummer,
                 double kontofuehrungsgebuehren, double kontostand, String kontoTyp) {
        this.kontoinhaber = kontoinhaber;
        this.bankleitzahl = bankleitzahl;
        this.kontonummer = kontonummer;
        this.kontofuehrungsgebuehren = kontofuehrungsgebuehren;
        this.kontostand = kontostand;
        this.kontoTyp = kontoTyp;
    }

    public String getKontoTyp() {
        return kontoTyp;
    }

    public void setGirokontos(Girokonto girokontos) {
        this.girokontos.add(girokontos);
    }
    public void setKreditkontos(Kreditkonto kreditkontos) {
        this.kreditkontos.add(kreditkontos);
    }
    public void setSparkontos(Sparkonto sparkontos) {
        this.sparkontos.add(sparkontos);
    }

    public float getGirokontoByKontonummer(int number) {
        for (int i = 0; i < this.girokontos.size(); i++) {
            Girokonto x = (Girokonto) this.girokontos.get(i);
            if (Integer.parseInt(x.getKontonummer()) == number) {
                return x.getÜberziehungsrahmen();
            }
        }
        return 0;
    }
    public float getKreditkontoByKontonummer(int number) {
        for (int i = 0; i < this.kreditkontos.size(); i++) {
            Kreditkonto x = (Kreditkonto) this.kreditkontos.get(i);
            if (Integer.parseInt(x.getKontonummer()) == number) {
                return x.getÜberziehungsrahmen();
            }
        }
        return 0;
    }

    public void getGirokontos() {
        for (int i = 0; i < this.girokontos.size(); i++) {
            Girokonto x = (Girokonto) this.girokontos.get(i);
            x.kontoauszug();
        }
    }
    public void getKreditkontos() {
        for (int i = 0; i < this.kreditkontos.size(); i++) {
            Kreditkonto x = (Kreditkonto) this.kreditkontos.get(i);
            x.kontoauszug();
        }
    }
    public void getSparkontos() {
        for (int i = 0; i < this.sparkontos.size(); i++) {
            Sparkonto x = (Sparkonto) this.sparkontos.get(i);
            x.kontoauszug();
        }
    }

    public String getKontonummer() {
        return kontonummer;
    }

    public void einzahlen(double betrag) {
        kontostand += betrag;
        System.out.println("Einzahlung erfolgreich. Neuer Kontostand: " + kontostand);
    }

    public void abheben(double betrag, double ueberziehungsrahmen) {

        if (betrag > kontostand + ueberziehungsrahmen) {
            System.out.println("Fehler: Nicht genug Geld auf dem Konto.");
        } else {
            kontostand -= betrag;
            System.out.println("Abhebung erfolgreich. Neuer Kontostand: " + kontostand);
        }
    }

    public void kontoauszug() {
        System.out.println("------ Kontoauszug -----");
        System.out.println("Kontoinhaber: " + kontoinhaber);
        System.out.println("Bankleitzahl: " + bankleitzahl);
        System.out.println("Kontonummer: " + kontonummer);
        System.out.println("Kontoführungsgebühren: " + kontofuehrungsgebuehren);
        System.out.println("Kontostand: " + kontostand);
        System.out.println("------------------------");
    }
}
