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

    public Konto(String kontoinhaber,
                 double kontofuehrungsgebuehren, double kontostand, String kontoTyp) {
        this.kontoinhaber = kontoinhaber;
        this.bankleitzahl = "AT" + String.valueOf((int) (Math.random() * 1000000000));
        this.kontonummer = String.valueOf((int) (Math.random() * 1000000000));
        this.kontofuehrungsgebuehren = kontofuehrungsgebuehren;
        this.kontostand = kontostand;
        this.kontoTyp = kontoTyp;
    }

    public String getKontoTyp() {
        return kontoTyp;
    }

    public String getKontoinhaber() {
        return kontoinhaber;
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

    public void deleteGirokontoByKontonummer(int number) {
        for (int i = 0; i < this.girokontos.size(); i++) {
            Girokonto x = (Girokonto) this.girokontos.get(i);
            if (Integer.parseInt(x.getKontonummer()) == number) {
                this.girokontos.remove(i);
            }
        }
    }

    public void deleteKreditkontoByKontonummer(int number) {
        for (int i = 0; i < this.kreditkontos.size(); i++) {
            Kreditkonto x = (Kreditkonto) this.kreditkontos.get(i);
            if (Integer.parseInt(x.getKontonummer()) == number) {
                this.kreditkontos.remove(i);
            }
        }
    }

    public void deleteSparkontoByKontonummer(int number) {
        for (int i = 0; i < this.sparkontos.size(); i++) {
            Sparkonto x = (Sparkonto) this.sparkontos.get(i);
            if (Integer.parseInt(x.getKontonummer()) == number) {
                this.sparkontos.remove(i);
            }
        }
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

    public void abheben(double betrag) {

        if (betrag > kontostand) {
            System.out.println("Fehler: Nicht genug Geld auf dem Konto.");
        } else {
            kontostand -= betrag;
            System.out.println("Abhebung erfolgreich. Neuer Kontostand: " + kontostand);
        }
    }

    public void überweisen(double betrag, Konto konto) {
        if (betrag > kontostand) {
            System.out.println("Fehler: Nicht genug Geld auf dem Konto.");
        } else {
            kontostand -= betrag;
            konto.einzahlen(betrag);
            System.out.println("Überweisung erfolgreich. Neuer Kontostand: " + kontostand);
        }
    }

    public String kontoauszug() {
        return "Kontoinhaber: " + kontoinhaber + "\n" +
                "Bankleitzahl: " + bankleitzahl + "\n" +
                "Kontonummer: " + kontonummer + "\n" +
                "Kontoführungsgebühren: €" + kontofuehrungsgebuehren + "\n" +
                "Kontostand: €" + kontostand + "\n" +
                "KontoTyp: " + kontoTyp + "\n";
    }
}
